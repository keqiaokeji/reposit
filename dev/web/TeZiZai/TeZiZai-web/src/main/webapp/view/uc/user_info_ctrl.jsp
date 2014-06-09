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
<script src="<%=path%>/bootstrap/assets/js/jqGrid/jquery.jqGrid.js"></script>
<%--<script src="<%=path%>/bootstrap/assets/js/jqGrid/jquery.jqGrid.min.js"></script>--%>
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
        jsonReader: {root: "dataRows", id: "userId"},//root:设置记录集的属性名称，id:设置主键的属性名称
        editurl: app.baseUrlSvc + "/admin/uc/editUserInfo.do",//定义对form编辑时的url（增删改的时候使用）
        url: app.baseUrlSvc + "/admin/uc/getUserInfoList.do",
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: pager_selector,


        altRows: true,
        caption: "用户信息维护",
        viewrecords: true,
        height: 392,
        colNames: ['操作', 'ID', '用户名', '密码', '邮箱', '手机号', '生日', '性别', '用户状态', '注册日期'],
        colModel: [
            {name: 'myac', index: 'myac', width: 80, fixed: true, sortable: false, resize: false, search: false,
                formatter: 'actions',
                formatoptions: {
                    keys: true,//如果是true则可以通过点击Enter键保存
                    delOptions: {recreateForm: true, beforeShowForm: beforeDeleteCallback}
//                    editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
                }
            },
            {name: 'userId', index: 'userId', hidden: true},
            {name: 'username', index: 'username', width: 100, editable: true, editoptions: {size: "20", maxlength: "30"}},
            {name: 'password', index: 'password', width: 100, editable: true, sortable: false, search: false, editoptions: {size: "20", maxlength: "30"}},
            {name: 'email', index: 'email', width: 150, editable: true, editoptions: {size: "20", maxlength: "50"}},
            {name: 'mobilePhone', index: 'mobile_phone', width: 100, editable: true, editoptions: {size: "11", maxlength: "11"}, editrules: {custom: true, custom_func: mobilePhoneCheck} },
            {name: 'birthdayContent', index: 'birthday', width: 90, editable: true, search: false, sortable: true, type: "date", unformat: EditBirthday},
            {name: 'sex', index: 'sex', width: 70, editable: true, edittype: "checkbox", search: false, editoptions: {value: "帅哥:美女"}, unformat: aceSwitch},
            {name: 'status', index: 'status', width: 90, editable: true, edittype: "select", search: false, formatter: formartStatus, editoptions: {value: "STATUS_NORMOR:正常;STATE_FORBIDDEN:禁用;STATE_FREEZE:冻结"}},
            {name: 'createTime', index: 'create_time', width: 110, editable: false, search: false, type: "date", sorttype: "date", formatter: formartCreateTime}
        ],


//        toppager: true,
        multiselect: true,
        //multikey: "ctrlKey",
        multiboxonly: true,

        loadComplete: function () {//数据加载完成之后调用
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

    //switch element when editing inline
    function aceSwitch(cellvalue, options, cell) {
        setTimeout(function () {
            $(cell).find('input[name=sex]')
                    .wrap('<label class="inline" />')
                    .addClass('ace ace-switch ace-switch-5')
                    .after('<span class="lbl"></span>');
        }, 0);
    }

    //enable datepicker
    function EditBirthday(cellvalue, options, cell) {
        setTimeout(function () {
            $(cell).find('input[name=birthdayContent]')
                    .datepicker({format: 'yyyy-mm-dd', autoclose: false});
        }, 0);
    }

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

    //显示值的时候做格式化处理
    function formartCreateTime(cellValue, options, cell) {
        return new Date(cellValue).format("yyyy-MM-dd hh:mm:ss");
    }

    //新增或修改时提交之前进行验证
    function mobilePhoneCheck(value, colname) {
//      return [false, "Please enter value between 0 and 20"];
        return [true, ""];
    }

    var fn_editSubmit = function (response, postdata) {
        var json = response.responseText;
        if(!app.isEmpty(json)){
            return [false, json];
        }
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
                closeAfterEdit: true,
                recreateForm: true,
                afterSubmit: fn_editSubmit,
                beforeShowForm: function (e) {
                    var form = $(e[0]);
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />');
                    style_edit_form(form);
                }
            }
            ,
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
        //enable datepicker on "birthdayContent" field and switches for "sex" field
        form.find('input[name=birthdayContent]').datepicker({format: 'yyyy-mm-dd', autoclose: true});
        form.find('input[name=sex]')
                .addClass('ace ace-switch ace-switch-6')
                .after('<span class="lbl"></span>');

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
