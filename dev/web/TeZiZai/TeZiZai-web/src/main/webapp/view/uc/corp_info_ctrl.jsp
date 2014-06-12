<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/view/home/home_head.jsp"/>

    <%--<link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/jquery-ui-1.10.3.full.min.css"/>--%>
    <%--<link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/datepicker.css"/>--%>
    <%--<link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/ui.jqgrid.css"/>--%>

</head>

<body>

<jsp:include page="/view/home/home_navbar.jsp"/>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <jsp:include page="/view/home/home_navigation.jsp"/>


        <div class="row">
            <div class="col-xs-12">
                <table id="grid-table"></table>

                <div id="grid-pager"></div>

                <script type="text/javascript">
                    var $path_base = "/";//this will be used in gritter alerts containing images
                </script>

                <!-- PAGE CONTENT ENDS -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->


    </div>
    <!-- /.page-content -->
</div>
<!-- /.main-content -->

<jsp:include page="/view/home/home_settings.jsp"/>

</div>
<!-- /.main-container-inner -->

<jsp:include page="/view/home/home_scroll_top.jsp"/>

</div><!-- /.main-container -->

<jsp:include page="/view/home/home_compatibility.jsp"/>

<!-- page specific plugin scripts -->

<script src="<%=path%>/bootstrap/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/jqGrid/i18n/grid.locale-cn.js"></script>

<!-- ace scripts -->

<script src="<%=path%>/bootstrap/assets/js/ace-elements.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script src="<%=path%>/resources/js/app_jqgrid.js"></script>
<script type="text/javascript">
    jQuery(function ($) {
        var grid_selector = "#grid-table";
        var pager_selector = "#grid-pager";

        jQuery(grid_selector).jqGrid({
            //direction: "rtl",
            mtype: "POST",//请求的类型：(“POST” or “GET”)	默认GET
            datatype: "json",//表格可以被接受的数据类型：xml，xmlstring，json，local，function
            jsonReader: {root: "dataRows", id: "corpId"},//root:设置记录集的属性名称，id:设置主键的属性名称
            editurl: app.baseUrlSvc + "/root/uc/editCorpInfo.do?token=" + app.getTokenByCookie(),//定义对form编辑时的url（增删改的时候使用）
            url: app.baseUrlSvc + "/root/uc/getCorpInfoList.do?token=" + app.getTokenByCookie(),
            rowNum: 10,
            rowList: [10, 20, 30],
            pager: pager_selector,

            altRows: true,
            caption: "用户信息维护",
            viewrecords: true,
            height: 392,
            colNames: ['操作', 'ID', '公司名称', '公司编号', '公司状态', '注册日期'],
            colModel: [
                {name: 'myac', index: 'myac', width: 80, fixed: true, sortable: false, resize: false, search: false,
                    formatter: 'actions',
                    formatoptions: {
                        keys: true,
                        delOptions: {recreateForm: true, beforeShowForm: beforeDeleteCallback}
                        //editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
                    }
                },
                {name: 'corpId', index: 'corp_id', hidden: true},
                {name: 'corpName', index: 'corp_name', width: 300, editable: true, editoptions: {size: "20", maxlength: "30"}},
                {name: 'corpCode', index: 'corp_code', width: 100, editable: true, sortable: false, search: false, editoptions: {size: "20", maxlength: "30"}},
                {name: 'status', index: 'status', width: 90, editable: true, edittype: "select", search: false, formatter: formartStatus, editoptions: {value: "STATUS_NORMOR:正常;STATE_FORBIDDEN:禁用;STATE_FREEZE:冻结"}},
                {name: 'createTime', index: 'create_time', width: 110, editable: false, search: false, type: "date", sorttype: "date", formatter: formartCreateTime}
            ],


            //toppager: true,

            multiselect: true,
            //multikey: "ctrlKey",
            multiboxonly: true,

            loadComplete: function () {
                var table = this;
                setTimeout(function () {
                    appJqgrid.styleCheckbox(table);
                    appJqgrid.updateActionIcons(table);
                    appJqgrid.updatePagerIcons(table);
                    appJqgrid.enableTooltips(table);
                }, 0);
            },
            autowidth: true
        });

        function formartStatus(cellValue, options, cell) {
            var status = "未知";
            if (cellValue == "STATUS_NORMOR" || cellValue == "正常") {
                status = "正常";
            } else if (cellValue == "STATE_FORBIDDEN" || cellValue == "禁用") {
                status = "禁用";
            } else if (cellValue == "STATE_FREEZE" || cellValue == "冻结") {
                status = "冻结";
            }
            return status;
        }

        function formartCreateTime(cellValue, options, cell) {
            return new Date(cellValue).format("yyyy-MM-dd hh:mm:ss");
        }


        //navButtons
        jQuery(grid_selector).jqGrid('navGrid', pager_selector,
                { 	//navbar options
                    edit: true,
                    editicon: 'icon-pencil blue',
                    add: true,
                    addicon: 'icon-plus-sign purple',
                    del: true,
                    delicon: 'icon-trash red',
                    search: true,
                    searchicon: 'icon-search orange',
                    refresh: true,
                    refreshicon: 'icon-refresh green',
                    view: true,
                    viewicon: 'icon-zoom-in grey'
                },
                {
                    //edit record form
                    //closeAfterEdit: true,
                    recreateForm: true,
                    beforeShowForm: function (e) {
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
                        style_edit_form(form);
                    }
                },
                {
                    //new record form
                    closeAfterAdd: true,
                    recreateForm: true,
                    viewPagerButtons: false,
                    beforeShowForm: function (e) {
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
                        style_edit_form(form);
                    }
                },
                {
                    //delete record form
                    recreateForm: true,
                    beforeShowForm: function (e) {
                        var form = $(e[0]);
                        if (form.data('styled')) return false;

                        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
                        appJqgrid.style_delete_form(form);

                        form.data('styled', true);
                    },
                    onClick: function (e) {
                        alert(1);
                    }
                },
                {
                    //search form
                    recreateForm: true,
                    afterShowSearch: function (e) {
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />');
                        appJqgrid.style_search_form(form);
                    },
                    afterRedraw: function () {
                        appJqgrid.style_search_filters($(this));
                    },
                    multipleSearch: true
                },
                {
                    //view record form
                    recreateForm: true,
                    beforeShowForm: function (e) {
                        var form = $(e[0]);
                        form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />');
                    }
                }
        );

        function beforeDeleteCallback(e) {
            var form = $(e[0]);
            if (form.data('styled')) return false;
            form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
            appJqgrid.style_delete_form(form);
            form.data('styled', true);
        }

        function beforeEditCallback(e) {
            var form = $(e[0]);
            form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
            style_edit_form(form);
        }

        function style_edit_form(form) {
            //update buttons classes
            var buttons = form.next().find('.EditButton .fm-button');
            buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
            buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
            buttons.eq(1).prepend('<i class="icon-remove"></i>');

            buttons = form.next().find('.navButton a');
            buttons.find('.ui-icon').remove();
            buttons.eq(0).append('<i class="icon-chevron-left"></i>');
            buttons.eq(1).append('<i class="icon-chevron-right"></i>');
        }


    });
</script>

</body>
</html>
