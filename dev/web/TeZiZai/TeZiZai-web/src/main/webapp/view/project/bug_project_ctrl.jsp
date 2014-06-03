<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/view/home/home_head.jsp"/>

    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/jquery-ui-1.10.3.full.min.css"/>
    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/datepicker.css"/>
    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/ui.jqgrid.css"/>
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
                <!-- PAGE CONTENT BEGINS -->

                <div class="alert alert-info">
                    <i class="icon-hand-right"></i>

                    该数据为测试数据，请从服务器上获取数据...
                    <button class="close" data-dismiss="alert">
                        <i class="icon-remove"></i>
                    </button>
                </div>

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

</div>
<!-- /.main-container -->

<jsp:include page="/view/home/home_compatibility.jsp"/>

<!-- page specific plugin scripts -->

<script src="<%=path%>/bootstrap/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/jqGrid/i18n/grid.locale-cn.js"></script>

<!-- ace scripts -->

<script src="<%=path%>/bootstrap/assets/js/ace-elements.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
var grid_data =
        [
            {projectId: "1", projectName: "Desktop Computer", note: "note", useAble: "启用", projectCode: "FedEx", createTime: "2007-12-03"},
            {projectId: "2", projectName: "Laptop", note: "Long text ", useAble: "启用", projectCode: "InTime", createTime: "2007-12-03"},
            {projectId: "3", projectName: "LCD Monitor", note: "note3", useAble: "启用", projectCode: "TNT", createTime: "2007-12-03"},
            {projectId: "4", projectName: "Speakers", note: "note", useAble: "禁用", projectCode: "ARAMEX", createTime: "2007-12-03"},
            {projectId: "5", projectName: "Laser Printer", note: "note2", useAble: "启用", projectCode: "FedEx", createTime: "2007-12-03"},
            {projectId: "6", projectName: "Play Station", note: "note3", useAble: "禁用", projectCode: "FedEx", createTime: "2007-12-03"},
            {projectId: "7", projectName: "Mobile Telephone", note: "note", useAble: "启用", projectCode: "ARAMEX", createTime: "2007-12-03"},
            {projectId: "8", projectName: "Server", note: "note2", useAble: "启用", projectCode: "TNT", createTime: "2007-12-03"},
            {projectId: "9", projectName: "Matrix Printer", note: "note3", useAble: "禁用", projectCode: "FedEx", createTime: "2007-12-03"},
            {projectId: "10", projectName: "Desktop Computer", note: "note", useAble: "启用", projectCode: "FedEx", createTime: "2007-12-03"},
            {projectId: "11", projectName: "Laptop", note: "Long text ", useAble: "启用", projectCode: "InTime", createTime: "2007-12-03"},
            {projectId: "12", projectName: "LCD Monitor", note: "note3", useAble: "启用", projectCode: "TNT", createTime: "2007-12-03"},
            {projectId: "13", projectName: "Speakers", note: "note", useAble: "禁用", projectCode: "ARAMEX", createTime: "2007-12-03"},
            {projectId: "14", projectName: "Laser Printer", note: "note2", useAble: "启用", projectCode: "FedEx", createTime: "2007-12-03"},
            {projectId: "15", projectName: "Play Station", note: "note3", useAble: "禁用", projectCode: "FedEx", createTime: "2007-12-03"},
            {projectId: "16", projectName: "Mobile Telephone", note: "note", useAble: "启用", projectCode: "ARAMEX", createTime: "2007-12-03"},
            {projectId: "17", projectName: "Server", note: "note2", useAble: "启用", projectCode: "TNT", createTime: "2007-12-03"},
            {projectId: "18", projectName: "Matrix Printer", note: "note3", useAble: "禁用", projectCode: "FedEx", createTime: "2007-12-03"},
            {projectId: "19", projectName: "Matrix Printer", note: "note3", useAble: "禁用", projectCode: "FedEx", createTime: "2007-12-03"},
            {projectId: "20", projectName: "Desktop Computer", note: "note", useAble: "启用", projectCode: "FedEx", createTime: "2007-12-03"},
            {projectId: "21", projectName: "Laptop", note: "Long text ", useAble: "启用", projectCode: "InTime", createTime: "2007-12-03"},
            {projectId: "22", projectName: "LCD Monitor", note: "note3", useAble: "启用", projectCode: "TNT", createTime: "2007-12-03"},
            {projectId: "23", projectName: "Speakers", note: "note", useAble: "禁用", projectCode: "ARAMEX", createTime: "2007-12-03"}
        ];

jQuery(function ($) {
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";

    jQuery(grid_selector).jqGrid({
//        autowidth:true,//据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
        caption: "项目列表",//定义表格名称
        cellEdit:false,//启用或者禁用单元格编辑功能
        cellurl:"",//单元格提交的url

        colNames: ['操作', 'ID', '名称', '编号', '日期', '是否启用', '备注'],//放置列名称的数组，必须与colModel大小相同
        colModel: [ //描述列信息的数组
            {name: 'myac', index: '', width: 80, fixed: true, sortable: false, resize: false,
                formatter: 'actions',
                formatoptions: {
                    keys: true,
                    delOptions: {recreateForm: true, beforeShowForm: beforeDeleteCallback},
                    editformbutton: true, editOptions: {recreateForm: true, beforeShowForm: beforeEditCallback}
                }
            },
            {name: 'projectId', index: 'projectId', hidden: true},
            {name: 'projectName', index: 'projectName', width: 150, sorttype: "text", editable: true, align: "left", editoptions: {size: "20", maxlength: "30"}},
            {name: 'projectCode', index: 'projectCode', width: 80, sorttype: "text", editable: true, align: "left"},
            {name: 'createTime', index: 'createTime', width: 90, editable: true, align: "left", sorttype: "date", unformat: pickDate},
            {name: 'useAble', index: 'useAble', width: 40, editable: true, align: "left", edittype: "checkbox", editoptions:{ value:"启用:禁用" }, unformat: aceSwitch},
            {name: 'note', index: 'note', width: 150, sortable: false, editable: true, align: "left", edittype: "textarea", editoptions: {rows: "2", cols: "20"}}
        ],


        deselectAfterSort:true,//只有当datatype为local时起作用。当排序时不选择当前行
        direction: "ltr",//表格中文字的显示方向，从左向右（ltr）或者从右向左（rtr）

        emptyrecords:"数据为空",//当返回的数据行数为0时显示的信息。只有当属性 viewrecords 设置为ture时起作用
        viewrecords: true,

        footerrow:false,//当为true时，会在翻页栏之上增加一行
        forceFit:true,//当为ture时，调整列宽度不会改变表格的宽度。当shrinkToFit 为false时，此属性会被忽略
//        gridstate:"visible",//定义当前表格的状态：'visible' or 'hidden'
//        gridview:false,//构造一行数据后添加到grid中，如果设为true则是将整个表格的数据都构造完成后再添加到grid中，但treeGrid, subGrid, or afterInsertRow 不能用
        height: 290, //表格高度，可以是数字，像素值或者百分比
        hiddengrid:false,//当为ture时，表格不会被显示，只显示表格的标题。只有当点击显示表格的那个按钮时才会去初始化表格数据。只有当caption 属性不为空而且hidegrid为ture时才起作用
        hidegrid:false,//启用或者禁用控制表格显示、隐藏的按钮，只有当caption 属性不为空时起效
        hoverrows:true,//当为false时mouse hovering(鼠标进入该行时高亮显示)会被禁用

        lastsort:1,//只读属性，定义了最后排序列的索引，从0开始
//        loadonce:false,//如果为ture则数据只从服务器端抓取一次，之后所有操作都是在客户端执行，翻页功能会被禁用
        loadtext:"加载中...",//当请求或者排序时所显示的文字内容
        mtype:"GET",//请求的类型：(“POST” or “GET”)	默认GET
        multiselect: true, //是否显示多选框
        multiselectWidth:30,//当multiselect为true时设置multiselect列宽度
        multikey: "",//只有在multiselect设置为ture时起作用，定义需要同时按着那个键来做多选。shiftKey ，altKey ，ctrlKey,""（不设置值时点击该行即可选中）
        multiboxonly: true,

        lastpage:100,//只读属性，定义了总页数
        page:2,//设置初始页码
        pager: pager_selector, //指定分页栏对象，必须为一个有效的html元素。可以是'pager', '#pager', jQuery('#pager').推荐用'#pager'
        pgbuttons:true,//是否显示前后翻页按钮
        pagerpos:"center",//指定分页栏的位置
        reccount:100,//只读属性，定义了grid中确切的行数。通常情况下与records属性相同，但有一种情况例外，假如rowNum=15，但是从服务器端返回的记录数是20，那么records值是20，但reccount值仍然为15，而且表格中也只显示15条记录。
        records:100,//只读属性，定义了返回的记录数
//        data: grid_data,
//        pginput:true,//是否显示跳转页面的输入框
//        pgtext:"",//当前页信息
//        recordtext:"{0}----{1}",//显示记录数信息。{0} 为记录数开始，{1}为记录数结束。 viewrecords为ture时才能起效，且总记录数大于0时才会显示此信息

        rownumbers:false,//如果为ture则会在表格左边新增一列，显示行顺序号，从1开始递增。此列名为'rn'
        rownumWidth:50,//如果rownumbers为true，则可以设置column的宽度
        rowNum: 10,//设置表格中显示的记录数，参数会被自动传到后台。如果此参数设为10，但是从服务器端返回15条记录，那么在表格中只会显示10条记录。如果设为-1则禁用此检查
        rowList: [10, 20, 30], //一个数组用来调整表格显示的记录数，此参数值会替代rowNum参数值传给服务器端。如果为空则不显示，设置格式：[10,20,30]。
//        toolbar:[true,"bottom"],//表格的工具栏。数组中有两个值，第一个为是否启用，第二个指定工具栏位置（相对于body layer），如：[true,”both”] 。工具栏位置可选值：“top”,”bottom”, “both”. 如果工具栏在上面，则工具栏id为“t_”+表格id；如果在下面则为 “tb_”+表格id；如果只有一个工具栏则为 “t_”+表格id
        toppager: false,//是否在表格顶部显示分页信息
        url:"<%=path%>/web/jqgridDemo.do",
        datatype: "json",//表格可以被接受的数据类型：xml，xmlstring，json，local，function
        jsonReader : {root:"dataRows",id: "projectId"},//root:设置记录集的属性名称，id:设置主键的属性名称
        editurl:"<%=path%>/web/jqgridEdit.do",//定义对form编辑时的url（增删改的时候使用）

        loadComplete: function () {
            var table = this;
            setTimeout(function () {
                styleCheckbox(table);

                updateActionIcons(table);
                updatePagerIcons(table);
                enableTooltips(table);
            }, 0);
        },

        autowidth: true

    });

    //enable search/filter toolbar
    //jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})

    //switch element when editing inline
    function aceSwitch(cellvalue, options, cell) {
        setTimeout(function () {
            $(cell).find('input[type=checkbox]')
                    .wrap('<label class="inline" />')
                    .addClass('ace ace-switch ace-switch-5')
                    .after('<span class="lbl"></span>');
        }, 0);
    }

    //enable datepicker
    function pickDate(cellvalue, options, cell) {
        setTimeout(function () {
            $(cell).find('input[type=text]')
                    .datepicker({format: 'yyyy-mm-dd', autoclose: true});
        }, 0);
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
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
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
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                    style_edit_form(form);
                }
            },
            {
                //delete record form
                recreateForm: true,
                beforeShowForm: function (e) {
                    var form = $(e[0]);
                    if (form.data('styled')) return false;

                    form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                    style_delete_form(form);

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
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                    style_search_form(form);
                },
                afterRedraw: function () {
                    style_search_filters($(this));
                },
                multipleSearch: true
                /**
                 multipleGroup:true,
                 showQuery: true
                 */
            },
            {
                //view record form
                recreateForm: true,
                beforeShowForm: function (e) {
                    var form = $(e[0]);
                    form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                }
            }
    )


    function style_edit_form(form) {
        //enable datepicker on "createTime" field and switches for "useAble" field
        form.find('input[name=createTime]').datepicker({format: 'yyyy-mm-dd', autoclose: true})
                .end().find('input[name=useAble]')
                .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

        //update buttons classes
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
        buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
        buttons.eq(1).prepend('<i class="icon-remove"></i>')

        buttons = form.next().find('.navButton a');
        buttons.find('.ui-icon').remove();
        buttons.eq(0).append('<i class="icon-chevron-left"></i>');
        buttons.eq(1).append('<i class="icon-chevron-right"></i>');
    }

    function style_delete_form(form) {
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
        buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
        buttons.eq(1).prepend('<i class="icon-remove"></i>')
    }

    function style_search_filters(form) {
        form.find('.delete-rule').val('X');
        form.find('.add-rule').addClass('btn btn-xs btn-primary');
        form.find('.add-group').addClass('btn btn-xs btn-success');
        form.find('.delete-group').addClass('btn btn-xs btn-danger');
    }

    function style_search_form(form) {
        var dialog = form.closest('.ui-jqdialog');
        var buttons = dialog.find('.EditTable')
        buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
        buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
        buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
    }

    function beforeDeleteCallback(e) {
        var form = $(e[0]);
        if (form.data('styled')) return false;

        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        style_delete_form(form);

        form.data('styled', true);
    }

    function beforeEditCallback(e) {
        var form = $(e[0]);
        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        style_edit_form(form);
    }


    //it causes some flicker when reloading or navigating grid
    //it may be possible to have some custom formatter to do this as the grid is being created to prevent this
    //or go back to default browser checkbox styles for the grid
    function styleCheckbox(table) {
        /**
         $(table).find('input:checkbox').addClass('ace')
         .wrap('<label />')
         .after('<span class="lbl align-top" />')


         $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
         .find('input.cbox[type=checkbox]').addClass('ace')
         .wrap('<label />').after('<span class="lbl align-top" />');
         */
    }


    //unlike navButtons icons, action icons in rows seem to be hard-coded
    //you can change them like this in here if you want
    function updateActionIcons(table) {
        /**
         var replacement =
         {
             'ui-icon-pencil' : 'icon-pencil blue',
             'ui-icon-trash' : 'icon-trash red',
             'ui-icon-disk' : 'icon-ok green',
             'ui-icon-cancel' : 'icon-remove red'
         };
         $(table).find('.ui-pg-div span.ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
         */
    }

    //replace icons with FontAwesome icons like above
    function updatePagerIcons(table) {
        var replacement =
        {
            'ui-icon-seek-first': 'icon-double-angle-left bigger-140',
            'ui-icon-seek-prev': 'icon-angle-left bigger-140',
            'ui-icon-seek-next': 'icon-angle-right bigger-140',
            'ui-icon-seek-end': 'icon-double-angle-right bigger-140'
        };
        $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
            var icon = $(this);
            var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

            if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
        })
    }

    function enableTooltips(table) {
        $('.navtable .ui-pg-button').tooltip({container: 'body'});
        $(table).find('.ui-pg-div').tooltip({container: 'body'});
    }

    //var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');


});
</script>

</body>
</html>
