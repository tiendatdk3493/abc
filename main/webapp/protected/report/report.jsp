<%--
  Created by IntelliJ IDEA.
  User: thuynghi
  Date: 5/4/2015
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid" ng-controller="reportController">
    <h2 class="sub-header">Summary</h2>

    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Total number</th>
                <th>Male</th>
                <th>Female</th>
                <th>Female/Male (%)</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{{information.size}}</td>
                <td>{{information.male}}</td>
                <td>{{information.female}}</td>
                <td>{{((information.female/information.male)*100)/information.size}}%</td>
            </tr>
            </tbody>
        </table>
    </div>
    <!-- pie chart canvas element : Gender -->
    <div>
        <center><canvas id="gender" width="600" height="200"></canvas></center>
        <center>Gender chart</center>
    </div>

    <!-- Experience-------------------------------------------->
    <h2 class="sub-header">Experience</h2>

    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th><0.5</th>
                <th>0.5-1 year</th>
                <th>1-2 years</th>
                <th>2-3 years</th>
                <th>3-5 years</th>
                <th>5+ years</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{{information.yearExperiences_0}}</td>
                <td>{{information.yearExperiences_1}}</td>
                <td>{{information.yearExperiences_2}}</td>
                <td>{{information.yearExperiences_3}}</td>
                <td>{{information.yearExperiences_4}}</td>
                <td>{{information.yearExperiences_5}}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <!-- pie chart canvas element : experience -->
    <div>
        <center><canvas id="experience" width="600" height="200"></canvas></center>
        <center>Experience chart</center>
    </div>

    <!-- Experience-------------------------------------------->
    <h2 class="sub-header">Readiness</h2>

    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th><1 Week</th>
                <th>1 - 2 weeks </th>
                <th>2 weeks - 1 months</th>
                <th>1 - 3 months</th>
                <th>3 - 6 months</th>
                <th>Unknown</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{{information.readiness_0}}</td>
                <td>{{information.readiness_1}}</td>
                <td>{{information.readiness_2}}</td>
                <td>{{information.readiness_3}}</td>
                <td>{{information.readiness_4}}</td>
                <td>{{information.readiness_5}}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <!-- pie chart canvas element : readiness -->
    <div>
        <center><canvas id="readiness" width="600" height="200"></canvas></center>
        <center>Readiness chart</center>
    </div>



    <!-- Month report-------------------------------------------->
    <h2 class="sub-header">Months Chart</h2>
    <div class="col-xs-6">
        <div>
        Month:
        <select class="form-control nomargin" ng-model="date.choiceMonth1" ng-options="opt for opt in options.months"></select>
        Year:
        <select class="form-control nomargin" ng-model="date.choiceYear1" ng-options="opt for opt in options.years"></select>
        </div>

        <div>--------</div>

        <div>
        Month:
        <select class="form-control nomargin" ng-model="date.choiceMonth2" ng-options="opt for opt in options.months"></select>
        Year:
        <select class="form-control nomargin" ng-model="date.choiceYear2" ng-options="opt for opt in options.years"></select>
        <button type="btn btn-primary" class="btn btn-primary" ng-click="viewInformationByMonth()">View</button>
        </div>
    </div>
    <div id="chartdiv">

    </div>

</div>


<link href="<c:url value='/resources/css/sample.css'  />" rel="stylesheet"/>
<script src="<c:url value="/resources/js/controller/reportController.js" />"></script>
<script src="<c:url value="/resources/chart/Chart.js" />"></script>
<script src="<c:url value="/resources/chart/Chart.min.js" />"></script>
<script src="<c:url value="/resources/chart/amcharts.js" />"></script>
<script src="<c:url value="/resources/chart/light.js" />"></script>
<script src="<c:url value="/resources/chart/serial.js" />"></script>
