<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="stripes"	uri="http://stripes.sourceforge.net/stripes.tld"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bussr</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bussr.css" type="text/css" media="screen" />
</head>
<body>
<div id="container">
  <div id="topnav">
    <p>bussr account</p>
  </div>

  <div id="header">                                                                                                      
       <div id="header2">                                                                                                    
         <h1 id="slogan">Discover what's telling about you on the net</h1>                                            
         <a class="logo" href="/">bussr</a>                                                                                      
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
