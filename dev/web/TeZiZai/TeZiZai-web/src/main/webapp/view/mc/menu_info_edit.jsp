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

                    <form class="form-horizontal">
                        <div class="tabbable">

                            <div class="tab-content profile-edit-tab-content">
                                <div id="edit-basic" class="tab-pane in active">
                                    <h4 class="header blue bolder smaller">基本信息</h4>

                                    <div class="row">
                                        <div class="col-xs-12 col-sm-4">
        <span class="profile-picture">
            <img id="avatar" class="editable img-responsive editable-click editable-empty" alt="点击修改头像"
                 src="<%=path%>/bootstrap/assets/avatars/profile-pic.jpg"></img>
        </span>

                                            <div class="space-4"></div>

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


                                            <div class="form-group">
                                                <label class="col-sm-3 control-label no-padding-right">优惠价格</label>

                                                <div class="col-sm-9">
                                                    <div class="input-medium">
                                                        <div class="input-group">
                                                            <input class="col-xs-12 col-sm-10" type="text"
                                                                   id="form-field-price_fav"
                                                                   placeholder="优惠价格，可以不填"
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
                                                                   id="form-field-price_real"
                                                                   placeholder="真实价格"
                                                                   value=""/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="space-4"></div>

                                            <div class="form-group">
                                                <label class="col-sm-3 control-label no-padding-right"
                                                       for="form-field-comment">简介</label>

                                                <div class="col-sm-9">
                                                    <textarea id="form-field-comment"></textarea>
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
                                            <span class="input-icon">
                                                <input type="text" id="form-field-unit"/>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right">序号</label>
                                        <div class="col-sm-9">
                                            <span class="input-icon">
                                                <input type="text" id="form-field-sort_num"/>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="space-4"></div>



                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-website">网址</label>

                                        <div class="col-sm-9">
        <span class="input-icon input-icon-right">
            <input type="url" id="form-field-website"/>
            <i class="icon-globe"></i>
        </span>
                                        </div>
                                    </div>

                                    <div class="space-4"></div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-phone">手机号</label>

                                        <div class="col-sm-9">
        <span class="input-icon input-icon-right">
            <input class="input-medium input-mask-phone" type="text" id="form-field-phone"/>
            <i class="icon-phone icon-flip-horizontal"></i>
        </span>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-3 control-label no-padding-right"
                                               for="form-field-facebook">QQ号码</label>
                                        <div class="col-sm-9">
                                            <span class="input-icon">
                                                <input type="text" id="form-field-facebook"/>
                                            </span>
                                        </div>
                                    </div>

                                </div>

                            </div>
                        </div>

                        <div class="clearfix form-actions">
                            <div class="col-md-offset-3 col-md-9">
                                <button class="btn btn-info" type="button">
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

<!--[if lte IE 8]>
<script src="<%=path%>/bootstrap/assets/js/excanvas.min.js"></script>
<![endif]-->

<script src="<%=path%>/bootstrap/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/jquery.gritter.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/bootbox.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/jquery.slimscroll.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/jquery.hotkeys.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/bootstrap-wysiwyg.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/select2.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/fuelux/fuelux.spinner.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/x-editable/bootstrap-editable.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/x-editable/ace-editable.min.js"></script>
<script src="<%=path%>/bootstrap/assets/js/jquery.maskedinput.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    jQuery(function ($) {

        //editables on first profile page
        $.fn.editable.defaults.mode = 'inline';
        $.fn.editableform.loading = "<div class='editableform-loading'><i class='light-blue icon-2x icon-spinner icon-spin'></i></div>";
        $.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="icon-ok icon-white"></i></button>' +
                '<button type="button" class="btn editable-cancel"><i class="icon-remove"></i></button>';


        // *** editable avatar *** //
        try {//ie8 throws some harmless exception, so let's catch it

            //it seems that editable plugin calls appendChild, and as Image doesn't have it, it causes errors on IE at unpredicted points
            //so let's have a fake appendChild for it!
            if (/msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase())) Image.prototype.appendChild = function (el) {
            }

            var last_gritter
            $('#avatar').editable({
                type: 'image',
                name: 'avatar',
                value: null,
                image: {
                    //specify ace file input plugin's options here
                    btn_choose: 'Change Avatar',
                    droppable: true,
                    /**
                     //this will override the default before_change that only accepts image files
                     before_change: function(files, dropped) {
								return true;
							},
                     */

                    //and a few extra ones here
                    name: 'avatar',//put the field name here as well, will be used inside the custom plugin
                    max_size: 110000,//~100Kb
                    on_error: function (code) {//on_error function will be called when the selected file has a problem
                        if (last_gritter) $.gritter.remove(last_gritter);
                        if (code == 1) {//file format error
                            last_gritter = $.gritter.add({
                                title: 'File is not an image!',
                                text: 'Please choose a jpg|gif|png image!',
                                class_name: 'gritter-error gritter-center'
                            });
                        } else if (code == 2) {//file size rror
                            last_gritter = $.gritter.add({
                                title: 'File too big!',
                                text: 'Image size should not exceed 100Kb!',
                                class_name: 'gritter-error gritter-center'
                            });
                        }
                        else {//other error
                        }
                    },
                    on_success: function () {
                        $.gritter.removeAll();
                    }
                },
                url: function (params) {
                    // ***UPDATE AVATAR HERE*** //
                    //You can replace the contents of this function with examples/profile-avatar-update.js for actual upload


                    var deferred = new $.Deferred

                    //if value is empty, means no valid files were selected
                    //but it may still be submitted by the plugin, because "" (empty string) is different from previous non-empty value whatever it was
                    //so we return just here to prevent problems
                    var value = $('#avatar').next().find('input[type=hidden]:eq(0)').val();
                    if (!value || value.length == 0) {
                        deferred.resolve();
                        return deferred.promise();
                    }


                    //dummy upload
                    setTimeout(function () {
                        if ("FileReader" in window) {
                            //for browsers that have a thumbnail of selected image
                            var thumb = $('#avatar').next().find('img').data('thumb');
                            if (thumb) $('#avatar').get(0).src = thumb;
                        }

                        deferred.resolve({'status': 'OK'});

                        if (last_gritter) $.gritter.remove(last_gritter);
                        last_gritter = $.gritter.add({
                            title: 'Avatar Updated!',
                            text: 'Uploading to server can be easily implemented. A working example is included with the template.',
                            class_name: 'gritter-info gritter-center'
                        });

                    }, parseInt(Math.random() * 800 + 800))

                    return deferred.promise();
                },

                success: function (response, newValue) {
                }
            })
        } catch (e) {
        }


        $('.input-mask-phone').mask('99999999999');

    });
</script>

</body>
</html>
