App = function () {//构造函数
    this.tokenKey = "token";
    this.userInfoKey = "userInfoKey";
    this.baseUrlSvc = "http://localhost/TeZiZai-svc";
    this.baseUrlWeb = "http://localhost/TeZiZai-web";
    this.token = "";//记录当前用户的token
    this.userInfo;//记录挡墙用户的用户信息


    this.SUCCESS = "SUCCESS";
    this.FAIL = "FAIL";

}

App.prototype = { //定义方法

    setTokenToCookie: function (tokenValue) {
        this.token = tokenValue;
        var Days = 7;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = this.tokenKey + "=" + encodeURI(tokenValue) + ";expires=" + exp.toGMTString();
    },

    getTokenByCookie: function () {
        if (this.token == "") {
            var arr = document.cookie.match(new RegExp("(^| )" + this.tokenKey + "=([^;]*)(;|$)"));
            if (arr != null) {
                this.token = decodeURI(arr[2]);
            }
        }
        return this.token;

    },

    setUserInfoToCookie: function (userInfoJson) {
        var Days = 7;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = this.userInfoKey + "=" + encodeURI(userInfoJson) + ";expires=" + exp.toGMTString();
        this.userInfo = JSON.parse(userInfoJson);
    },

    getUserInfoByCookie: function () {
        if (this.userInfo == undefined) {
            var userInfoJsonContent = document.cookie.match(new RegExp("(^| )" + this.userInfoKey + "=([^;]*)(;|$)"));
            if (app.isEmpty(userInfoJsonContent) == false) {
                var userInfoJson = decodeURI(userInfoJsonContent[2]);
                this.userInfo = JSON.parse(userInfoJson);
            }
        }
        return this.userInfo;
    },

    isEmpty: function (value) {
        if (value == null || value == undefined || value == "undefined" || value.length < 1) {
            return true;
        } else {
            return false;
        }
    },


    /**
     * 更换验证码
     * @param codeKeyId 验证码键所在标签的ID
     * @param codeImgId 验证码图片所在标签的ID
     */
    changeVerifyCode: function (codeKeyId, codeImgId) {
        var codeKey = $(codeKeyId).val();
        var paramData = {"codeKey": codeKey};
        $.ajax({
            type: "post",
            async: true,//异步，如果等于false 那么就是同步
            url: app.baseUrlSvc + "/anonymous/cache/getVerifyCode.do",
            dataType: "json",
            data: paramData,
            success: function (data) {
                if (data != null) {
                    $(codeImgId).attr('src', data.imgUrl);
                    $(codeKeyId).val(data.codeKey);
                }
            },
            error: function (data) {
            }
        });
    },

    /**
     * 检查验证码是否正确，true:正确，false：错误
     * @param codeKeyId 验证码键所在标签的ID
     * @param codeContentId 验证码值所在标签的ID
     * @param codeImgId 验证码图片所在标签的ID
     */
    checkVerifyCode: function (codeKeyId, codeContentId, codeImgId) {
        var result = "FAIL";
        var codeKey = $(codeKeyId).val();
        var codeContent = $(codeContentId).val();
        var paramData = {"codeKey": codeKey, "codeContent": codeContent};
        $.ajax({
            type: "post",
            async: false,//异步，如果等于false 那么就是同步
            url: app.baseUrlSvc + "/anonymous/cache/checkVerifyCode.do",
            dataType: "json",
            data: paramData,
            success: function (data) {
                if (data != null && data == true) {
                    result = "SUCCESS";
                }
            },
            error: function (data) {
            }
        });
        changeVerifyCode(codeKeyId, codeImgId);
        return result;

    }


}

app = new App();


Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S": this.getMilliseconds()
    }
    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
}
