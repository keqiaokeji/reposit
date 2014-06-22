<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    final String MENU_HOME_TEXT = "控制台",
            MENU_CALENDAR_TEXT = "日历",
            MENU_GALLERY_TEXT = "相册",
            MENU_USER_TEXT = "用户管理", MENU_USER_INFO_TEXT = "用户信息", MENU_USER_LIST_TEXT = "用户列表",
            MENU_CORP_TEXT = "公司管理", MENU_CORP_LIST_TEXT = "公司列表",
            MENU_MENU_TEXT = "菜单管理", MENU_MENU_TYPE_CTRL_TEXT = "菜单分类管理", MENU_MENU_TABLE_CTRL_TEXT = "餐桌管理", MENU_MENU_INFO_EDIT_TEXT = "新增菜单", MENU_MENU_INFO_LIST_TEXT = "菜单列表";

    final String MENU_HOME = "menu_home",
            MENU_CALENDAR = "menu_calendar",
            MENU_GALLERY = "menu_gallery",
            MENU_USER = "menu_user", MENU_USER_INFO = "menu_user_info", MENU_USER_LIST = "menu_user_list",
            MENU_CORP = "menu_corp", MENU_CORP_LIST = "menu_corp_list",
            MENU_MENU = "menu_menu", MENU_MENU_TYPE_CTRL = "menu_menu_type_list", MENU_MENU_TABLE_CTRL = "menu_menu_table_list", MENU_MENU_INFO_EDIT = "menu_menu_info_edit", MENU_MENU_INFO_LIST = "menu_menu_info_list";

    String currentMenu = MENU_HOME;
    final String CURRENT_MENU_KEY = "currentMenu";
    if (request.getParameter(CURRENT_MENU_KEY) != null) {
        currentMenu = request.getParameter(CURRENT_MENU_KEY);
    }

%>
<%--左侧菜单栏公共画面--%>

<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="icon-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="icon-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="icon-group"></i>
            </button>

            <button class="btn btn-danger">
                <i class="icon-cogs"></i>
            </button>
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <!-- #sidebar-shortcuts -->

    <ul class="nav nav-list">
        <li <% if (currentMenu.equalsIgnoreCase(MENU_HOME)) { %> class="active" <%} %> >
            <a href="<%=path%>/view/index.jsp?<%=CURRENT_MENU_KEY%>=<%=MENU_HOME%>">
                <i class="icon-dashboard"></i>
                <span class="menu-text"> <%=MENU_HOME_TEXT%> </span>
            </a>
        </li>


        <li <% if (currentMenu.startsWith(MENU_USER)) { %>class="active open" <%} %> >
            <a href="#" class="dropdown-toggle">
                <i class="icon-user"></i>
                <span class="menu-text"> <%=MENU_USER_TEXT%> </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
                <li <% if (currentMenu.equalsIgnoreCase(MENU_USER_INFO)) { %> class="active" <%} %> >
                    <a href="<%=path%>/view/uc/uc_user_info.jsp?<%=CURRENT_MENU_KEY%>=<%=MENU_USER_INFO%>">
                        <i class="icon-double-angle-right"></i>
                        <%=MENU_USER_INFO_TEXT%>
                    </a>
                </li>

                <li <% if (currentMenu.equalsIgnoreCase(MENU_USER_LIST)) { %> class="active" <%} %> >
                    <a href="<%=path%>/view/uc/user_info_ctrl.jsp?<%=CURRENT_MENU_KEY%>=<%=MENU_USER_LIST%>">
                        <i class="icon-double-angle-right"></i>
                        <%=MENU_USER_LIST_TEXT%>
                    </a>
                </li>

            </ul>
        </li>

        <li <% if (currentMenu.startsWith(MENU_CORP)) { %>class="active open" <%} %> >
            <a href="#" class="dropdown-toggle">
                <i class="icon-list"></i>
                <span class="menu-text"> <%=MENU_CORP_TEXT%> </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
                <li <% if (currentMenu.equalsIgnoreCase(MENU_CORP_LIST)) { %> class="active" <%} %> >
                    <a href="<%=path%>/view/uc/corp_info_ctrl.jsp?<%=CURRENT_MENU_KEY%>=<%=MENU_CORP_LIST%>">
                        <i class="icon-double-angle-right"></i>
                        <%=MENU_CORP_LIST_TEXT%>
                    </a>
                </li>


            </ul>
        </li>

        <li <% if (currentMenu.startsWith(MENU_MENU)) { %>class="active open" <%} %> >
            <a href="#" class="dropdown-toggle">
                <i class="icon-food"></i>
                <span class="menu-text"> <%=MENU_MENU_TEXT%> </span>

                <b class="arrow icon-angle-down"></b>
            </a>

            <ul class="submenu">
                <li <% if (currentMenu.equalsIgnoreCase(MENU_MENU_TYPE_CTRL)) { %> class="active" <%} %> >
                    <a href="<%=path%>/view/mc/menu_type_info_ctrl.jsp?<%=CURRENT_MENU_KEY%>=<%=MENU_MENU_TYPE_CTRL%>">
                        <i class="icon-double-angle-right"></i>
                        <%=MENU_MENU_TYPE_CTRL_TEXT%>
                    </a>
                </li>

                <li <% if (currentMenu.equalsIgnoreCase(MENU_MENU_TABLE_CTRL)) { %> class="active" <%} %> >
                    <a href="<%=path%>/view/mc/menu_table_info_ctrl.jsp?<%=CURRENT_MENU_KEY%>=<%=MENU_MENU_TABLE_CTRL%>">
                        <i class="icon-double-angle-right"></i>
                        <%=MENU_MENU_TABLE_CTRL_TEXT%>
                    </a>
                </li>

                <li <% if (currentMenu.equalsIgnoreCase(MENU_MENU_INFO_EDIT)) { %> class="active" <%} %> >
                    <a href="<%=path%>/view/mc/menu_info_edit.jsp?<%=CURRENT_MENU_KEY%>=<%=MENU_MENU_INFO_EDIT%>">
                        <i class="icon-double-angle-right"></i>
                        <%=MENU_MENU_INFO_EDIT_TEXT%>
                    </a>
                </li>

                <li <% if (currentMenu.equalsIgnoreCase(MENU_MENU_INFO_LIST)) { %> class="active" <%} %> >
                    <a href="<%=path%>/view/mc/menu_info_list.jsp?<%=CURRENT_MENU_KEY%>=<%=MENU_MENU_INFO_LIST%>">
                        <i class="icon-double-angle-right"></i>
                        <%=MENU_MENU_INFO_LIST_TEXT%>
                    </a>
                </li>


            </ul>
        </li>



        <li <% if (currentMenu.equalsIgnoreCase(MENU_CALENDAR)) { %> class="active" <%} %> >
            <a href="<%=path%>/view/utils/calendar.jsp?<%=CURRENT_MENU_KEY%>=<%=MENU_CALENDAR%>">
                <i class="icon-calendar"></i>

                    <span class="menu-text">
                        <%=MENU_CALENDAR_TEXT%>
                        <span class="badge badge-transparent tooltip-error"
                              title="2&nbsp;Important&nbsp;Events">
                            <i class="icon-warning-sign red bigger-130"></i>
                        </span>
                    </span>
            </a>
        </li>

        <li <% if (currentMenu.equalsIgnoreCase(MENU_GALLERY)) { %> class="active" <%} %> >
            <a href="<%=path%>/view/utils/gallery.jsp?<%=CURRENT_MENU_KEY%>=<%=MENU_GALLERY%>">
                <i class="icon-picture"></i>
                <span class="menu-text"> <%=MENU_GALLERY_TEXT%> </span>
            </a>
        </li>


    </ul>
    <!-- /.nav-list -->


    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
    </div>

    <script type="text/javascript">
        try {
            ace.settings.check('sidebar', 'collapsed')
        } catch (e) {
        }
    </script>
</div>
<%--下面这个div是与父页面对接时使用--%>
<div class="main-content">

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
                <a href="<%=path%>/view/index.jsp?<%=CURRENT_MENU_KEY%>=<%=MENU_HOME%>">首页</a>
            </li>

            <% if (currentMenu.equalsIgnoreCase(MENU_HOME)) { %>
            <li class="active"><%=MENU_HOME_TEXT%>
            </li>
            <%} %>

            <% if (currentMenu.equalsIgnoreCase(MENU_CALENDAR)) { %>
            <li class="active"><%=MENU_CALENDAR_TEXT%>
            </li>
            <%} %>

            <% if (currentMenu.equalsIgnoreCase(MENU_GALLERY)) { %>
            <li class="active"><%=MENU_GALLERY_TEXT%>
            </li>
            <%} %>

            <% if (currentMenu.equalsIgnoreCase(MENU_USER_INFO)) { %>
            <li><%=MENU_USER_TEXT%>
            </li>
            <li class="active"><%=MENU_USER_INFO_TEXT%>
            </li>
            <%} %>

            <% if (currentMenu.equalsIgnoreCase(MENU_USER_LIST)) { %>
            <li><%=MENU_USER_TEXT%>
            </li>
            <li class="active"><%=MENU_USER_LIST_TEXT%>
            </li>
            <%} %>


            <% if (currentMenu.equalsIgnoreCase(MENU_CORP_LIST)) { %>
            <li><%=MENU_USER_TEXT%>
            </li>
            <li class="active"><%=MENU_CORP_LIST_TEXT%>
            </li>
            <%} %>


            <% if (currentMenu.equalsIgnoreCase(MENU_MENU_TYPE_CTRL)) { %>
            <li><%=MENU_MENU_TEXT%>
            </li>
            <li class="active"><%=MENU_MENU_TYPE_CTRL_TEXT%>
            </li>
            <%} %>

            <% if (currentMenu.equalsIgnoreCase(MENU_MENU_TABLE_CTRL)) { %>
            <li><%=MENU_MENU_TEXT%>
            </li>
            <li class="active"><%=MENU_MENU_TABLE_CTRL_TEXT%>
            </li>
            <%} %>

            <% if (currentMenu.equalsIgnoreCase(MENU_MENU_INFO_EDIT)) { %>
            <li><%=MENU_MENU_TEXT%>
            </li>
            <li class="active"><%=MENU_MENU_INFO_EDIT_TEXT%>
            </li>
            <%} %>

            <% if (currentMenu.equalsIgnoreCase(MENU_MENU_INFO_LIST)) { %>
            <li><%=MENU_MENU_TEXT%>
            </li>
            <li class="active"><%=MENU_MENU_INFO_LIST_TEXT%>
            </li>
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

    <%--下面这个div是与父页面对接时使用--%>
    <div class="page-content">
        <div class="page-header">
            <h1>
                <% if (currentMenu.equalsIgnoreCase(MENU_HOME)) { %>
                <%=MENU_HOME_TEXT%>
                <%} %>

                <% if (currentMenu.equalsIgnoreCase(MENU_CALENDAR)) { %>
                <%=MENU_CALENDAR_TEXT%>
                <%} %>

                <% if (currentMenu.equalsIgnoreCase(MENU_GALLERY)) { %>
                <%=MENU_GALLERY_TEXT%>
                <%} %>

                <% if (currentMenu.equalsIgnoreCase(MENU_USER_INFO)) { %>
                <%=MENU_USER_INFO_TEXT%>
                <%} %>

                <% if (currentMenu.equalsIgnoreCase(MENU_USER_LIST)) { %>
                <%=MENU_USER_LIST_TEXT%>
                <%} %>

                <% if (currentMenu.equalsIgnoreCase(MENU_CORP_LIST)) { %>
                <%=MENU_CORP_LIST_TEXT%>
                <%} %>

                <% if (currentMenu.equalsIgnoreCase(MENU_MENU_TYPE_CTRL)) { %>
                <%=MENU_MENU_TYPE_CTRL_TEXT%>
                <%} %>

                <% if (currentMenu.equalsIgnoreCase(MENU_MENU_TABLE_CTRL)) { %>
                <%=MENU_MENU_TABLE_CTRL_TEXT%>
                <%} %>

                <% if (currentMenu.equalsIgnoreCase(MENU_MENU_INFO_EDIT)) { %>
                <%=MENU_MENU_INFO_EDIT_TEXT%>
                <%} %>

                <% if (currentMenu.equalsIgnoreCase(MENU_MENU_INFO_LIST)) { %>
                <%=MENU_MENU_INFO_LIST_TEXT%>
                <%} %>

            </h1>
        </div>
        <!-- /.page-header -->
        <%--最后的一个编译器异常提示不需要处理，因为该页面属于部分页面，有部分标签需要和引入该页面的父页面做对接，所以暂不需要结束--%>

