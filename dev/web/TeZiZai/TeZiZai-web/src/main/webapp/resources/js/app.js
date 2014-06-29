App = function () {//构造函数
    this.cookieTokenKey = "token";
    this.cookieUserInfoKey = "cookieUserInfoKey";
    this.baseUrlSvc = "http://192.168.1.100/TeZiZai-svc";
    this.baseUrlWeb = "http://192.168.1.100/TeZiZai-web";
//    this.baseUrlSvc = "http://localhost/TeZiZai-svc";
//    this.baseUrlWeb = "http://localhost/TeZiZai-web";
    this.token = "";//记录当前用户的token
    this.userInfo;//记录挡墙用户的用户信息
    this.cookieMenuTableIdKey = "cookieMenuTableIdKey";
    this.cookieMenuListInfosKey = "cookieMenuListInfosKey";
    this.menuTableId;
    this.menuListInfos;


    this.SUCCESS = "SUCCESS";
    this.FAIL = "FAIL";

}

App.prototype = { //定义方法

    setTokenToCookie: function (tokenValue) {
        this.token = tokenValue;
        var Days = 7;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = this.cookieTokenKey + "=" + encodeURI(tokenValue) + ";expires=" + exp.toGMTString();
    },

    getTokenByCookie: function () {
        if (this.token == "") {
            var arr = document.cookie.match(new RegExp("(^| )" + this.cookieTokenKey + "=([^;]*)(;|$)"));
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
        document.cookie = this.cookieUserInfoKey + "=" + encodeURI(userInfoJson) + ";expires=" + exp.toGMTString();
        this.userInfo = JSON.parse(userInfoJson);
    },

    getUserInfoByCookie: function () {
        if (this.userInfo == undefined) {
            var userInfoJsonContent = document.cookie.match(new RegExp("(^| )" + this.cookieUserInfoKey + "=([^;]*)(;|$)"));
            if (app.isEmpty(userInfoJsonContent) == false) {
                var userInfoJson = decodeURI(userInfoJsonContent[2]);
                this.userInfo = JSON.parse(userInfoJson);
            }
        }
        return this.userInfo;
    },

    //将餐桌ID和该公司的菜单信息保存的cookie中，为了避免cookie的内容无限增大，cookie中始终只保留一个餐桌的信息
    setMenuListInfos: function (menuTableId, menuListInfos) {
        this.menuTableId = menuTableId;
        this.menuListInfos = menuListInfos;
        var menuListInfosJson = JSON.stringify(menuListInfos);
        var Days = 1;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
        document.cookie = this.cookieMenuTableIdKey + "=" + encodeURI(menuTableId) + ";expires=" + exp.toGMTString();
        document.cookie = this.cookieMenuListInfosKey + "=" + encodeURI(menuListInfosJson) + ";expires=" + exp.toGMTString();
    },


    getMeuTableId: function () {
        if(this.isEmpty(this.menuTableId)){
            var arr = document.cookie.match(new RegExp("(^| )" + this.cookieMenuTableIdKey + "=([^;]*)(;|$)"));
            if (arr != null) {
                this.menuTableId = decodeURI(arr[2]);
            }
        }
        return this.menuTableId;
    },


    getMenuListInfos: function (menuTableId) {
        if(menuTableId == this.getMeuTableId()){
            if (!this.isEmpty(this.menuListInfos)) {
                var arr = document.cookie.match(new RegExp("(^| )" + this.cookieMenuListInfosKey + "=([^;]*)(;|$)"));
                if (arr != null) {
                    this.menuListInfos = JSON.parse(decodeURI(arr[2]));
                }
            }
        }
        return this.menuListInfos;
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
