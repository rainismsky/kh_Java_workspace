<%@ page contentType="text/html; charset=utf-8" %>
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
   content="images/touch/ms-touch-icon-144x144-precomposed.png">
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

<title>Insert title here</title>
</head>
<body>
	<div
      class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
      <header
         class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
         <div class="mdl-layout__header-row">
         
         <!-- HOME -->
         
            <span class="mdl-layout-title">${t_name}님 마이페이지입니다</span>
            <div class="mdl-layout-spacer"></div>
           <!--  <div
               class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
               <label class="mdl-button mdl-js-button mdl-button--icon"
                  for="search"> <i class="material-icons">search</i>
               </label>
               <div class="mdl-textfield__expandable-holder"> -->
               
              <!--  텍스트 인풋필드 
                  <input class="mdl-textfield__input" type="text" id="search">
                  <label class="mdl-textfield__label" for="search">Enter
                     your query...</label>
                     
               </div>
            </div> -->
            
           <!--  돋보기버튼 
            <button
               class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon"
               id="hdrbtn">
               <i class="material-icons">more_vert</i>
            </button>
             -->
            <!-- 우특상단 땡땡이 -->
            <ul
               class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right"
               for="hdrbtn">
               <li class="mdl-menu__item">About</li>
               <li class="mdl-menu__item">Contact</li>
               <li class="mdl-menu__item">Legal information</li>
            </ul>
            
         </div>
      </header>
</body>
</html>