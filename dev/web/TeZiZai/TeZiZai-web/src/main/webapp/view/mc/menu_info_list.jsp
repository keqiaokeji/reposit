<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/view/home/home_head.jsp"/>


    <link rel="stylesheet" type="text/css" href="<%=path%>/phone/resources/css/style-min.css?v1.2.32">
    <link rel="stylesheet" type="text/css" href="<%=path%>/phone/resources/css/alert.css?v1.6">


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
                <div class="cate_main ">
                    <dl class="item cf" onclick="window.location.href='#'">
                        <h2>[素菜]酸辣土豆丝</h2>
                        <dt><a href="ticket.html">
                            <img src="<%=path%>/phone/resources/img/20140219095900692.jpg">
                        </a>
                        <div class="ico_zhu">
                            <div class="ui-iconfont ico_caidai">&#61472;</div>
                            <span class="txt">主<br>办</span>
                        </div>
                        </dt>
                        <dd><i class="ico ico_time">优惠价格：</i><span class="price_favorable">15元</span>
                            <span class="sail_num">销售总量：125份</span></dd>
                        <dd><i class="ico ico_cost"><del>实际价格：</del></i>
                            <span class="price_real"><del>18</del></span>
                            <span class="sail_num">评价：******</span></dd>
                        <dd><i class="ico ico_cost">单位：</i>
                            <span class="cost">份数</span></dd>
                        <dd>
                            <span class="ico_tag">删除</span>
                            <span class="ico_tag yu">修改</span>
                            <span class="ico_tag yu">查看评论</span>
                        </dd>
                    </dl>

                    <dl class="item cf" onclick="window.location.href='#'">
                        <h2>[荤菜]手撕包菜</h2>
                        <dt><a href="ticket.html">
                            <img src="<%=path%>/phone/resources/img/20140219095900692.jpg">
                        </a>
                        <div class="ico_zhu">
                            <div class="ui-iconfont ico_caidai">&#61472;</div>
                            <span class="txt">主<br>办</span>
                        </div>
                        </dt>
                        <dd><i class="ico ico_time">优惠价格：</i><span class="price_favorable">15元</span>
                            <span class="sail_num">销售总量：125份</span></dd>
                        <dd><i class="ico ico_cost"><del>实际价格：</del></i>
                            <span class="price_real"><del>18</del></span>
                            <span class="sail_num">评价：******</span></dd>
                        <dd><i class="ico ico_cost">单位：</i>
                            <span class="cost">份数</span></dd>
                        <dd>
                            <span class="ico_tag">删除</span>
                            <span class="ico_tag yu">修改</span>
                            <span class="ico_tag yu">查看评论</span>
                        </dd>
                    </dl>

                    <dl class="item cf" onclick="window.location.href='#'">
                        <h2>[深圳]罗素红Russian Red《Fuertevent</h2>
                        <dt><a href="ticket.html">
                            <img src="<%=path%>/phone/resources/img/20140513155605850.jpg">
                        </a>
                        <div class="ico_zhu">
                            <div class="ui-iconfont ico_caidai">&#61472;</div>
                            <span class="txt">主<br>办</span>
                        </div>
                        </dt>
                        <dd><i class="ico ico_time">时间：</i><span class="time">2014.06.07</span></dd>
                        <dd><i class="ico ico_cost">场馆：</i>
                            <span class="time">聚橙网</span></dd>
                        <dd><i class="ico ico_cost">价格：</i>
                            <span class="cost">80-80元</span></dd>
                        <dd>
                            <span class="ico_tag">售票中</span>
                        </dd>
                    </dl>

                    <dl class="item cf" onclick="window.location.href='#'">
                        <h2>[深圳]CD碟-罗素红Russian Red《Agent </h2>
                        <dt><a href="ticket.html">
                            <img src="<%=path%>/phone/resources/img/20140513155605850.jpg">
                        </a>
                        <div class="ico_zhu">
                            <div class="ui-iconfont ico_caidai">&#61472;</div>
                            <span class="txt">主<br>办</span>
                        </div>
                        </dt>
                        <dd><i class="ico ico_time">时间：</i><span class="time">2014.06.07</span></dd>
                        <dd><i class="ico ico_cost">场馆：</i>
                            <span class="time">聚橙网</span></dd>
                        <dd><i class="ico ico_cost">价格：</i>
                            <span class="cost">80-80元</span></dd>
                        <dd>
                            <span class="ico_tag">售票中</span>
                        </dd>
                    </dl>

                    <dl class="item cf" onclick="window.location.href='#'">
                        <h2>[深圳]民谣小女巫—罗素红《库伯探员》2014中国巡演</h2>
                        <dt><a href="ticket.html">
                            <img src="<%=path%>/phone/resources/img/2014032714050816.jpg">
                        </a>
                        <div class="ico_zhu">
                            <div class="ui-iconfont ico_caidai">&#61472;</div>
                            <span class="txt">主<br>办</span>
                        </div>
                        </dt>
                        <dd><i class="ico ico_time">时间：</i><span class="time">2014.06.08</span></dd>
                        <dd><i class="ico ico_cost">场馆：</i>
                            <span class="time">深圳音乐厅</span></dd>
                        <dd><i class="ico ico_cost">价格：</i>
                            <span class="cost">100-380元</span></dd>
                        <dd>
                            <span class="ico_tag">售票中</span>
                        </dd>
                    </dl>

                    <dl class="item cf" onclick="window.location.href='#'">
                        <h2>[上海]罗素红Russian Red《Fuertevent</h2>
                        <dt><a href="ticket.html">
                            <img src="<%=path%>/phone/resources/img/2014032714050816.jpg">
                        </a>
                        <div class="ico_zhu">
                            <div class="ui-iconfont ico_caidai">&#61472;</div>
                            <span class="txt">主<br>办</span>
                        </div>
                        </dt>
                        <dd><i class="ico ico_time">时间：</i><span class="time">2014.06.09</span></dd>
                        <dd><i class="ico ico_cost">场馆：</i>
                            <span class="time">聚橙网</span></dd>
                        <dd><i class="ico ico_cost">价格：</i>
                            <span class="cost">80-80元</span></dd>
                        <dd>
                            <span class="ico_tag">售票中</span>
                        </dd>
                    </dl>

                    <dl class="item cf" onclick="window.location.href='#'">
                        <h2>[上海]CD碟-罗素红Russian Red《Agent </h2>
                        <dt><a href="ticket.html">
                            <img src="<%=path%>/phone/resources/img/2014032714050816.jpg">
                        </a>
                        <div class="ico_zhu">
                            <div class="ui-iconfont ico_caidai">&#61472;</div>
                            <span class="txt">主<br>办</span>
                        </div>
                        </dt>
                        <dd><i class="ico ico_time">时间：</i><span class="time">2014.06.09</span></dd>
                        <dd><i class="ico ico_cost">场馆：</i>
                            <span class="time">聚橙网</span></dd>
                        <dd><i class="ico ico_cost">价格：</i>
                            <span class="cost">80-80元</span></dd>
                        <dd>
                            <span class="ico_tag">售票中</span>
                        </dd>
                    </dl>
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

</div><!-- /.main-container -->

<jsp:include page="/view/home/home_compatibility.jsp"/>


</body>
</html>
