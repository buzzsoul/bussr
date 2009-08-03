<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes"	uri="http://stripes.sourceforge.net/stripes.tld"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bussr</title>
<style type="text/css">
body{
-x-system-font:none;
color:#778899;
font-family:Arial,Sans-serif;
font-size:62.5%;
font-size-adjust:none;
font-stretch:normal;
font-style:normal;
font-variant:normal;
font-weight:normal;
line-height:16px;
margin:0;
padding:0;
}
#container {
margin:0 auto;
width:780px;
}
#topnav {
font-size:1.2em;
line-height:23px;
padding:10px 25px 12px;
text-align:right;
}
#header {
-moz-border-radius-topleft:10px;
-moz-border-radius-topright:10px;
background:#ff6600 url(http://www.grosshat.com/imgs/bg-search-box.png) no-repeat 96% 55%;
position:relative;
}
#header2 {
background-color:transparent;
padding:30px 25px;
}
#slogan {
-x-system-font:none;
color:#fff;
float:right;
font-size:1.8em;
font-size-adjust:none;
font-stretch:normal;
font-style:normal;
font-variant:normal;
font-weight:normal;
line-height:24px;
margin:0 149px 0 0;
}
.logo {
font-size:4em;
font-weight:700;
text-decoration:none;
color:#6f0909;
margin:0;
}
#home-search {
margin:25px 0 0;

}
#home-search label {
color:#fff;
display:block;
margin:0 0 6px 2px;
}
#home-search-q {
-moz-border-radius-bottomleft:5px;
-moz-border-radius-topleft:5px;
-x-system-font:none;
background:#FFFFFF none repeat scroll 0 0;
border-color:#EEEEEE;
border-style:solid;
border-width:1px 0 1px 1px;
font-family:Helvetica,Arial,Sans-serif;
font-size:1.6em;
font-size-adjust:none;
font-stretch:normal;
font-style:normal;
font-variant:normal;
font-weight:normal;
line-height:normal;
margin:0;
outline-width:0;
padding:8px 10px;
width:480px;
}
#home-search-submit {
-moz-border-radius-bottomright:5px;
-moz-border-radius-topright:5px;
-x-system-font:none;
background:#BBBBBB url(http://www.grosshat.com/imgs/bg-search.png) repeat-x scroll 0 0;
border:1px solid #EEEEEE;
color:#333333;
font-family:Helvetica,Arial,Sans-serif;
font-size:1.6em;
font-size-adjust:none;
font-stretch:normal;
font-style:normal;
font-variant:normal;
font-weight:bold;
line-height:normal;
margin-left:-0.5em;
outline-color:-moz-use-text-color;
outline-style:none;
outline-width:medium;
padding:7px 15px;
text-decoration:none;
text-shadow:0 1px 0 #FFFFFF;
}
#trends-tags {
-moz-border-radius-bottomleft:10px;
-moz-border-radius-bottomright:10px;
background:#cc0f0e;
overflow:hidden;
padding:20px 25px;
position:relative;
color:#fff;
}
</style>
</head>
<body>
<div id="container">
  <div id="topnav">
    <p>bussr account</p>
  </div>

  <div id="header">                                                                                                      
       <div id="header2">                                                                                                    
         <h1 id="slogan">Discover what's telling about you on the net</h1>                                            
         <a class="logo" href="/bussr/">bussr</a>                                                                                      
         <stripes:form id="home-search" beanclass="org.dataport.bussr.action.SearchActionBean">      
           <div>                                                                                                                          
             <stripes:text id="home-search-q" tabindex="1" size="40" name="query" />                                                    
             <stripes:submit id="home-search-submit" value="search" tabindex="2" name="search" />                                                      
           </div>                                                                                                                                      
         </stripes:form>                                                                                                                               
       </div>                                                                                                                                          
  </div>

   <h1>Search Results</h1> 
    <c:choose>
        <c:when test="${not empty actionBean.results}">
            <ul>
            <c:forEach items="${actionBean.results}" var="current">
                <li>
                    <h3>${current.title}</h3>
                    <c:choose>
                        <c:when test="${current.provider == 'GOOGLE'}">
                            <img src="http://www.google.es/intl/en_com/images/logo_plain.png" alt="google.com"/>
                        </c:when>
                        <c:when test="${current.provider == 'ONCEOCHOSETENTA'}">
                            <img src="http://11870.com/static/imgs/11870.png" alt="11870.com"/>
                        </c:when>
                        <c:when test="${current.provider == 'TWITTER'}">
                            <img src="http://assets1.twitter.com/images/logo.png" alt="twitter"/>
                        </c:when>
                    </c:choose>
                    <span><a href="${current.link}">Quiero ver que se dice...</a></span>
                    <br/>
                </li>
            </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <span>No hay resultados</span>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
