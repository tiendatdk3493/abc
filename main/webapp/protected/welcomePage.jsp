<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div ng-controller="userController">
    <div ng-repeat="n in users">
        {{n}}
    </div>
</div>

<script src="<c:url value="/resources/js/pages/user.js" />"></script>