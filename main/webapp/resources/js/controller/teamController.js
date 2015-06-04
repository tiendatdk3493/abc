/**
 * Created by ntnngoc on 5/5/2015.
 */

controllers.controller('teamController',['$scope', '$http', function($scope, $http){
    $scope.teams = [];
    $scope.newTeam = {};

    load();

    function load(){
        $http.get('teamList').success(function(teamList){
            $scope.teams = teamList;
        });
    };

    $scope.addTeam = function(){
        $scope.newTeam.id = 0;
        $http.post("addTeam", $scope.newTeam)
            .success(function (data) {
                load();
            });
        $scope.newTeam = {};
    };

    $scope.deleteTeam = function(team) {
        if (team.state == "deleted") {
            $http.delete ('deleteTeam/' + team.id)
                .success(function (response) {
                    load();
                })
        } else {
            team.state = "deleted";
        }
    };

    $scope.undoDelete = function (team) {
        team.state = "normal";
    };

    $scope.editTeam = function (team) {
        team.state = "edit";
    };

    $scope.saveTeam = function (team) {
        $http.post("addTeam", team)
            .success(function (response) {
                load();
            });
        team.state = "normal"
    };

    $scope.cancelEdit = function (team) {
        load();
        team.state = "normal";
    };
}]);