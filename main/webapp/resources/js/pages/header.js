function LocationController($scope, $location) {
    if($location.$$absUrl.lastIndexOf('/user') > 0){
        $scope.activeURL = 'user';
    } else if($location.$$absUrl.lastIndexOf('/course') > 0){
        $scope.activeURL = 'course';
    } else if($location.$$absUrl.lastIndexOf('/team') > 0){
        $scope.activeURL = 'team';
    } else if($location.$$absUrl.lastIndexOf('/report') > 0){
        $scope.activeURL = 'report';
    } else {
        $scope.activeURL = 'home';
    }
}