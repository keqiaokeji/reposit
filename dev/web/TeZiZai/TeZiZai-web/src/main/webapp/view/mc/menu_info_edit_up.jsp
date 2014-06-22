<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/view/home/home_head.jsp"/>

    <%--下来搜索选课--%>
    <link href="<%=path%>/bootstrap/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/chosen.css"/>
    <link rel="stylesheet" href="<%=path%>/bootstrap/assets/css/ace.min.css"/>
    <script src="<%=path%>/bootstrap/assets/js/chosen.jquery.min.js"></script>


</head>

<body>


<div class="main-container" id="main-container">

    <div class="main-container-inner">


        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->

                <div>
                    <div id="user-profile-3" class="user-profile row">
                        <div class="col-sm-offset-1 col-sm-10">

                            <form id="uploadForm" action="http://localhost/TeZiZai-web/upload.do"
                                  enctype="multipart/form-data" method="post" class="form-horizontal">
                                <div class="tabbable">

                                    <div class="tab-content profile-edit-tab-content">
                                        <div id="edit-basic" class="tab-pane in active">
                                            <h4 class="header blue bolder smaller">基本信息</h4>

                                            <div class="row">
                                                <div class="hide">
                                                                <span class="profile-picture">
													<img id="avatar" class="editable img-responsive" title="1111"
                                                         alt="Alex's Avatar"
                                                         src="../../bootstrap/assets/avatars/profile-pic.jpg"/>
												</span>
                                                </div>
                                                <div class="col-xs-12 col-sm-4">
                                                    <input id="avatar" name="avatar" type="file"/>
                                                </div>

                                                <div class="vspace-xs"></div>

                                                <div class="col-xs-12 col-sm-8">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label no-padding-right">菜名</label>

                                                        <div class="col-sm-9">
                                                            <div class="input-medium">
                                                                <div class="input-group">
                                                                    <input class="col-xs-12 col-sm-10" type="text"
                                                                           id="form-field-username"
                                                                           placeholder="菜名"
                                                                           value=""/>
                                                                </div>
                                                            </div>
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


</div>
<!-- /.main-container-inner -->


</div>
<!-- /.main-container -->

<jsp:include page="/view/home/home_compatibility.jsp"/>


<!-- page specific plugin scripts -->


<script src="<%=path%>/bootstrap/assets/js/jquery.gritter.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/x-editable/bootstrap-editable.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/x-editable/ace-editable.min.js"></script>


<script type="text/javascript">
    jQuery(function ($) {

        //editables on first profile page
        $.fn.editable.defaults.mode = 'inline';
        $.fn.editableform.loading = "<div class='editableform-loading'><i class='light-blue icon-2x icon-spinner icon-spin'></i></div>";
        $.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="icon-ok icon-white"></i></button>' +
                '<button type="button" class="btn editable-cancel"><i class="icon-remove"></i></button>';

        $("#form-field-select-menuType").attr("value", "xc");//设置当前下拉选框的值，设置之后控件需要刷新一下
        $(".chosen-select").chosen();//控件刷新
        $('#form-field-select-menuType').change(function () {
            alert($("#form-field-select-menuType").find("option:selected").text());//获得选中的文本
            alert($("#form-field-select-menuType").val());//获取select选中的 value:
            alert($("#form-field-select-menuType").get(0).selectedIndex);//获取select选中的索引:
        });


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

                            if (file.size > 110) {//~100Kb
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


        // *** editable avatar *** //
//        try {//ie8 throws some harmless exception, so let's catch it
//
//            //it seems that editable plugin calls appendChild, and as Image doesn't have it, it causes errors on IE at unpredicted points
//            //so let's have a fake appendChild for it!
//            if (/msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase())) Image.prototype.appendChild = function (el) {
//            }
//
//            var last_gritter
//            $('#avatar').editable({
//                type: 'image',
//                name: 'avatar',
//                value: null,
//                image: {
//                    //specify ace file input plugin's options here
//                    btn_choose: 'Change Avatar',
//                    droppable: true,
//                    /**
//                     //this will override the default before_change that only accepts image files
//                     before_change: function(files, dropped) {
//								return true;
//							},
//                     */
//
//                    //and a few extra ones here
//                    name: 'avatar',//put the field name here as well, will be used inside the custom plugin
//                    max_size: 1024 * 1024 * 2,//图片大小小于2M
//                    on_error: function (code) {//on_error function will be called when the selected file has a problem
//                        if (last_gritter) $.gritter.remove(last_gritter);
//                        if (code == 1) {//file format error
//                            last_gritter = $.gritter.add({
//                                title: '你选择的文件不是一个图片!',
//                                text: '请选择图片格式（如jpg、gif、png等）文件!',
//                                class_name: 'gritter-error gritter-center'
//                            });
//                        } else if (code == 2) {//file size rror
//                            last_gritter = $.gritter.add({
//                                title: '文件太大!',
//                                text: '文件最大不能超过2M!',
//                                class_name: 'gritter-error gritter-center'
//                            });
//                        }
//                        else {//other error
//                        }
//                    },
//                    on_success: function () {
//                        $.gritter.removeAll();
//                    }
//                },
//                url: function (params) {
//                    // ***UPDATE AVATAR HERE*** //
//                    //You can replace the contents of this function with examples/profile-avatar-update.js for actual upload
//
//                    var deferred = new $.Deferred
//                    //if value is empty, means no valid files were selected
//                    //but it may still be submitted by the plugin, because "" (empty string) is different from previous non-empty value whatever it was
//                    //so we return just here to prevent problems
//                    var value = $('#avatar').next().find('input[type=hidden]:eq(0)').val();
//                    alert(value);
//                    if (!value || value.length == 0) {
//                        deferred.resolve();
//                        return deferred.promise();
//                    }
//
//
//                    //dummy upload
//                    setTimeout(function () {
//                        alert($("#avatar").attr("src"));
//
//
//                        $("#uploadForm").submit();
//
////                        $(".editableform").attr("action","http://localhost/TeZiZai-web/upload.do");
////                        $(".editableform").attr("enctype","multipart/form-data");
////                        $(".editableform").attr("method","post");
////                        $(".editableform").submit();
//
//
////                        if ("FileReader" in window) {
////                            //for browsers that have a thumbnail of selected image
////                            var thumb = $('#avatar').next().find('img').data('thumb');
////                            if (thumb) $('#avatar').get(0).src = thumb;
////                        }
//
//                        deferred.resolve({'status': 'OK'});
//
//                        if (last_gritter) $.gritter.remove(last_gritter);
//                        last_gritter = $.gritter.add({
//                            title: 'Avatar Updated!',
//                            text: 'Uploading to server can be easily implemented. A working example is included with the template.',
//                            class_name: 'gritter-info gritter-center'
//                        });
//
//                    }, parseInt(800))
//                    return deferred.promise();
//                },
//
//                success: function (response, newValue) {
//                }
//            })
//        } catch (e) {
//        }

    });


</script>

</body>
</html>
