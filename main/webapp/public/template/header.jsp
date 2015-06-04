<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="masthead">
    <h3 class="muted">
        <spring:message code='header.message'/>
    </h3>

    <div class="navbar navbar-default">
        <div class="navbar-inner">
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav" ng-controller="LocationController">
                    <li ng-class="{'active': activeURL == 'home', '': activeURL != 'home'}" >
                        <a href="<c:url value="/"/>"
                           title='<spring:message code="header.home"/>'
                                >
                            <p><spring:message code="header.home"/></p>
                        </a>
                    </li>
                    <li ng-class="{'gray': activeURL == 'user', '': activeURL != 'user'}">
                        <a title='<spring:message code="header.user"/>'
                           href="<c:url value='/protected/user'/>">
                            <p><spring:message code="header.user"/></p>
                        </a>
                    </li>
                    <li ng-class="{'gray': activeURL == 'course', '': activeURL != 'course'}">
                        <a title='<spring:message code="header.course"/>'
                           href="<c:url value='/protected/course'/>">
                            <p><spring:message code="header.course"/></p>
                        </a>
                    </li>
                    <li ng-class="{'gray': activeURL == 'team', '': activeURL != 'team'}">
                        <a title='<spring:message code="header.team"/>'
                           href="<c:url value='/protected/team'/>">
                            <p><spring:message code="header.team"/></p>
                        </a>
                    </li>
                    <li ng-class="{'gray': activeURL == 'report', '': activeURL != 'report'}">
                        <a title='<spring:message code="header.report"/>'
                           href="<c:url value='/protected/report'/>">
                            <p><spring:message code="header.report"/></p>
                        </a>
                    </li>
                </ul>
                <ul class="nav pull-right">
                    <li><a href="<c:url value='/logout' />" title='<spring:message code="header.logout"/>'><p class="displayInLine"><spring:message code="header.logout"/>&nbsp;(${user.name})</p></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
