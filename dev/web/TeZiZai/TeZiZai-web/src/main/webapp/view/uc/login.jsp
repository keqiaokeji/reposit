<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>

    <jsp:include page="/view/home/home_head.jsp"/>
</head>

<body class="login-layout">
<div class="main-container">
<div class="main-content">
<div class="row">
<div class="col-sm-10 col-sm-offset-1">
<div class="login-container">
<div class="center">
    <h1>
        <i class="icon-leaf green"></i>
        <span class="red">易朵</span>
        <span class="white">工作管理系统</span>
    </h1>
    <h4 class="blue">&copy; 上海易朵信息技术有限公司</h4>
</div>
<div class="space-6"></div>

<div class="position-relative">
<div id="login-box" class="login-box visible widget-box no-border">
    <div class="widget-body">
        <div class="widget-main">
            <div id="loginTitleInit" name="loginTitleInit" style="display: block">
                <h4 class="header blue lighter bigger">
                    <i class="icon-coffee green"></i>
                    请输入登录信息
                </h4>
            </div>
            <div id="loginTitleWarn" name="loginTitleWarn" style="display: none">
                <h4 class="header red lighter bigger">
                    <i class="icon-coffee red"></i>
                    <span id="loginTitleWarnMsg" name="loginTitleWarnMsg">用户名或者密码错误！</span>
                </h4>
            </div>

            <div class="space-6"></div>

            <form>
                <fieldset>

                    <label class="block clearfix">
                        <span class="block input-icon input-icon-right">
                            <input id="username" name="username" type="text" class="form-control" placeholder="用户名"/>
                            <i class="icon-user"></i>
                        </span>
                    </label>

                    <label class="block clearfix">
                        <span class="block input-icon input-icon-right">
                            <input id="password" name="password" type="password" class="form-control" placeholder="密码"/>
                            <i class="icon-lock"></i>
                        </span>
                    </label>

                    <label class="block clearfix">
                        <span>
                            <input id="codeContentLogin" name="codeContentLogin" type="text" maxlength="4" placeholder="验证码">
                            <img id="codeImgLogin" name="codeImgLogin" alt="点击换一张验证码" title="点击换一张验证码" src=""
                                 width="100" height="29">
                            <input id="codeKeyLogin" name="codeKeyLogin" type="hidden"/>
                        </span>
                    </label>

                    <div class="space"></div>

                    <div class="clearfix">
                        <label class="inline">
                            <input id="remberPassword" name="remberPassword" type="checkbox" value="1" class="ace"/>
                            <span class="lbl"> 记住密码</span>
                        </label>

                        <button id="loginBtn" name="loginBtn" type="button"
                                class="width-35 pull-right btn btn-sm btn-primary">
                            <i class="icon-key"></i>
                            登录
                        </button>
                    </div>

                    <div class="space-4"></div>
                </fieldset>
            </form>

            <div class="social-or-login center">
                <span class="bigger-110">或者使用如下方式登录</span>
            </div>

            <div class="social-login center">
                <a class="btn btn-primary">
                    <i class="icon-facebook"></i>
                </a>

                <a class="btn btn-info">
                    <i class="icon-twitter"></i>
                </a>

                <a class="btn btn-danger">
                    <i class="icon-google-plus"></i>
                </a>
            </div>
        </div>
        <!-- /widget-main -->

        <div class="toolbar clearfix">
            <div>
                <a id="loginToFindPassword" href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
                    <i class="icon-arrow-left"></i>
                    忘记密码
                </a>
            </div>

            <div>
                <a id="loginToReg" href="#" onclick="show_box('signup-box'); return false;"
                   class="user-signup-link">
                    注册帐号
                    <i class="icon-arrow-right"></i>
                </a>
            </div>
        </div>
    </div>
    <!-- /widget-body -->
</div>
<!-- /login-box -->

<div id="forgot-box" class="forgot-box widget-box no-border">
    <div class="widget-body">
        <div class="widget-main">
            <h4 class="header red lighter bigger">
                <i class="icon-key"></i>
                找回密码
            </h4>

            <div class="space-3"></div>
            <div id="findPasswordTitleInit" name="findPasswordTitleInit" style="display:block">
                <span>请输入你的帐号所关联的邮箱</span>
            </div>
            <div id="findPasswordTitleWarn" name="findPasswordTitleWarn" style="display:none">
                    <span id="findPasswordTitleWarnMsg" name="findPasswordTitleWarnMsg"
                          class="header red lighter bigger">邮箱不能为空！</span>
            </div>

            <form>
                <fieldset>
                    <label class="block clearfix">
                        <span class="block input-icon input-icon-right">
                            <input id="emailFindPassword" name="emailFindPassword" type="email" class="form-control"
                                   placeholder="邮箱地址"/>
                            <i class="icon-envelope"></i>
                        </span>
                    </label>

                    <label class="block clearfix">
                        <span>
                            <input id="codeContentFindPassword" name="codeContentFindPassword" type="text" maxlength="4" placeholder="验证码">
                            <img id="codeImgFindPassword" name="codeImgFindPassword" alt="点击换一张验证码" title="点击换一张验证码" src="" width="100" height="29">
                            <input id="codeKeyFindPassword" name="codeKeyFindPassword" type="hidden"/>
                        </span>
                    </label>

                    <div class="clearfix">
                        <button id="findPasswordBtn" name="findPasswordBtn" type="button"
                                class="width-35 pull-right btn btn-sm btn-danger">
                            <i class="icon-lightbulb"></i>
                            发送邮件
                        </button>
                    </div>
                </fieldset>
            </form>
        </div>
        <!-- /widget-main -->

        <div class="toolbar center">
            <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                返回
                <i class="icon-arrow-right"></i>
            </a>
        </div>
    </div>
    <!-- /widget-body -->
</div>
<!-- /forgot-box -->

<div id="signup-box" class="signup-box widget-box no-border">
    <div class="widget-body">
        <div class="widget-main">
            <h4 class="header green lighter bigger">
                <i class="icon-group blue"></i>
                新用户注册
            </h4>

            <div class="space-3"></div>
            <div id="regTitleInit" name="regTitleInit" style="display:block">
                <span>请输入您的用户信息</span>
            </div>
            <div id="regTitleWarn" name="regTitleWarn" style="display:none">
                    <span id="regTitleWarnMsg" name="regTitleWarnMsg"
                          class="header red lighter bigger">用户名不能为空！</span>
            </div>

            <form>
                <fieldset>
                    <label class="block clearfix">
                        <span class="block input-icon input-icon-right">
                            <input id="emailReg" name="emailReg" type="email" class="form-control" placeholder="邮箱"/>
                            <i class="icon-envelope"></i>
                        </span>
                    </label>

                    <label class="block clearfix">
                        <span class="block input-icon input-icon-right">
                            <input id="usernameReg" name="usernameReg" type="text" class="form-control"
                                   placeholder="用户名"/>
                            <i class="icon-user"></i>
                        </span>
                    </label>

                    <label class="block clearfix">
                        <span class="block input-icon input-icon-right">
                            <input id="passwordReg1" name="passwordReg1" type="password" class="form-control"
                                   placeholder="密码"/>
                            <i class="icon-lock"></i>
                        </span>
                    </label>

                    <label class="block clearfix">
                        <span class="block input-icon input-icon-right">
                            <input id="passwordReg2" name="passwordReg2" type="password" class="form-control"
                                   placeholder="重复密码"/>
                            <i class="icon-retweet"></i>
                        </span>
                    </label>

                    <label class="block clearfix">
                        <span>
                            <input id="codeContentReg" name="codeContentReg" type="text" maxlength="4" placeholder="验证码">
                            <img id="codeImgReg" name="codeImgReg" alt="点击换一张验证码" title="点击换一张验证码" src="" width="100"
                                 height="29">
                            <input id="codeKeyReg" name="codeKeyReg" type="hidden"/>
                        </span>
                    </label>

                    <label class="block">
                        <input id="agreeReg" name="agreeReg" type="checkbox" class="ace"/>
                        <span class="lbl">
                            同意
                            <a href="#">《协议》</a>
                        </span>
                    </label>

                    <div class="space-24"></div>

                    <div class="clearfix">
                        <button type="reset" class="width-30 pull-left btn btn-sm">
                            <i class="icon-refresh"></i>
                            重置
                        </button>

                        <button id="regBtn" name="regBtn" type="button"
                                class="width-65 pull-right btn btn-sm btn-success">
                            注册
                            <i class="icon-arrow-right icon-on-right"></i>
                        </button>
                    </div>
                </fieldset>
            </form>
        </div>

        <div class="toolbar center">
            <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                <i class="icon-arrow-left"></i>
                返回
            </a>
        </div>
    </div>
    <!-- /widget-body -->
</div>
<!-- /signup-box -->
</div>
<!-- /position-relative -->
</div>
</div>
<!-- /.col -->
</div>
<!-- /.row -->
</div>
</div>
<!-- /.main-container -->

<jsp:include page="/view/home/home_compatibility.jsp"/>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#' + id).addClass('visible');
    }
</script>


<script src="<%=path%>/view/uc/login.js"></script>

</body>
</html>
