/**
 * Created by ntnngoc on 5/5/2015.
 */

controllers.controller('courseController',['$scope', '$http', function($scope, $http){
    $scope.courses = [];
    $scope.newCourse = {};

    load();

    function load(){
        $http.get('courseList').success(function(courseList){
           $scope.courses = courseList;
        });
    };

    $scope.addCourse = function(){
        $scope.newCourse.id = 0;
        $http.post("addCourse", $scope.newCourse)
            .success(function (data) {
                load();
            });
        $scope.newCourse = {};
    };

    $scope.deleteCourse = function(course) {
        if (course.state == "deleted") {
            $http.delete ('deleteCourse/' + course.id)
                .success(function (response) {
                    load();
                })
        } else {
            course.state = "deleted";
        }
    };
    
    $scope.undoDelete = function (course) {
        course.state = "normal";
    };

    $scope.editCourse = function (course) {
        course.state = "edit";
    };

    $scope.saveCourse = function (course) {
        $http.post("addCourse", course)
            .success(function (response) {
                load();
            });
        course.state = "normal"
    };

    $scope.cancelEdit = function (course) {
        load();
        course.state = "normal";
    };
}]);