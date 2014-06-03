<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    final String MENU_HOME_TEXT = "控制台",
            MENU_CALENDAR_TEXT = "日历",
            MENU_GALLERY_TEXT = "相册",
            MENU_USER_TEXT = "用户管理", MENU_USER_INFO_TEXT = "用户信息", MENU_USER_LIST_TEXT = "用户列表",
            MENU_BUG_TEXT = "Bug管理", MENU_BUG_PROJECTCTRL_TEXT = "项目管理", MENU_BUG_INFOADD_TEXT = "添加Bug信息", MENU_BUG_INFOLIST_TEXT = "我的Bug";

    final String MENU_HOME = "menu_home",
            MENU_CALENDAR = "menu_calendar",
            MENU_GALLERY = "menu_gallery",
            MENU_USER = "menu_user", MENU_USER_INFO = "menu_user_info", MENU_USER_LIST = "menu_user_list",
            MENU_BUG = "menu_bug", MENU_BUG_PROJECTCTRL = "menu_bug_ProjectCtrl", MENU_BUG_INFOADD = "menu_bug_InfoAdd", MENU_BUG_INFOLIST = "menu_bug_InfoList";
    String currentMenu = MENU_HOME;
    final String CURRENT_MENU_KEY = "currentMenu";
    if (request.getParameter(CURRENT_MENU_KEY) != null) {
        currentMenu = request.getParameter(CURRENT_MENU_KEY);
    }


%>

<div class="breadcrumbs" id="breadcrumbs">
    <script type="text/javascript">
        try {
            ace.settings.check('breadcrumbs', 'fixed')
        } catch (e) {
        }
    </script>

    <ul class="breadcrumb">
        <li>
            <i class="icon-home home-icon"></i>
            <a href="<%=path%>/bootstrap/view/index.jsp?<%=CURRENT_MENU_KEY%>=<%=MENU_HOME%>">首页</a>
        </li>

        <% if (currentMenu.equalsIgnoreCase(MENU_HOME)) { %>
        <li class="active"><%=MENU_HOME_TEXT%></li>
        <%} %>

        <% if (currentMenu.equalsIgnoreCase(MENU_CALENDAR)) { %>
        <li class="active"><%=MENU_CALENDAR_TEXT%></li>
        <%} %>

        <% if (currentMenu.equalsIgnoreCase(MENU_GALLERY)) { %>
        <li class="active"><%=MENU_GALLERY_TEXT%></li>
        <%} %>

        <% if (currentMenu.equalsIgnoreCase(MENU_USER_INFO)) { %>
        <li><a class="active"><%=MENU_USER_TEXT%></a></li>
        <li class="active"><%=MENU_USER_INFO_TEXT%></li>
        <%} %>

        <% if (currentMenu.equalsIgnoreCase(MENU_USER_LIST)) { %>
        <li><a class="active"><%=MENU_USER_TEXT%></a></li>
        <li class="active"><%=MENU_USER_LIST_TEXT%></li>
        <%} %>

        <% if (currentMenu.equalsIgnoreCase(MENU_BUG_INFOADD)) { %>
        <li><a class="active"><%=MENU_BUG_TEXT%></a></li>
        <li class="active"><%=MENU_BUG_INFOADD_TEXT%></li>
        <%} %>

        <% if (currentMenu.equalsIgnoreCase(MENU_BUG_INFOLIST)) { %>
        <li><a class="active"><%=MENU_BUG_TEXT%></a></li>
        <li class="active"><%=MENU_BUG_INFOLIST_TEXT%></li>
        <%} %>

        <% if (currentMenu.equalsIgnoreCase(MENU_BUG_PROJECTCTRL)) { %>
        <li><a class="active"><%=MENU_BUG_TEXT%></a></li>
        <li class="active"><%=MENU_BUG_PROJECTCTRL_TEXT%></li>
        <%} %>


    </ul>
    <!-- .breadcrumb -->

    <div class="nav-search" id="nav-search">
        <form class="form-search">
        <span class="input-icon">
            <input type="text" placeholder="搜索 ..." class="nav-search-input"
                   id="nav-search-input" autocomplete="off"/>
            <i class="icon-search nav-search-icon"></i>
        </span>
        </form>
    </div>
    <!-- #nav-search -->

</div>
