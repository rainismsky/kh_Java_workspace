<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description"
   content="A front-end template that helps you build fast, modern mobile web apps.">
<meta name="viewport"
   content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>Material Design Lite</title>


<!-- Tile icon for Win8 (144x144 + tile color) -->
<meta name="msapplication-TileImage"
   content="images/dia.jpg">
<meta name="msapplication-TileColor" content="#3372DF">

<link rel="shortcut icon" href="images/favicon.png">

<!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
<!--
    <link rel="canonical" href="http://www.example.com/">
    -->

<link rel="stylesheet"
   href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
<link rel="stylesheet"
   href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
   href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
   href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<link rel="stylesheet" href="/Education/tiles/styles.css">
<style>

#view-source {
   position: fixed;
   display: block;
   right: 0;
   bottom: 0;
   margin-right: 40px;
   margin-bottom: 40px;
   z-index: 900;
}
</style>
</head>
<body>	

<div
         class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
         <header class="demo-drawer-header">
            <img src="../images/dia.jpg" class="demo-avatar" width="50" height="50"><br>
            <div class="demo-avatar-dropdown">
               <span>${t_name} 계정</span>
               <div class="mdl-layout-spacer"></div>
               <button id="accbtn"
                  class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon">
                  <i class="material-icons" role="presentation">arrow_drop_down</i>
                  <span class="visuallyhidden">Accounts</span>
               </button>
               <ul
                  class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
                  for="accbtn">
                  <li class="mdl-menu__item">hello@example.com</li>
                  <li class="mdl-menu__item">info@example.com</li>
                  <li class="mdl-menu__item"><i class="material-icons">add</i>Add
                     another account...</li>
               </ul>
            </div>
         </header>
         <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
            <a class="mdl-navigation__link" href="/Education/Tpage/teacher_Mypage.do">
            <i class="mdl-color-text--blue-grey-400 material-icons"
               role="presentation">home</i>마이 페이지</a>
               
            <a class="mdl-navigation__link" href="/Education/administer/Item.do">
            <i class="mdl-color-text--blue-grey-400 material-icons"
               role="presentation">local_offer</i>비품현황</a>
               
            <a class="mdl-navigation__link" href="/Education/Tpage/ScheduleManage.do">
            <i class="mdl-color-text--blue-grey-400 material-icons"
               role="presentation">report</i>종합 스케쥴</a>
               
            <a class="mdl-navigation__link"
               href="/Education/administer/FileBoard.do">
            <i class="mdl-color-text--blue-grey-400 material-icons"
               role="presentation">inbox</i>자료게시판</a>
    
         </nav>
      </div>
		
</body>
</html>