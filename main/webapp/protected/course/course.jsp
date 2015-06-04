<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div ng-controller="courseController">
    <table class="table table-bordered">
        <thead>
        <th>Name</th>
        <th></th>
        <th></th>
        </thead>

        <!-- Add a row for each course present in the model layer -->
        <tbody ng-repeat="course in courses" ng-switch on="course.state">

        <security:authorize ifAnyGranted="ROLE_ADMIN">
            <!-- Edit Mode Template -->
            <tr ng-switch-when="edit">
                <input type="hidden" ng-model="course.id" />
                <td>
                    <input type="text" class="form-control" ng-model="course.name" />
                </td>
                <td>
                    <input type="button" class="btn btn-success" ng-click="saveCourse(course);" value="Save" />
                </td>
                <td>
                    <input type="button" class="btn btn-danger" ng-click="cancelEdit(course);" value="Cancel" />
                </td>
            </tr>

            <!-- Deleted Mode Template -->
            <tr class="danger" ng-switch-when="deleted">
                <input type="hidden" ng-model="course.id" />
                <td>{{course.name}}</td>
                <td>
                    <input type="button" class="btn btn-danger" ng-click="deleteCourse(course);" value="Delete Permanently" />
                </td>
                <td>
                    <input type="button" class="btn btn-success" ng-click="undoDelete(course)" value="Undo"/>
                </td>
            </tr>
        </security:authorize>
        <!-- Normal Mode Template -->
        <tr ng-switch-default>
            <input type="hidden" value="{{course.id}}" />
            <td><a href="">{{course.name}}</a></td>
            <security:authorize ifAnyGranted="ROLE_ADMIN">
                <td>
                    <input type="button" class="btn btn-primary" ng-click="editCourse(course);" value="Edit" />
                </td>
                <td>
                    <input type="button" class="btn btn-danger" ng-click="deleteCourse(course);" value="Delete"/>
                </td>
            </security:authorize>
        </tr>
        </tbody>

        <security:authorize ifAnyGranted="ROLE_ADMIN">
            <!-- New Course Form -->
            <tbody>
            <tr>
                <input type="hidden" ng-model="newCourse.id" />
                <td>
                    <input type="text" class="form-control" ng-model="newCourse.name" required/>
                </td>
                <td>
                    <input type="button" class="btn btn-primary" ng-click="addCourse();" value="Add"/>
                </td>
            </tr>
            </tbody>
        </security:authorize>
    </table>


</div>

<%--<link href="<c:url value='/resources/css/sample.css' />" rel="stylesheet"/>--%>
<script src="<c:url value="/resources/js/controller/courseControllers.js" />"></script>