//登录画面处理
jQuery(function ($) {

    var usernameId = "#username", passwordId = "#password",
        codeContentLoginId = "#codeContentLogin", codeKeyLoginId = "#codeKeyLogin", codeImgLoginId = "#codeImgLogin";

    app.changeVerifyCode(codeKeyLoginId, codeImgLoginId);
    $(codeImgLoginId).on('click', function () {
        app.changeVerifyCode(codeKeyLoginId, codeImgLoginId);
    });

    $('#loginBtn').on('click', function () {
        if (checkContent() == "SUCCESS") {
            var paramData = {"username": $(usernameId).val(), "password": $(passwordId).val(),
                codeKey: $(codeKeyLoginId).val(), codeContent: $(codeContentLoginId).val()};
            $.ajax({
                type: "get",
                async: true,//异步，如果等于false 那么就是同步
                url: app.baseUrl + "/anonymous/uc/loginUserWithVerifyCode.do",
                dataType: "json",
                data: paramData,
                success: function (data) {
                    if (data != null) {
                        if (data.statusCode == "LOGIN_SUCCESS") {
                            loginSuccess(data.content, data.token);
                        }
                        showWarnMsg(data.statusMsg);
                        app.changeVerifyCode(codeKeyLoginId, codeImgLoginId);
                    }
                },
                error: function (data) {
                    showWarnMsg("请求服务器出错！");
                }
            });
        }

    });

    function loginSuccess(content, takenValue) {
        if ($("#remberPassword").attr("checked") == "checked") {
            app.setTokenToCookie(takenValue);//如果是记住密码，则将Token信息存入cookie中
        }else{
            app.setTokenToCookie("");
        }
        app.setUserInfoToCookie(content);//将用户信息缓存到cookie中
        window.location.href = app.baseUrl + "/view/index.jsp";
    }

    function checkContent() {
        var result = "FAIL";
        if ($(usernameId).val() == "") {
            showWarnMsg("用户名不能为空！");
            $(usernameId).focus();
            return result;
        }

        if ($(passwordId).val() == "") {
            showWarnMsg("密码不能为空！");
            $(passwordId).focus();
            return result;
        }

        if ($(codeContentLoginId).val() == "") {
            showWarnMsg("验证码不能为空！");
            $(codeContentLoginId).focus();
            return result;
        }

        return "SUCCESS";
    }

    function showWarnMsg(msg) {
        $("#loginTitleInit").hide(1000);
        $("#loginTitleWarn").show(1000);
        $("#loginTitleWarnMsg").text(msg);
    }
});


//注册画面处理
jQuery(function ($) {
    var emailRegId = "#emailReg", usernameRegId = "#usernameReg", passwordRegId1 = "#passwordReg1", passwordRegId2 = "#passwordReg2",
        agreeRegId = "#agreeReg", regTitleInitId = "#regTitleInit", regTitleWarnId = "#regTitleWarn", regTitleWarnMsgId = "#regTitleWarnMsg",
        codeContentRegId = "#codeContentReg", codeImgRegId = "#codeImgReg", codeKeyRegId = "#codeKeyReg";

    //点击登录画面的“注册帐号”
    $('#loginToReg').on('click', function () {
        $(regTitleWarnId).hide();
        $(regTitleInitId).show();
        app.changeVerifyCode(codeKeyRegId, codeImgRegId)
    });

    $(codeImgRegId).on('click', function () {
        app.changeVerifyCode(codeKeyRegId, codeImgRegId);
    });

    $('#regBtn').on('click', function () {
        if (checkContent()) {
            var paramData = {"email": $(emailRegId).val(), "username": $(usernameRegId).val(), "password": $(passwordRegId1).val(),
                codeKey: $(codeKeyRegId).val(), codeContent: $(codeContentRegId).val()};
            $.ajax({
                type: "post",
                async: true,//异步，如果等于false 那么就是同步
                url: app.baseUrl + "/anonymous/uc/regUser.do",
                dataType: "json",
                data: paramData,
                success: function (data) {
                    if (data != null) {
                        if (data.statusCode == "REG_SUCCESS") {
                            regSuccess();
                        }
                        showWarnMsg(data.statusMsg);
                    }
                },
                error: function (data) {
                    showWarnMsg("请求服务器出错！");
                }
            });
        }
    });

    function regSuccess() {

    }

    function checkContent() {
        if ($(emailRegId).val() == "") {
            showWarnMsg("邮箱不能为空！");
            $(emailRegId).focus();
            return false;
        }

        if ($(usernameRegId).val() == "") {
            showWarnMsg("用户名不能为空！");
            $(usernameRegId).focus();
            return false;
        }

        if ($(passwordRegId1).val() == "") {
            showWarnMsg("密码不能为空！");
            $(passwordRegId1).focus();
            return false;
        }

        if ($(passwordRegId2).val() == "") {
            showWarnMsg("重复密码不能为空！");
            $(passwordRegId2).focus();
            return false;
        }

        if ($(passwordRegId1).val() != $(passwordRegId2).val()) {
            showWarnMsg("两次密码输入不一致！");
            $(passwordRegId2).focus();
            return false;
        }

        if ($(agreeRegId).attr("checked") != "checked") {
            showWarnMsg("注册前必须同意注册协议！");
            $(agreeRegId).focus();
            return false;
        }

        if ($(codeContentRegId).val() == "") {
            showWarnMsg("验证码不能为空！");
            $(codeContentRegId).focus();
            return false;
        }

        return true;
    }

    function showWarnMsg(msg) {
        $(regTitleInitId).hide(1000);
        $(regTitleWarnId).show(1000);
        $(regTitleWarnMsgId).text(msg);
    }


});


//找回密码画面处理
jQuery(function ($) {
    var emailFindPasswordId = "#emailFindPassword",
        findPasswordTitleInitId = "#findPasswordTitleInit", findPasswordTitleWarnId = "#findPasswordTitleWarn", findPasswordTitleWarnMsgId = "#findPasswordTitleWarnMsg",
        codeContentFindPasswordId = "#codeContentFindPassword", codeImgFindPasswordId = "#codeImgFindPassword", codeKeyFindPasswordId = "#codeKeyFindPassword";

    //点击登录画面的“注册帐号”
    $('#loginToFindPassword').on('click', function () {
        $(findPasswordTitleWarnId).hide();
        $(findPasswordTitleInitId).show();
        app.changeVerifyCode(codeKeyFindPasswordId, codeImgFindPasswordId)
    });

    $(codeImgFindPasswordId).on('click', function () {
        app.changeVerifyCode(codeKeyFindPasswordId, codeImgFindPasswordId);
    });

    $('#findPasswordBtn').on('click', function () {
        if (checkContent()) {
            var paramData = {"email": $(emailFindPasswordId).val(),
                codeKey: $(codeKeyFindPasswordId).val(), codeContent: $(codeContentFindPasswordId).val()};
            $.ajax({
                type: "post",
                async: true,//异步，如果等于false 那么就是同步
                url: app.baseUrl + "/anonymous/uc/findPasswordUser.do",
                dataType: "json",
                data: paramData,
                success: function (data) {
                    if (data != null) {
                        if (data.statusCode == "FIND_PASSWORD_SUCCESS") {
                            findPasswordSuccess();
                        }
                        showWarnMsg(data.statusMsg);
                        app.changeVerifyCode(codeKeyFindPasswordId, codeImgFindPasswordId);
                    }
                },
                error: function (data) {
                    showWarnMsg("请求服务器出错！");
                }
            });
        }
    });

    function findPasswordSuccess() {

    }

    function checkContent() {
        if ($(emailFindPasswordId).val() == "") {
            showWarnMsg("邮箱不能为空！");
            $(emailFindPasswordId).focus();
            return false;
        }

        if ($(codeContentFindPasswordId).val() == "") {
            showWarnMsg("验证码不能为空！");
            $(codeContentFindPasswordId).focus();
            return false;
        }

        return true;
    }

    function showWarnMsg(msg) {
        $(findPasswordTitleInitId).hide(1000);
        $(findPasswordTitleWarnId).show(1000);
        $(findPasswordTitleWarnMsgId).text(msg);
    }


});
