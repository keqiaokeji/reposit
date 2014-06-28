<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String menuTableId = request.getParameter("menuTableId");
%>
<!DOCTYPE HTML>

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="菜单列表"/>
    <meta name="description" content="菜单详情"/>
    <title>菜单列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-app-status-bar-style" content="white"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="copyright" content="Copyright (c) 2007-2014 juooo"/>

    <link rel="stylesheet" type="text/css" href="resources/css/style-min.css?v1.2.32">
    <link rel="stylesheet" type="text/css" href="resources/css/style-menu.css">
    <link rel="stylesheet" type="text/css" href="resources/css/alert.css?v1.6">

    <script src="resources/js/jquery-1.7.1.min.js"></script>
    <script src="resources/js/TouchSlide.1.1.js"></script>
    <script src="resources/js/jquery.lazyload.mini.js"></script>
    <script src="resources/js/base.js?v1.2"></script>
    <script src="resources/js/juooostatistics.js"></script>
    <script src="resources/js/jquery.tipswindow-2.2.js"></script>

    <script>
        $(window).load(function () {
            if ($("#loadingBj") && $(".ajaxLoad")) {
                $("#loadingBj").hide();
                $(".ajaxLoad").hide();
            }
        });

        $(function () {
            $(".cate_main img").lazyload({
                placeholder: "resources/img/bank.png",
                //container : ".tg_coun",
                effect: "fadeIn"
            });
        });
    </script>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#popupDialog-city").click(function () {
                $.tipsWindow({
                    ___content: "id:popupDialog-screen-city",
                    //___width:"600",
                    //___height:"300",
                    ___drag: "___boxTitle",
                    ___closeID: "c2",
                    ___showbg: true
                })
            });

            $("#popupDialog-type").click(function () {
                $.tipsWindow({
                    ___content: "id:popupDialog-screen-type",
                    //___width:"600",
                    //___height:"300",
                    ___drag: "___boxTitle",
                    ___closeID: "c3",
                    ___showbg: true
                })
            });

            $("#popupDialog-time").click(function () {
                $.tipsWindow({
                    ___content: "id:popupDialog-screen-time",
                    //___width:"600",
                    //___height:"300",
                    ___drag: "___boxTitle",
                    ___closeID: "c4",
                    ___showbg: true
                })
            });
        });
    </script>

    <script>
        $(function () {
            var navH = $(".list_tab").offset().top;
            $(window).scroll(function () {
                var scroH = $(this).scrollTop();
                if (scroH >= navH) {
                    $(".list_tab").css({"position": "fixed", "width": "100%", "top": 0, "left": "0"});
                } else if (scroH < navH) {
                    $(".list_tab").css({"position": "static"});
                }
                //console.log(scroH==navH);
            });
        });
    </script>
</head>
<body ontouchmove="check_move()">
<script>
    function check_move() {
        if ($(".juMenu").hasClass('juMenuPay')) {
            $(".juMenu").removeClass('juMenuPay');
        }
    }
</script>
<div id="loadingBj"></div>
<div class="ajaxLoad">
    <span class="loading"><em class="loading-em"></em></span>
    <span class="loading-color">努力加载中...</span>
</div>
<div class="g-hd">
    <div class="l">
        <div class="br1">
            <a href="index.html" class="btn_back">返回</a>
        </div>
    </div>
    <h1 class="sp logo">聚橙网触屏版</h1>

    <div class="city"><a href="#"><i class="AppFonts">&#xf014a;</i>全国</a></div>
</div>

<div class="list_tab"><!--<div class="list_tab fixed"> -->
    <a href="javascript:void(0)" class="tab2" id="popupDialog-type">菜单类型</a>
    <a href="javascript:void(0)" class="tab3" id="popupDialog-time">菜单排序</a>
</div>
<div class="warp pt17">

    <div class="cate_main ">

        <%--<dl class='item cf' onclick=''>--%>
        <%--<h2>[荤菜]手撕包菜</h2>--%>
        <%--<dt><a href='ticket.html'>--%>
        <%--<img src='<%=path%>/phone/resources/img/20140219095900692.jpg'>--%>
        <%--</a>--%>
        <%--<div class='ico_zhu'>--%>
        <%--<div class='ui-iconfont ico_caidai'>&#61472;</div>--%>
        <%--<span class='txt'>主<br>办</span>--%>
        <%--</div>--%>
        <%--</dt>--%>
        <%--<dd><i class='ico ico_time'>优惠价格：</i><span class='price_favorable'>15元</span>--%>
        <%--<span class='sail_num'>销售总量：125份</span></dd>--%>
        <%--<dd><i class='ico ico_cost'>--%>
        <%--<del>实际价格：</del>--%>
        <%--</i>--%>
        <%--<span class='price_real'><del>18</del></span>--%>
        <%--<span class='sail_num'>评价：******</span></dd>--%>
        <%--<dd><i class='ico ico_cost'>数量：</i>--%>
        <%--<span class='cost'>1份</span></dd>--%>
        <%--<dd>--%>
        <%--<span class='ico_tag'>减-</span>--%>
        <%--<span class='ico_tag yu'>加+</span>--%>
        <%--<span class='ico_tag yu'>查看评论</span>--%>
        <%--</dd>--%>
        <%--</dl>--%>

        <%--<dl class='item cf' onclick=''>--%>
        <%--<span class='hide'>15元</span>--%>

        <%--<h2>[荤菜]手撕包菜</h2>--%>
        <%--<dt>--%>
        <%--<a href='ticket.html'><img src='<%=path%>/phone/resources/img/20140219095900692.jpg'></a>--%>
        <%--<div class='ico_zhu'>--%>
        <%--<div class='ui-iconfont ico_caidai'>&#61472;</div>--%>
        <%--<span class='txt'>主<br>办</span>--%>
        <%--</div>--%>
        <%--</dt>--%>
        <%--<dd><i class='ico ico_time'>优惠价格：</i><span class='price_favorable'>15元</span>--%>
        <%--<span class='sail_num'>销售总量：125份</span></dd>--%>
        <%--<dd>--%>
        <%--<i class='ico ico_cost'>--%>
        <%--<del>实际价格：</del>--%>
        <%--</i>--%>
        <%--<span class='price_real'><del>18</del></span>--%>
        <%--<span class='sail_num'>评价：******</span></dd>--%>
        <%--<dd><i class='ico ico_cost'>数量：</i>--%>
        <%--<span class='cost'>1份</span></dd>--%>
        <%--<dd>--%>
        <%--<span class='button'>取消-</span>--%>
        <%--<span class='button select_button'>选择+</span>--%>
        <%--<span class='button select_button'>备注</span>--%>
        <%--</dd>--%>
        <%--</dl>--%>

    </div>

    <div class="loadMore" data_id="1">点击加载更多</div>


    <div data-role="popup" id="popupDialog-screen-type" style="display:none;">
        <div class="pop-list" id="pop_list_types">
            <div class="title">
                <h2>选择分类</h2>
                <a href="javascript:;" id="c3" class="close">关闭</a>
            </div>
            <div class="content">
                <ul class="panel_sb">
                    <li class="sbon" onclick="settypes(0)">
                        <div class="txt" onclick="settimes(0)">全部</div>
                    </li>
                    <li class="" onclick="settypes(0)">
                        <div class="txt" onclick="settypes(0)">豫菜</div>
                    </li>
                    <li class="sbon" onclick="settypes(35)">
                        <div class="txt">湘菜</div>
                    </li>
                    <li class="" onclick="settypes(36)">
                        <div class="txt">饮料</div>
                    </li>
                </ul>
            </div>
        </div>
    </div>


    <div data-role="popup" id="popupDialog-screen-time" style="display:none;">
        <div class="pop-list" id="pop_list_times">
            <div class="title">
                <h2>选择排序字段</h2>
                <a href="javascript:;" id="c4" class="close">关闭</a>
            </div>
            <div class="content">
                <ul class="panel_sb">
                    <li class="sbon" onclick="settime(0)">
                        <div class="txt" onclick="settimes(0)">不排序</div>
                    </li>
                    <li class="" onclick="settimes(2)">
                        <div class="txt">按名称</div>
                    </li>
                    <li class="" onclick="settimes(1)">
                        <div class="txt">按类型</div>
                    </li>
                    <li class="" onclick="settimes(3)">
                        <div class="txt">按价格</div>
                    </li>
                </ul>
            </div>
        </div>
    </div>


    <!---

    //公共底部begin

    -->

    <div class="foot-menu">
        <a id="orderMenuList" href="#" class="myjuo"><i class="sp"></i>下单</a>
        <a href="Index/follow" class="atte"><i class="sp"></i>关注聚橙</a>
    </div>
    <div class="tel"><a href="tel_3A4001858666"><i class="fontIcon fa-phone"></i>客服:400-185-8666</a></div>
    <div class="juMenu">
        <div class="t">
            <div class="menuBottomLogo" onclick="check_footer(this)"><span id="totalMenuNum"
                                                                           class="totalMenuNum">0</span></div>
        </div>
        <div class="juSearch">
            <input class="text" onfocus="if(value=='请输入演出、艺人、场馆名称') {value=''}"
                   onblur="if (value=='') {value='请输入演出、艺人、场馆名称'}" value="请输入演出、艺人、场馆名称" type="text">
            <a href="javascript:;" class="btn"><i class="icon_txt s_btnIco"></i></a>
        </div>
        <div class="juMenu_list">
            <ul>
                <li class="nav01"><a href="menu_list.jsp?menuTableId=<%=menuTableId%>"><i class="AppFonts">&#xf00e9;</i>继续选菜</a></li>
                <li class="nav02"><a href="menu_chose_list.jsp?menuTableId=<%=menuTableId%>"><i class="ui-iconfont">
                    &#508;</i>我的订单</a>
            </ul>
            <ul>
                <li class="nav03"><a href="index/index"><i class="ui-iconfont">&#336;</i><span class="txt">首页</span></a>
                </li>
                <li class="nav04"><a href="#"><i class="ui-iconfont">&#430;</i>呼叫服务员</a></li>
            </ul>
        </div>
    </div>


    <script>
        /**
         * 底部
         * ?param  {[type]} obj [description]
         * ?return {[type]}     [description]
         */
        function check_footer(obj) {
            if ($(".juMenu").hasClass('juMenuPay')) {
                $(".juMenu").removeClass('juMenuPay');
            } else {
                $(".juMenu").addClass('juMenuPay');
            }
        }
    </script>

</div>

<script src="<%=path%>/resources/js/app.js"></script>

<script>

$(function () {
    $(".loadMore").bind("click", function () {
        loadMenuInfoMore(this);
    });
});

//    $(document).ready(function(){
//        var flag = $(this).attr('data_id');
//            alert("33333"+flag);
//    });


var menuTypeList;//菜单类型列表
initMenuType();
function initMenuType() {
    $.ajax({
        type: "post",
        async: true,//异步，如果等于false 那么就是同步
        url: app.baseUrlSvc + "/customer/mc/getMenuTypeList.do?menuTableId=<%=menuTableId%>",
        dataType: "json",
        data: "",
        success: function (data) {
            if (data != null) {
                if (data.statusCode == app.SUCCESS) {
                    getMenutypeSuccess(data);
                } else {
                    alert("获得菜单信息失败！");
                }
            }
        },
        error: function (data) {
            alert("请求服务器出错！");
        }
    });
}

function getMenutypeSuccess(data) {
    if (data.result.length > 0) {
        menuTypeList = data.result[0];
        loadMenuInfo(this);
    } else {
        alert("暂无菜单信息！");
    }
}

function formartMenuType(menuTypeId) {
    var type = "未知";
    for (var i = 0; i < menuTypeList.length; i++) {
        var menuType = menuTypeList[i];
        if (menuTypeId == menuType.menuTypeId || menuTypeId == menuType.menuTypeName) {
            type = menuType.menuTypeName;
            break;
        }
    }
    return type;
}


/**
 * 加载更多
 * ?param  {[type]} obj [description]
 * ?return {[type]}     [description]
 */
var page = 1;
var cid = 35;
var city_id = 0;
var time = 0;
function loadMenuInfoMore(obj) {
    var flag = $(obj).attr('data_id');
    if (flag == 1) {
        loadMenuInfo(obj);
    }
}


function loadMenuInfo(obj) {
    $.ajax({
        type: 'post',
        url: app.baseUrlSvc + "/customer/mc/getMenuListInfos.do?menuTableId=<%=menuTableId%>",
        data: "page=" + page + "&cid=" + cid + "&city_id=" + city_id + "&time=" + time,
        dataType: 'json',
        error: function () {
            alert("请稍后再试！");
        },
        beforeSend: function () {
            $(obj).html("<i></i>点击加载更多");
            $(obj).unbind("click");
        },
        success: function (data) {
            if (data != null) {
                if (data.statusCode == "SUCCESS" && !app.isEmpty(data.result)) {
                    var menuLists = data.result[0];
                    var html = "";
                    for (var i = 0; i < menuLists.length; i++) {
                        var menuInfo = menuLists[i];
                        html = html + "<dl class='item cf' onclick=''>"
                                + "<span id='menu_id_" + menuInfo.menuId + "' class='hide'>" + menuInfo.menuId + "</span><span id='menu_type_id_" + menuInfo.menuId + "' class='hide'>" + menuInfo.menuTypeId + "</span>"
                                + "           <h2>[<span id='menu_type_name_" + menuInfo.menuId + "'>" + formartMenuType(menuInfo.menuTypeId) + "</span>]<span id='menu_name_" + menuInfo.menuId + "'>" + menuInfo.menuName + "</span></h2>"
                                + "   <dt>                           "
                                + "  <a href='ticket.html'><img src='<%=path%>/phone/resources/img/menu_picture1.jpg'></a>"
                                + "  <div class='ico_zhu'>                                                                    "
                                + "          <div class='ui-iconfont ico_caidai'>&#61472;</div>                               "
                                + "  <span class='txt'>主<br>办</span>                                                         "
                                + "  </div>                                                                                   "
                                + "  </dt>                                                                                    "
                                + "  <dd><i class='ico ico_time'>优惠价格：</i><span id='price_favorable_'" + menuInfo.menuId + " class='price_favorable'>" + menuInfo.priceFavorable + "</span>        "
                                + "  <span class='price_real_title'><del>实际价格：</del><del><span id='price_real_" + menuInfo.menuId + "' class='price_real'>" + menuInfo.priceReal + "</span> </span></dd>                                         "
                                + "  <dd>                                                                                     "
                                + "  <i class='ico ico_cost'>                                                                 "
                                + "          菜单状态：                                                            "
                                + "  </i>                                                                                     "
                                + "  <span id='menu_status_" + menuInfo.menuId + "' class='menu_status'>" + getMenuStatus(menuInfo.status) + "</span>                                            "
                                + "  <span class='sail_num'>评价：******</span></dd>                                           "
                                + "  <dd><i class='ico ico_cost'>数量：</i>                                                    "
                                + "  <span id='menu_num_" + menuInfo.menuId + "' class='cost'>0</span><span id='menu_unit_" + menuInfo.menuId + "'>" + menuInfo.menuUnit + "</span></dd>                                                       "
                                + "  <dd>                                                                                     "
                                + "  <span class='button' onclick='decreaseMenuInfo(\"" + menuInfo.menuId + "\")'>取消-</span>                                                       "
                                + "  <span class='button select_button' onclick='addMenuInfo(\"" + menuInfo.menuId + "\")'>选择+</span>                                                    "
                                + "  <span class='button'>备注</span>                                                  "
                                + "  </dd>                                                                                    "
                                + "  </dl>                                                                                    ";

                    }

                    if (html != "") {
                        $(".cate_main").append(html);
                        $("img.c").lazyload({
                            placeholder: "resources/img/bank.png",
                            effect: "fadeIn"
                        });
                        page++;
                    } else {
                        $(obj).attr("data_id", 0);
                        $(obj).html("已加载全部");
                    }
                }

            }


        },
        complete: function () {
            $(".loadMore").bind("click", function () {
                loadMenuInfoMore(this);
            });
            if ($(obj).attr("data_id") == 1) {
                $(obj).html("点击加载更多");
            }
        }
    });
}


function getMenuStatus(status){
    var menuStatus = "未下单";
    if(status =="UNCONFIRM"){
        menuStatus = "未下单";
    } else if(status =="CONFIRM"){
        menuStatus = "已下单";
    }else if(status =="DELETE"){
        menuStatus = "已取消";
    }
    return menuStatus;
}

function addMenuInfo(menuId) {
    var oldMenuNum = parseInt($("#menu_num_" + menuId).text());
    var realPrice = $("#price_real_" + menuId).text();
    var favorablePrice = $("#price_favorable_" + menuId).text();
    if (app.isEmpty(favorablePrice)) {
        favorablePrice = realPrice;
    }

    var paramData = {menuId: $("#menu_id_" + menuId).text(), menuName: $("menu_name_" + menuId).text(), priceReal: realPrice,
        priceFavorable: favorablePrice, menuUnit: $("#menu_unit_" + menuId).text()};
    $.ajax({
        type: "get",
        async: false,//异步，如果等于false 那么就是同步
        url: app.baseUrlSvc + "/customer/mc/addMenuListInfo.do?menuTableId=<%=menuTableId%>",
        dataType: "json",
        data: paramData,
        success: function (data) {
            if (data != null) {
                if (data.statusCode == "SUCCESS") {
                    $("#menu_num_" + menuId).text(oldMenuNum + 1);
                    updateTotoleMenuNum(1);
                }
            }
        },
        error: function (data) {
            showWarnMsg("请求服务器出错！");
        }
    });
}

initOrderMenuListInfos();
function initOrderMenuListInfos() {
    $('#orderMenuList').on('click', function () {
        var paramData = {};
        $.ajax({
            type: "post",
            async: true,//异步，如果等于false 那么就是同步
            url: app.baseUrlSvc + "/customer/mc/orderMenuListInfos.do?menuTableId=<%=menuTableId%>",
            dataType: "json",
            data: paramData,
            success: function (data) {
                if (data != null) {
                    if (data.statusCode == "SUCCESS") {
                        loginSuccess(data);
                    }
                    showWarnMsg(data.statusMsg);
                    app.changeVerifyCode(codeKeyLoginId, codeImgLoginId);
                }
            },
            error: function (data) {
                showWarnMsg("请求服务器出错！");
            }
        });

    });


}


function decreaseMenuInfo(menuId) {
    var oldMenuNum = parseInt($("#menu_num_" + menuId).text());
    if (oldMenuNum > 0) {
        $("#menu_num_" + menuId).text(oldMenuNum - 1);
        updateTotoleMenuNum(-1);
    }
}


function updateTotoleMenuNum(num) {
    var oldTotleNum = parseInt($("#totalMenuNum").text());
    $("#totalMenuNum").text(oldTotleNum + num);
}


function open_city() {
    $("#mask_city").css('display', '');
    $("#pop_list_city").css({"-webkit-transform": "translateY(0)", "-webkit-transition": 'none', "transition": "none", "-webkit-transition": ' all 0.5s ease', "transition": 'all 0.5s ease'});
}


function check_close_city() {
//        $("#city").slideUp("slow");
    $("#mask_city").css('display', 'none');
    $("#pop_list_city").css({"-webkit-transform": "translateY(-500px)", "-webkit-transition": 'none', "transition": "none", "-webkit-transition": ' all 0.5s ease', "transition": 'all 0.5s ease'});
}


function open_types() {
//        $("#types").slideDown("slow");
    $("#mask_types").css('display', '');
    $("#pop_list_types").css({"-webkit-transform": "translateY(0)", "-webkit-transition": 'none', "transition": "none", "-webkit-transition": ' all 0.5s ease', "transition": 'all 0.5s ease'});
}

function check_close_types() {
    $("#mask_types").css('display', 'none');
    $("#pop_list_types").css({"-webkit-transform": "translateY(-500px)", "-webkit-transition": 'none', "transition": "none", "-webkit-transition": ' all 0.5s ease', "transition": 'all 0.5s ease'});
}


function open_times() {
    $("#mask_times").css('display', '');
    $("#pop_list_times").css({"-webkit-transform": "translateY(0)", "-webkit-transition": 'none', "transition": "none", "-webkit-transition": ' all 0.5s ease', "transition": 'all 0.5s ease'});
}


function check_close_times() {
    $("#mask_times").css('display', 'none');
    $("#pop_list_times").css({"-webkit-transform": "translateY(-500px)", "-webkit-transition": 'none', "transition": "none", "-webkit-transition": ' all 0.5s ease', "transition": 'all 0.5s ease'});
}


function setcity(id) {
    $.ajax({
        type: 'post',
        url: "list.html",
        data: 'cid=' + id,
        dataType: 'json',
        success: function (msg) {
            if (msg) {
                window.location.reload();
            }
        }
    })
}


var time = 0;
var cid = 35;
function settypes(id) {
    if (time) {
        window.location.href = "menu_list.jsp";
    } else {
        window.location.href = "menu_list.jsp";
    }
}

function settimes(id) {
    if (cid) {
        window.location.href = "menu_list.jsp";
    } else {
        window.location.href = "menu_list.jsp";
    }
}
</script>
</body>
</html>

