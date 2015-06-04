<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div ng-controller="teamController">
    <table class="table table-bordered">
        <thead>
        <th>Name</th>
        <th></th>
        <th></th>
        </thead>

        <!-- Add a row for each team present in the model layer -->
        <tbody ng-repeat="team in teams" ng-switch on="team.state">

        <security:authorize ifAnyGranted="ROLE_ADMIN">
            <!-- Edit Mode Template -->
            <tr ng-switch-when="edit">
                <input type="hidden" ng-model="team.id" />
                <td>
                    <input type="text" class="form-control" ng-model="team.name" />
                </td>
                <td>
                    <input type="button" class="btn btn-success" ng-click="saveTeam(team);" value="Save" />
                </td>
                <td>
                    <input type="button" class="btn btn-danger" ng-click="cancelEdit(team);" value="Cancel" />
                </td>
            </tr>

            <!-- Deleted Mode Template -->
            <tr class="danger" ng-switch-when="deleted">
                <input type="hidden" ng-model="team.id" />
                <td>{{team.name}}</td>
                <td>
                    <input type="button" class="btn btn-danger" ng-click="deleteTeam(team);" value="Delete Permanently" />
                </td>
                <td>
                    <input type="button" class="btn btn-success" ng-click="undoDelete(team)" value="Undo"/>
                </td>
            </tr>
        </security:authorize>
        <!-- Normal Mode Template -->
        <tr ng-switch-default>
            <input type="hidden" value="{{team.id}}" />
            <td><a href="">{{team.name}}</a></td>
            <security:authorize ifAnyGranted="ROLE_ADMIN">
                <td>
                    <input type="button" class="btn btn-primary" ng-click="editTeam(team);" value="Edit" />
                </td>
                <td>
                    <input type="button" class="btn btn-danger" ng-click="deleteTeam(team);" value="Delete"/>
                </td>
            </security:authorize>
        </tr>
        </tbody>

        <security:authorize ifAnyGranted="ROLE_ADMIN">
            <!-- New Team Form -->
            <tbody>
            <tr>
                <input type="hidden" ng-model="newTeam.id" />
                <td>
                    <input type="text" class="form-control" ng-model="newTeam.name" required/>
                </td>
                <td>
                    <input type="button" class="btn btn-primary" ng-click="addTeam();" value="Add"/>
                </td>
            </tr>
            </tbody>
        </security:authorize>
    </table>


</div>

<%--<link href="<c:url value='/resources/css/sample.css' />" rel="stylesheet"/>--%>
<script src="<c:url value="/resources/js/controller/teamController.js" />"></script>