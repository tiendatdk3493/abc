<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<div ng-controller="userController">--%>
<%--<div ng-repeat="n in users">--%>
<%--{{n}}--%>
<%--</div>--%>
<%--</div>--%>

<div class="container" ng-controller="homeController">
    <div class="demo-row">

        <%--<div class="alert alert-info" style="width:400px;margin-left:100px;" ng-show="userProfile == ''">--%>
            <%--No user profile entry found--%>
        <%--</div>--%>

        <div ng-show="userProfile != '' && !editMode">
            <table class="table table-bordered table-striped" >
                <tr>
                    <th>Badge Id</th>
                    <th>{{userProfile.badgeId}}</th>
                </tr>
                <tr>
                    <th>Badge Id Of Mentor</th>
                    <th>{{userProfile.badgeIdMentor}}</th>
                </tr>
                <tr>
                    <th>School</th>
                    <th>{{userProfile.school}}</th>
                </tr>
                <tr>
                    <th>Degree</th>
                    <th>{{userProfile.degree}}</th>
                </tr>
                <tr>
                    <th>Graduate Date</th>
                    <th>{{userProfile.graduateDate}}</th>
                </tr>
                <tr>
                    <th>Final Study Result</th>
                    <th>{{userProfile.finalStudyResult}}</th>
                </tr>
                <tr>
                    <th>Toeic</th>
                    <th>{{userProfile.toeic}}</th>
                </tr>
                <tr>
                    <th>Join Date</th>
                    <th>{{userProfile.joinDate}}</th>
                </tr>
                <tr>
                    <th>Work Role</th>
                    <th>{{userProfile.workRole}}</th>
                </tr>
                <tr>
                    <th>Experience Years</th>
                    <th>{{userProfile.experienceYears}}</th>
                </tr>
                <tr>
                    <th>Experience Years In Current Role</th>
                    <th>{{userProfile.experienceYearsInCurrentRole}}</th>
                </tr>
                <tr>
                    <th>Professional Certification</th>
                    <th>{{userProfile.professionalCertification}}</th>
                </tr>
                <tr>
                    <th>Oversea Working Experience</th>
                    <th>{{userProfile.overseaWorkingExperience}}</th>
                </tr>
                <tr>
                    <th>Police Clearance Status</th>
                    <th>{{userProfile.policeClearanceStatus}}</th>
                </tr>
                <tr>
                    <th>CV</th>
                    <th>{{userProfile.cvUrl}}</th>
                </tr>
                <tr>
                    <th>Image User</th>
                    <th>{{userProfile.imageUser}}</th>
                </tr>
                <tr>
                    <th>Place</th>
                    <th>{{userProfile.place}}</th>
                </tr>
                <tr>
                    <th>Gender</th>
                    <th>{{userProfile.gender}}</th>
                </tr>
                <tr>
                    <th>Need Tracking</th>
                    <th>{{userProfile.needTracking}}</th>
                </tr>
                <tr>
                    <th>Skype Id</th>
                    <th>{{userProfile.skypeId}}</th>
                </tr>
                <tr>
                    <th>Ip Address</th>
                    <th>{{userProfile.ipAddress}}</th>
                </tr>
                <tr>
                    <th>General Status</th>
                    <th>{{userProfile.generalStatus}}</th>
                </tr>
            </table>

            <button class="btn btn-mini btn-danger" ng-click="editUserProfile(userProfile)">Update</button>
        </div>
        <hr>
        <div class="demo-content" ng-show="editMode || userProfile == ''">
            <div class="row">
                <form name="myForm" novalidate>
                    <div class="col-lg-9">
                        <h2 style="margin-bottom: 30px"><p align="center"> Personal Information </p></h2>
                        <input type="hidden" ng-model="ab.id" />

                        <table class="table table-bordered table-striped">

                            <tr class="form-group">
                                <td>User Name</td>
                                <td><input placeholder="Enter Username" type="text" ng-model="" required min="1" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input placeholder="Enter Password" type="password" ng-model="r" required min="1" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>confirm Password</td>
                                <td><input placeholder="Enter Confirms Password" type="password" ng-model="" required min="1" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Source</td>
                                <td><input placeholder="Enter Source" type="text" ng-model="" required min="1" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>TMA Employee ID</td>
                                <td><input placeholder="Enter Employee ID" type="text" ng-model=""  required min="1" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Email</td>
                                <td><input placeholder="Enter Email Address" type="text" ng-model=""  required min="0" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>First Name</td>
                                <td><input placeholder="Enter First Name" type="text" ng-model=""  required min="1" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Last Name</td>
                                <td><input placeholder="Enter Last Name" type="text" ng-model="" required min="1" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Middle Name</td>
                                <td><input placeholder="Enter Middle Name" type="text" ng-model="" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Your Home Town</td>
                                <td><input placeholder="Enter Your Home Town" type="text"  ng-model="" required min="0" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Skype ID</td>
                                <td><input placeholder="Enter Skype ID" type="text" ng-model=""  required min="0" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Gender</td>
                                <td>
                                    <input name="sex" type="radio" ng-model="ab.gender" value="true"> Male &nbsp; &nbsp; &nbsp;
                                    <input name="sex" type="radio" ng-model="ab.gender" value="false"> Female
                                </td>
                            <tr>
                                <td>Role</td>
                                <td><input type="text" ng-model="" value="" disabled class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>University/College</td>
                                <td><input placeholder="University/College" type="text" ng-model="ab.school"  class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Degree</td>
                                <td><input placeholder="Enter Degree" type="text" ng-model="" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Graduate Date</td>
                                <td><input placeholder="Enter Graduate Date" type="date" ng-model="" class="form-control"/></td>

                            </tr>
                            <tr>
                                <td>GPA</td>
                                <td><input  type="checkbox" ng-model="" value="false" /></td>

                            </tr>
                            <tr>
                                <td>TOEIC</td>
                                <td><input type="checkbox" ng-model="ab.toeic" value="false" /></td>
                            </tr>
                            <tr>
                                <td>Year of Professional Experience</td>
                                <td><input placeholder="Enter Year of Professional Experience" type="text" ng-model="ab.experienceYearsInCurrentRole" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Current Role Experience</td>
                                <td><input placeholder="Enter Current Role Experience" type="text" ng-model="" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Professional Certificate</td>
                                <td><input placeholder="Enter Professional Certificate" ng-model="ab.professionalCertification" type="text" class="form-control"/></td>
                            </tr>
                            <tr>
                                <td>Oversea Working Experience</td>
                                <td><input placeholder="Enter Oversea Working Experience" type="checkbox" ng-model="ab.overseaWorkingExperience" value="false" /></td>
                            </tr>
                            <tr>
                                <td>Join TMA Date</td>
                                <td><input type="date" ng-model="" value="false" class="form-control"/></td>

                            </tr>
                            <tr>
                                <td>Police Clearance Status</td>
                                <td><input class="form-control" placeholder="Enter Police Clearance Status" type="text" ng-model="ab.policeClearanceStatus" value="" required /></td>
                            </tr>
                            <tr>
                                <td>Skill</td>
                              <td><textarea placeholder="Enter Skill" class="form-control"></textarea></td>
                            </tr>
                            <tr>
                                <td>Join Pool Date</td>
                                <td><input placeholder="Enter Join Pool Date" type="date" ng-model="ab.joinDate" value="" required min="1" class="form-control"/></td>
                            </tr>
                        </table>
                        <button type="btn btn-primary" class="btn btn-primary" ng-disabled="!myForm.$valid" ng-show="editMode" ng-click="updateUserProfile(ab)">Update</button>
                        <button type="btn btn-primary" class="btn btn-primary" ng-disabled="!myForm.$valid" ng-show="!editMode"ng-click="addUserProfile(ab)">Add User Profile</button>
                        <button type="btn btn-primary" class="btn btn-primary" ng-click="resetUserProfile()" ng-show="editMode">Back</button>
                    </div>
                    <div class="col-lg-3">
                        <div style="float:right ;margin-left:20px;width:200px;height:230px">
                            <img id="uploadimg" src="#" style="width:200px;height:200px" >
                            <input type="file" data-badge="false" onchange="readURL(this);">
                        </div>
                    </div>

                </form>
            </div>
            <hr />
        </div> <!-- /.demo-content -->
    </div> <!-- /.demo-row -->
</div><!-- /.container -->

<%--<div id="tabs" ng-controller="homeController">
    <ul>
        <li class="tabs" ng-repeat="tab in tabs"
            ng-class="{active:isActiveTab(tab.url)}"
            ng-click="onClickTab(tab)">{{tab.title}}
        </li>
    </ul>
    <div id="mainView">
        <div ng-include="currentTab"></div>
    </div>
</div>
<script type="text/ng-template" id="one.tpl.html">
    <div id="viewOne">
        <h1>View One</h1>

        <p>Praesent id metus massa, ut blandit odio. Proin quis tortor orci. Etiam at risus et justo dignissim congue.
            Donec congue lacinia dui, a porttitor lectus condimentum laoreet. Nunc.</p>
    </div>
</script>

<script type="text/ng-template" id="two.tpl.html">
    <div id="viewTwo">
        <h1>View Two</h1>

        <p>Curabitur vulputate, ligula lacinia scelerisque tempor, lacus lacus ornare ante, ac egestas est urna sit amet
            arcu. Class aptent taciti sociosqu.</p>
    </div>
</script>

<script type="text/ng-template" id="three.tpl.html">
    <div id="viewThree">
        <h1>View Three</h1>

        <p>In pellentesque faucibus vestibulum. Nulla at nulla justo, eget luctus tortor. Nulla facilisi. Duis aliquet
            egestas purus in blandit. Curabitur vulputate, ligula lacinia scelerisque tempor, lacus lacus ornare ante,
            ac egestas est urna sit amet arcu. Class aptent taciti sociosqu.</p>
    </div>
</script>--%>

<link href="<c:url value='/resources/css/tabs.css'/>" rel="stylesheet"/>
<script src="<c:url value="/resources/js/controller/homeControllers.js" />"></script>