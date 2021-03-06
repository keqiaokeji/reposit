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

        //对筛选条件的下拉选课添加事件
        $(document).ready(function () {
            $("#popupDialogMenuType").click(function () {
                $.tipsWindow({
                    ___content: "id:popupDialog-screen-type",
                    //___width:"600",
                    //___height:"300",
                    ___drag: "___boxTitle",
                    ___closeID: "menuTypeClose",
                    ___showbg: true
                })
            });

            $("#popupDialog-time").click(function () {
                $.tipsWindow({
                    ___content: "id:popupDialog-screen-time",
                    //___width:"600",
                    //___height:"300",
                    ___drag: "___boxTitle",
                    ___closeID: "menuOrderClose",
                    ___showbg: true
                })
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
    <a href="javascript:void(0)" class="tab2" id="popupDialogMenuType">菜单类型</a>
    <a href="javascript:void(0)" class="tab3" id="popupDialog-time">菜单排序</a>
</div>
<div class="warp pt17">

    <div class="cate_main ">


    </div>

    <div id="loadMoreBtn" class="loadMore" data_id="1">点击加载更多</div>

    <div data-role="popup" id="popupDialog-screen-type" style="display:none;">
        <div class="pop-list" id="pop_list_types">
            <div class="title">
                <h2>选择分类</h2>
                <a href="javascript:;" id="menuTypeClose" class="close">关闭</a>
            </div>
            <div class="content">
                <ul class="panel_sb">
                    <div id="menuTypeSelect">
                        <li id="menuTypeSelect_" class="sbon">
                            <div class="txt" onclick="selectMenuType('')">全部</div>
                        </li>
                    </div>
                </ul>
            </div>
        </div>
    </div>


    <div data-role="popup" id="popupDialog-screen-time" style="display:none;">
        <div class="pop-list" id="pop_list_times">
            <div class="title">
                <h2>选择排序字段</h2>
                <a href="javascript:;" id="menuOrderClose" class="close">关闭</a>
            </div>
            <div class="content">
                <ul class="panel_sb">
                    <li class="sbon" id="menuOrderSelect__">
                        <div class="txt" onclick="selectMenuOrder('','')">默认排序</div>
                    </li>
                    <li id="menuOrderSelect_price_favorable_asc" class="">
                        <div class="txt" onclick="selectMenuOrder('price_favorable', 'asc')">按价格升序排列</div>
                    </li>
                    <li id="menuOrderSelect_price_favorable_desc" class="">
                        <div class="txt" onclick="selectMenuOrder('price_favorable', 'desc')">按价格降序排列</div>
                    </li>
                    <li id="menuOrderSelect_menu_name_asc" class="">
                        <div class="txt" onclick="selectMenuOrder('menu_name', 'asc')">按名称升序排列</div>
                    </li>
                    <li id="menuOrderSelect_menu_name_desc" class="">
                        <div class="txt" onclick="selectMenuOrder('menu_name', 'desc')">按名称降序排列</div>
                    </li>
                </ul>
            </div>
        </div>
    </div>


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
var menuTypeIdValue = "";
var menuOrderValue = " ";//默认值为一个空格的字符串，代码默认排序
var pageNoValue = 1;
var rowsValue = 5;
var menuTypeList;//菜单类型列表
var menuInfoList;//菜单信息列表

initMenuType();
function initMenuType() {
    $.ajax({
        type: "post",
        async: true,//异步，如果等于false 那么就是同步
        url: app.baseUrlSvc + "/customer/mc/getMenuTypeList.do?menuTableId=" + menuTableId,
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
    if (data.dataRows.length > 0) {
        menuTypeList = data.dataRows;
        loadMenuInfo();
        initMenuTypeSelect();
    } else {
        alert("暂无菜单信息！");
    }
}

//获得已点菜单信息
function initMenuListInfos() {
    $.ajax({
        type: "post",
        async: false,//异步，如果等于false 那么就是同步
        url: app.baseUrlSvc + "/customer/mc/getMenuListInfos.do?menuTableId=" + menuTableId,
        dataType: "json",
        data: "",
        success: function (data) {
            if (data.statusCode == "SUCCESS" && !app.isEmpty(data.dataRows)) {
                app.setMenuListInfos(menuTableId, data.dataRows);
            }
        },
        error: function (data) {
            showWarnMsg("请求服务器出错！");
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


function initMenuTypeSelect() {
    var html = "";
    for (var i = 0; i < menuTypeList.length; i++) {
        var menuType = menuTypeList[i];
        html = html + "<li id='menuTypeSelect_" + menuType.menuTypeId + "' class='' > "
                + "<div class='txt' onclick='selectMenuType(\"" + menuType.menuTypeId + "\")'>" + menuType.menuTypeName + "</div></li>";
    }
    $("#menuTypeSelect").append(html);
}


function selectMenuType(menuTypeId) {
    pageNoValue = 1;
    $("#menuTypeClose").click();//关闭选择画面
    $(".cate_main").empty();//清空现有的菜单内容
    $("#menuTypeSelect_" + menuTypeIdValue).removeClass();
    menuTypeIdValue = menuTypeId;
    $("#menuTypeSelect_" + menuTypeId).attr("class", "sbon");
    loadMenuInfo();
}

function selectMenuOrder(menuName, menuOrder) {
    pageNoValue = 1;
    $("#menuOrderClose").click();//关闭选择画面
    $(".cate_main").empty();//清空现有的菜单内容
    var menuOrderValueOld = menuOrderValue.replace(" ", "_");
    $("#menuOrderSelect_" + menuOrderValueOld).removeClass();
    menuOrderValue = menuName + " " + menuOrder;
    $("#menuOrderSelect_" + menuName + "_" + menuOrder).attr("class", "sbon");
    loadMenuInfo();
}

function loadMenuInfoMore() {
    var flag = $("#loadMoreBtn").attr('data_id');
    if (flag == 1) {
        loadMenuInfo();
    }
}

function loadMenuInfo() {
    var paramData = {menuTypeId: menuTypeIdValue, order: menuOrderValue,
        pageNo: pageNoValue, rows: rowsValue};
    $.ajax({
        type: 'post',
        async: true,
        url: app.baseUrlSvc + "/customer/mc/getMenuInfoListByTableId.do?menuTableId=<%=menuTableId%>",
        data: paramData,
        dataType: 'json',
        error: function () {
            alert("请稍后再试！");
        },
        beforeSend: function () {
            $("#loadMoreBtn").html("<i></i>点击加载更多");
            $("#loadMoreBtn").unbind("click");
        },
        success: function (data) {
            appendMenuInfo(data);
        },
        complete: function () {
            initMenuListInfos();
            updateMenuListinfos();
        }
    });
}


function appendMenuInfo(data) {
    var html = "";
    if (data != null) {
        if (data.statusCode == "SUCCESS" && data.dataRows.length > 0) {
            menuInfoList = data.dataRows[0].dataRows;
            if (menuInfoList != null && appendMenuInfo.length > 0) {
                for (var i = 0; i < menuInfoList.length; i++) {
                    var menuInfo = menuInfoList[i];
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
                            + "  <span class='price_real_title'><del>实际价格：</del><span><del><span id='price_real_" + menuInfo.menuId + "' class='price_real'>" + menuInfo.priceReal + "</span></dd>                                         "
                            + "  <dd>                                                                                     "
                            + "  <i class='ico ico_cost'>                                                                 "
                            + "          销售总量：                                                            "
                            + "  </i>                                                                                     "
                            + "  <span class='sail_num'>" + menuInfo.sailNum + "</span>                                            "
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
            }
        }
    }

    if (html != "") {
        $(".cate_main").append(html);
        $("img.c").lazyload({
            placeholder: "resources/img/bank.png",
            effect: "fadeIn"
        });
    }
    if (html == "" || menuInfoList.length < rowsValue) {
        $("#loadMoreBtn").attr("data_id", 0);
        $("#loadMoreBtn").html("已加载完毕");
        $("#loadMoreBtn").unbind("click");
    } else {
        $("#loadMoreBtn").attr("data_id", 1);
        $("#loadMoreBtn").html("点击加载更多");
        $("#loadMoreBtn").bind("click", function () {
            loadMenuInfoMore();
        });
        pageNoValue++;
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

