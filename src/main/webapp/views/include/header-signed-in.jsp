<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="x-ua-compatible" content="ie=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
        <title>Home</title>
        
        <!--[if lt IE 9]><script src="/my/static/js/lib/html5.js"></script><![endif]-->
        <%@ include file="import-css.jsp" %>
    </head>
    <body>
        <section id="page-container">
            <header>
                <div class="grid-container">
                    <div id="nav-drawer-toggle" class="hide-on-desktop hide-on-tablet toggle-nav"></div>
                    <div id="logo-banner" class="grid-33 tablet-grid-33 mobile-grid-100 heading">
<!--                         <div id="logo-icon"></div> -->
                        <div id="logo-text">boardgamebrag</div>
                    </div>
                    <nav id="main-nav" class="grid-66 tablet-grid-66 mobile-grid-100">
                        <ul class="horizontal small-icons main-actions">
                            <li><a class="button square toggle-nav hide-on-desktop hide-on-tablet">close</a></li>
                            <li class="icon dice action profile<c:if test="${pageName == 'profile'}"> active</c:if>"><span>Gamer Profile</span></li>
                            <li class="icon clock action history<c:if test="${pageName == 'history'}"> active</c:if>"><span>Recent Games</span></li>
                            <li class="icon library action collection<c:if test="${pageName == 'game-library'}"> active</c:if>"><span>Game Collection</span></li>
                            <li class="icon group action groups<c:if test="${pageName == 'game-groups'}"> active</c:if>"><span>Play Groups</span></li>
                            <li class="icon trophy action rankings<c:if test="${pageName == 'rankings'}"> active</c:if>"><span>Rankings</span></li>
                        </ul>
                    </nav>
                </div>
            </header>
            
            <div class="grid-parent grid-100 progress-bar"><div class="completed"></div></div>
            
<!--             <aside id="nav-drawer" class="hide-on-desktop hide-on-tablet"> -->
<!--                 <ul class="small-icons main-actions"> -->
<%--                     <li class="icon dice action profile<c:if test="${pageName == 'profile'}"> active</c:if>"><span>Gamer Profile</span></li> --%>
<%--                     <li class="icon clock action history<c:if test="${pageName == 'history'}"> active</c:if>"><span>Recent Games</span></li> --%>
<%--                     <li class="icon library action collection<c:if test="${pageName == 'game-library'}"> active</c:if>"><span>Game Collection</span></li> --%>
<%--                     <li class="icon group action groups<c:if test="${pageName == 'game-groups'}"> active</c:if>"><span>Play Groups</span></li> --%>
<%--                     <li class="icon trophy action rankings<c:if test="${pageName == 'rankings'}"> active</c:if>"><span>Rankings</span></li> --%>
<!--                 </ul> -->
<!--             </aside> -->
            
            <section id="main-content" class="shadow-top">
                <div class="grid-container">