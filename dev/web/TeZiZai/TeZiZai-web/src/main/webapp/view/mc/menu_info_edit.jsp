<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/view/home/home_head.jsp"/>
    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/jquery-ui-1.10.3.custom.min.css"/>
    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/jquery.gritter.css"/>
    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/select2.css"/>
    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/bootstrap-editable.css"/>

    <%--下来搜索选课--%>
    <link href="<%=path%>/bootstrap/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/chosen.css"/>
    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/ace.min.css"/>
    <script src="<%=path%>/bootstrap/assets/js/chosen.jquery.min.js"></script>


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

                <div>
                    <div id="user-profile-3" class="user-profile row">
                        <div class="col-sm-offset-1 col-sm-10">
                            <div class="well well-sm">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                &nbsp;
                                <div class="inline middle blue bigger-110"> 您的信息的完整度为70%</div>
                                &nbsp; &nbsp; &nbsp;
                                <div style="width:200px;" data-percent="70%"
                                     class="inline middle no-margin progress progress-striped active">
                                    <div class="progress-bar progress-bar-success" style="width:70%"></div>
                                </div>
                            </div>
                            <!-- /well -->

                            <div class="space"></div>
                            <form class="form-horizontal" id="saveReportForm" action="" method="post" enctype="multipart/form-data"
                                  onsubmit="return saveReport();">
                                <div class="tabbable">

                                    <div class="tab-content profile-edit-tab-content">
                                        <div id="edit-basic" class="tab-pane in active">
                                            <h4 class="header blue bolder smaller">基本信息</h4>

                                            <div class="row">
                                                <div class="col-xs-12 col-sm-4">
                                                    <input id="image" name="image" type="file"/>
                                                </div>
                                                <div class="hide">
                                            <span class="profile-picture">
                                                <img class="editable img-responsive" alt="点击更换图片" title="点击更换图片"
                                                     src="<%=path%>/bootstrap/assets/avatars/profile-pic.jpg"/>
                                            </span>
                                                </div>
                                                <div class="vspace-xs"></div>

                                                <div class="col-xs-12 col-sm-8">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right">菜名</label>

                                                        <div class="col-sm-9">
                                                            <div class="input-medium">
                                                                <div class="input-group">
                                                                    <input class="col-xs-12 col-sm-10" type="text"
                                                                           id="form-field-menuName" name="menuName"
                                                                           placeholder="菜名"
                                                                           value=""/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="space-4"></div>

                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right">优惠价格</label>

                                                        <div class="col-sm-9">
                                                            <div class="input-medium">
                                                                <div class="input-group">
                                                                    <input class="col-xs-12 col-sm-10" type="text"
                                                                           id="form-field-priceFavorable" name="priceFavorable"
                                                                           placeholder="不填代表无优惠"
                                                                           value=""/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="space-4"></div>

                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right">真实价格</label>

                                                        <div class="col-sm-9">
                                                            <div class="input-medium">
                                                                <div class="input-group">
                                                                    <input class="col-xs-12 col-sm-10" type="text"
                                                                           id="form-field-priceReal" name="priceReal"
                                                                           placeholder="优惠前的价格"
                                                                           value=""/>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="space-4"></div>


                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right">类别</label>

                                                        <div class="col-sm-9">
                                                            <select class="width-30 chosen-select"
                                                                    id="form-field-select-menuType" name="menuTypeId"
                                                                    data-placeholder="请选择...">
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="space-4"></div>


                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right"
                                                               for="form-field-detail">简介</label>

                                                        <div class="col-sm-9">
                                                            <textarea id="form-field-detail" name="menuContent"></textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <hr/>

                                            <div class="space"></div>
                                            <h4 class="header blue bolder smaller">附属信息</h4>

                                            <div class="form-group">
                                                <label class="col-sm-3 control-label no-padding-right">单位</label>

                                                <div class="col-sm-9">
                                            <span class="input-group">
                                                <input class="col-xs-12 col-sm-10" type="text"
                                                       id="form-field-unit" name="menuUnit"
                                                       placeholder="如份，斤等"
                                                       value=""/>
                                            </span>
                                                </div>
                                            </div>
                                            <div class="space-4"></div>

                                            <div class="form-group">
                                                <label class="col-sm-3 control-label no-padding-right">序号</label>

                                                <div class="col-sm-9">
                                            <span class="input-group">
                                                <input class="col-xs-12 col-sm-10" type="text"
                                                       id="form-field-sortNum" name="orderingNum"
                                                       placeholder="排序使用"
                                                       value=""/>
                                            </span>
                                                </div>
                                            </div>
                                            <div class="space-4"></div>

                                        </div>

                                    </div>
                                </div>

                                <div class="clearfix form-actions">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button class="btn btn-info" type="submit">
                                            <i class="icon-ok bigger-110"></i>
                                            保存
                                        </button>

                                        &nbsp; &nbsp;
                                        <button class="btn" type="reset">
                                            <i class="icon-undo bigger-110"></i>
                                            重置
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- /span -->
                    </div>
                    <!-- /user-profile -->
                </div>

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


<script src="<%=path%>/bootstrap/assets/js/jquery.gritter.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/x-editable/bootstrap-editable.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/x-editable/ace-editable.min.js"></script>


<!-- inline scripts related to this page -->

<script type="text/javascript">

    function saveReport() {
        // jquery 表单提交
        $("#saveReportForm").ajaxSubmit(function (message) {
//                // 对于表单提交成功后处理，message为提交页面saveReport.htm的返回内容
        });
        return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
    }


    jQuery(function ($) {

        //editables on first profile page
        $.fn.editable.defaults.mode = 'inline';
        $.fn.editableform.loading = "<div class='editableform-loading'><i class='light-blue icon-2x icon-spinner icon-spin'></i></div>";
        $.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="icon-ok icon-white"></i></button>' +
                '<button type="button" class="btn editable-cancel"><i class="icon-remove"></i></button>';

//        $("#form-field-select-menuType").attr("value", "xc");//设置当前下拉选框的值，设置之后控件需要刷新一下
//        $(".chosen-select").chosen();//控件刷新
//        $('#form-field-select-menuType').change(function () {
//            alert($("#form-field-select-menuType").find("option:selected").text());//获得选中的文本
//            alert($("#form-field-select-menuType").val());//获取select选中的 value:
//            alert($("#form-field-select-menuType").get(0).selectedIndex);//获取select选中的索引:
//        });


        var menuTypeList;//菜单类型列表

        $("#saveReportForm").attr("action", app.baseUrlSvc + "/user/mc/addMenuInfo.do?token=" + app.getTokenByCookie());
        initImgFileChange();
        initMenuTypeSelect();


        function initMenuTypeSelect() {
            $.ajax({
                type: "post",
                async: true,//异步，如果等于false 那么就是同步
                url: app.baseUrlSvc + "/user/mc/getMenuTypeList.do?token=" + app.getTokenByCookie(),
                dataType: "json",
                data: "",
                success: function (data) {
                    if (data != null && data.statusCode == app.SUCCESS) {
                        if (data.result.length > 0) {
                            menuTypeList = data.result[0];
                            for (var i = 0; i < menuTypeList.length; i++) {
                                var menuType = menuTypeList[i];
                                $("#form-field-select-menuType").append("<option value='" + menuType.menuTypeId + "'>" + menuType.menuTypeName + "</option>");
                            }
                            $(".chosen-select").chosen();//控件刷新
                        } else {
                            alert("暂无菜单信息！");
                        }
                    } else {
                        alert("获得菜单信息失败！");
                    }
                },
                error: function (data) {
                    alert("请求服务器出错，请重新登录！");
                }
            });
        }


        //初始化图片选择框
        function initImgFileChange() {
            $('#user-profile-3')
                    .find('input[type=file]').ace_file_input({
                        style: 'well',
                        btn_choose: 'Change avatar',
                        btn_change: null,
                        no_icon: 'icon-picture',
                        thumbnail: 'large',
                        droppable: true,
                        before_change: function (files, dropped) {
                            var file = files[0];
                            if (typeof file === "string") {//files is just a file name here (in browsers that don't support FileReader API)
                                if (!(/\.(jpe?g|png|gif)$/i).test(file)) return false;
                            }
                            else {//file is a File object
                                var type = $.trim(file.type);
                                if (( type.length > 0 && !(/^image\/(jpe?g|png|gif)$/i).test(type) )
                                        || ( type.length == 0 && !(/\.(jpe?g|png|gif)$/i).test(file.name) )//for android default browser!
                                        ) return false;

                                if (file.size > 110000) {//~100Kb
                                    alert("过大");
                                    return false;
                                }
                            }

                            return true;
                        }
                    })
                    .end().find('button[type=reset]').on(ace.click_event, function () {
                        $('#user-profile-3 input[type=file]').ace_file_input('reset_input');
                    })
                    .end().find('.date-picker').datepicker().next().on(ace.click_event, function () {
                        $(this).prev().focus();
                    });
        }


    });

</script>

</body>
</html>
