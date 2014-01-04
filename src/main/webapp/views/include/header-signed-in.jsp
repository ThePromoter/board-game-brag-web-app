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
                    <div id="logo" class="grid-33 tablet-grid-33 mobile-grid-100 heading">
                        boardgamebrag
                    </div>
                    <nav id="main-nav" class="grid-66 tablet-grid-66 hide-on-desktop mobile-grid-100">
                        <ul class="horizontal large-icons">
                            <li>Gamer Profile</li>
                            <li>Recent Games</li>
                            <li>Game Collection</li>
                            <li>Play Groups</li>
                            <li>Rankings</li>
                        </ul>
                    </nav>
                </div>
            </header>
            
            <section id="main-content" class="shadow-top">
                <div class="grid-container">
