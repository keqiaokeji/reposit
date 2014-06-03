<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>

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