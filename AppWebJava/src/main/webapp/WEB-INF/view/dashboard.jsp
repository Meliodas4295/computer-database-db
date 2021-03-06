<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Computer Database</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/font-awesome.css" rel="stylesheet" media="screen">
<link href="css/main.css" rel="stylesheet" media="screen">
</head>
<body>
    <header class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <a class="navbar-brand" href="/AppWebJava/"> Application - Computer Database </a>
        </div>
    </header>

    <section id="main">
        <div class="container">
            <h1 id="homeTitle">
                <c:out value="${size}"></c:out> <spring:message code="lbl.computerfound"/>
            </h1>
            Language : <a href="?lang=en">English</a>|<a href="?lang=fr">French</a> current page:${pageContext.response.locale} 
            <div id="actions" class="form-horizontal">
                <div class="pull-left">
                    <form id="searchForm" action="#" method="GET" class="form-inline">

                        <input type="search" id="searchbox" name="search" class="form-control" placeholder="Search name" />
                        <input type="submit" id="searchsubmit" value="Filter by name"
                        class="btn btn-primary" />
                    </form>
                </div>
                <div class="pull-right">
                    <a class="btn btn-success" id="addComputer" href="addComputer"><spring:message code="lbl.add"/></a> 
                    <a class="btn btn-default" id="editComputer" href="#" onclick="$.fn.toggleEditMode();"><spring:message code="lbl.edit"/></a>
                </div>
            </div>
        </div>

        <form id="deleteForm" action="#" method="POST">
            <input type="hidden" name="selection" value="">
        </form>

        <div class="container" style="margin-top: 10px;">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <!-- Variable declarations for passing labels as parameters -->
                        <!-- Table header for Computer Name -->

                        <th class="editMode" style="width: 60px; height: 22px;">
                            <input type="checkbox" id="selectall" /> 
                            <span style="vertical-align: top;">
                                 -  <a href="#" id="deleteSelected" onclick="$.fn.deleteSelected();">
                                        <i class="fa fa-trash-o fa-lg"></i>
                                    </a>
                            </span>
                        </th>
                        <th>
                            <spring:message code="lbl.computername"/>
                        </th>
                        <th>
                            <spring:message code="lbl.introduceddate"/>
                        </th>
                        <!-- Table header for Discontinued Date -->
                        <th>
                            <spring:message code="lbl.discontinueddate"/>
                        </th>
                        <!-- Table header for Company -->
                        <th>
                            <spring:message code="lbl.company"/>
                        </th>

                    </tr>
                </thead>
                <!-- Browse attribute computers -->
                <tbody>
                	<c:forEach items="${list}" var="item" varStatus="status">
                      	<tr>
                      		<td class="editMode">
                            	<input type="checkbox" name="cb" class="cb" value="${item.id}">
                        	</td>
                        	<td>
                        	<form action="EditComputer" method="GET">
                        		<input type="hidden" name="computerId" value="${item.id}">
                        		<input type="submit" value="${item.name}" class="btn btn-primary">
                        	</form>
                        	</td>
                        	<td><c:out value= "${item.introduced}"/></td>
                        	<td><c:out value= "${item.discontinued}"/></td>
                        	<td><c:out value= "${item.companyId.id}"/></td>
                    	</tr>
      				</c:forEach>
                </tbody>
                
            </table>
        </div>
    </section>

    <footer class="navbar-fixed-bottom">
        <div class="container text-center">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                  </a>
              </li>
              <c:forEach var = "i" begin = "1" end = "${nbPages}">
         			<li><a href="${pageContext.request.contextPath}/dashboard?&page=${i}"><c:out value="${i}">${i}</c:out></a></li>
      			</c:forEach>
              <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>

        <div class="btn-group btn-group-sm pull-right" role="group" >
            <button type="button" class="btn btn-default">10</button>
            <button type="button" class="btn btn-default">50</button>
            <button type="button" class="btn btn-default">100</button>
        </div>

    </footer>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/dashboard.js"></script>

</body>
</html>
</html>
