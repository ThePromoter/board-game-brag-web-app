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
        <section id="main-content" class="grid-container">
            <header>
                <div id="logo"></div>
            </header>
            <nav id="main-nav">
                <ul>
                    <li>Header A</li>
                    <li>Header B</li>
                </ul>
            </nav>