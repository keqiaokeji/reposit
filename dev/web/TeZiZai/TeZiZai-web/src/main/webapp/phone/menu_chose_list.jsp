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

    <script type="text/javascript">
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

        //滚动页面时筛选条件固定在顶端显示
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

        function check_move() {
            if ($(".juMenu").hasClass('juMenuPay')) {
                $(".juMenu").removeClass('juMenuPay');
            }
        }


        function check_footer(obj) {
            if ($(".juMenu").hasClass('juMenuPay')) {
                $(".juMenu").removeClass('juMenuPay');
            } else {
                $(".juMenu").addClass('juMenuPay');
            }
        }
    </script>
</head>
<body ontouchmove="check_move()">
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
    <a href="#" id="menu_list_" class="tab2" onclick="updateMenuStatus('')">已点菜单</a>
    <a href="#" id="menu_list_UNCONFIRM" class="tab2" onclick="updateMenuStatus('UNCONFIRM')">未下单</a>
    <a href="#" id="menu_list_CONFIRM" class="tab2" onclick="updateMenuStatus('CONFIRM')">已下单</a>
    <a href="#" id="menu_list_BACK" class="tab3" onclick="updateMenuStatus('BACK')">退单</a>
</div>

<div class="warp pt17">

    <div class="cate_main ">


    </div>

    <div id="loadMoreBtn" class="loadMore" data_id="1"><i></i>点击刷新菜单</div>


    <!---

    //公共底部begin

    -->

    <div class="foot-menu">
        <a href="User/login" class="myjuo"><i class="sp"></i>我的聚橙</a>
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
                <li class="nav01"><a href="menu_list.jsp?menuTableId=<%=menuTableId%>"><i class="AppFonts">&#xf00e9;</i>继续选菜</a>
                </li>
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

</div>

<script src="<%=path%>/resources/js/app.js"></script>

<script>

    var menuTableId = "<%=menuTableId%>";
    var menuStatus = "";

    loadMenuListInfos();


    $("#loadMoreBtn").bind("click", function () {
        $(".cate_main").empty();//清空现有的菜单内容
        loadMenuListInfos();
    });

    function updateMenuStatus(status) {
        menuStatus = status;
        $(".cate_main").empty();//清空现有的菜单内容
        loadMenuListInfos();
    }

    //获得已点菜单信息
    function loadMenuListInfos() {
        var paramData = {status: menuStatus};
        var menuListInfos;
        $.ajax({
            type: "post",
            async: false,//异步，如果等于false 那么就是同步
            url: app.baseUrlSvc + "/customer/mc/getMenuListInfos.do?menuTableId=" + menuTableId,
            dataType: "json",
            data: paramData,
            success: function (data) {
                if (data.statusCode == "SUCCESS" && !app.isEmpty(data.dataRows)) {
                    menuListInfos = data.dataRows;
                    if (app.isEmpty(menuStatus)) {//根据分类筛选的时候，不需要重置缓存
                        app.setMenuListInfos(menuTableId, data.dataRows);
                    }
                }
            },
            error: function (data) {
                showWarnMsg("请求服务器出错！");
            },
            complete: function () {
                if (!app.isEmpty(menuListInfos)) {
                    appendMenuInfo(menuListInfos);
                    $("#totalMenuNum").text(menuListInfos.length);
                }
            }
        });
    }

    //修改已点数量
    function updateMenuListinfos() {
        var menuListInfos = app.getMenuListInfos(menuTableId);
        if (!app.isEmpty(menuListInfos)) {
            $("#totalMenuNum").text(menuListInfos.length);
            for (var i = 0; i < menuListInfos.length; i++) {
                var menuListInfo = menuListInfos[i];
                $("#menu_num_" + menuListInfo.menuId).text(menuListInfo.menuNum);
            }
        }
    }


    function appendMenuInfo(data) {
        var html = "";
        if (!app.isEmpty(data)) {
            for (var i = 0; i < data.length; i++) {
                var menuListInfo = data[i];
                html = html + "<dl class='item cf' onclick=''>"
                        + "<span id='menu_id_" + menuListInfo.menuId + "' class='hide'>" + menuListInfo.menuId + "</span><span id='menu_type_id_" + menuListInfo.menuId + "' class='hide'>" + menuListInfo.menuTypeId + "</span>"
                        + "           <h2>[<span id='menu_type_name_" + menuListInfo.menuId + "'>" + menuListInfo.menuTypeName + "</span>]<span id='menu_name_" + menuListInfo.menuId + "'>" + menuListInfo.menuName + "</span></h2>"
                        + "   <dt>                           "
                        + "  <a href='ticket.html'><img src='<%=path%>/phone/resources/img/menu_picture1.jpg'></a>"
                        + "  <div class='ico_zhu'>                                                                    "
                        + "          <div class='ui-iconfont ico_caidai'>&#61472;</div>                               "
                        + "  <span class='txt'>主<br>办</span>                                                         "
                        + "  </div>                                                                                   "
                        + "  </dt>                                                                                    "
                        + "  <dd><i class='ico ico_time'>优惠价格：</i><span id='price_favorable_'" + menuListInfo.menuId + " class='price_favorable'>" + menuListInfo.priceFavorable + "</span>        "
                        + "  <span class='price_real_title'><del>实际价格：</del><span><del><span id='price_real_" + menuListInfo.menuId + "' class='price_real'>" + menuListInfo.priceReal + "</span></dd>                                         "
                        + "  <dd>                                                                                     "
                        + "  <i class='ico ico_cost'>                                                                 "
                        + "          菜单状态：                                                            "
                        + "  </i>                                                                                     "
                        + "  <span id='menu_status_" + menuListInfo.menuId + "' class='menu_status'>" + getMenuStatus(menuListInfo.status) + "</span>   "
                        + "  <span class='sail_num'>评价：******</span></dd>                                           "
                        + "  <dd><i class='ico ico_cost'>数量：</i>                                                    "
                        + "  <span id='menu_num_" + menuListInfo.menuId + "' class='cost'>" + menuListInfo.menuNum + "</span><span id='menu_unit_" + menuListInfo.menuId + "'>" + menuListInfo.menuUnit + "</span></dd>                                                       "
                        + "  <dd>                                                                                     "
                        + "  <span class='button' onclick='decreaseMenuInfo(\"" + menuListInfo.menuId + "\")'>取消-</span>                                                       "
                        + "  <span class='button select_button' onclick='addMenuInfo(\"" + menuListInfo.menuId + "\")'>选择+</span>                                                    "
                        + "  <span class='button'>备注</span>                                                  "
                        + "  </dd>                                                                                    "
                        + "  </dl>                                                                                    ";

            }
        }

        if (html != "") {
            $(".cate_main").append(html);
            $("img.c").lazyload({
                placeholder: "resources/img/bank.png",
                effect: "fadeIn"
            });
        }

    }

    function getMenuStatus(status) {
        var menuStatus = "未下单";
        if (status == "UNCONFIRM") {
            menuStatus = "未下单";
        } else if (status == "CONFIRM") {
            menuStatus = "已下单";
        } else if (status == "DELETE") {
            menuStatus = "已取消";
        }
        return menuStatus;
    }

    function addMenuInfo(menuIdValue) {
        var oldMenuNum = parseInt($("#menu_num_" + menuIdValue).text());
        var realPrice = $("#price_real_" + menuIdValue).text();
        var favorablePrice = $("#price_favorable_" + menuIdValue).text();
        if (app.isEmpty(favorablePrice)) {
            favorablePrice = realPrice;
        }

        var paramData = {menuId: $("#menu_id_" + menuIdValue).text(), menuName: $("#menu_name_" + menuIdValue).text(), priceReal: realPrice,
            menuTypeId: $("#menu_type_id_" + menuIdValue).text(), menuTypeName: $("#menu_type_name_" + menuIdValue).text(),
            priceFavorable: favorablePrice, menuUnit: $("#menu_unit_" + menuIdValue).text()};
        $.ajax({
            type: "post",
            async: false,//异步，如果等于false 那么就是同步
            url: app.baseUrlSvc + "/customer/mc/addMenuListInfo.do?menuTableId=<%=menuTableId%>",
            dataType: "json",
            data: paramData,
            success: function (data) {
                if (data != null) {
                    if (data.statusCode == "SUCCESS") {
                        app.setMenuListInfos(menuTableId, data.dataRows)
                        updateMenuListinfos();
                    }
                }
            },
            error: function (data) {
                showWarnMsg("请求服务器出错！");
            }
        });
    }


    function decreaseMenuInfo(menuIdValue) {
        var oldMenuNum = parseInt($("#menu_num_" + menuIdValue).text());
        var paramData = {menuId: $("#menu_id_" + menuIdValue).text()};
        $.ajax({
            type: "post",
            async: false,//异步，如果等于false 那么就是同步
            url: app.baseUrlSvc + "/customer/mc/decreaseMenuInfo.do?menuTableId=<%=menuTableId%>",
            dataType: "json",
            data: paramData,
            success: function (data) {
                if (data != null) {
                    if (data.statusCode == "SUCCESS") {
                        app.setMenuListInfos(menuTableId, data.dataRows)
                        updateMenuListinfos();
                    }
                }
            },
            error: function (data) {
                showWarnMsg("请求服务器出错！");
            },
            complete: function () {
                if (oldMenuNum == 1) {//如果数量是1，减去1之后，服务端不会再返回该菜单信息了，所以需要手动设定数量
                    $("#menu_num_" + menuIdValue).text(0);
                }
            }
        });

    }


</script>
</body>
</html>

