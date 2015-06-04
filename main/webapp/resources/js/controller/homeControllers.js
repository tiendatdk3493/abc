/**
 * Created by thuynghi on 4/27/2015.
 */
function homeController($scope, $http) {

    $scope.tabs = [{
        title: 'One',
        url: 'one.tpl.html'
    }, {
        title: 'Two',
        url: 'two.tpl.html'
    }, {
        title: 'Three',
        url: 'three.tpl.html'
    }];

    $scope.currentTab = 'one.tpl.html';

    $scope.onClickTab = function (tab) {
        $scope.currentTab = tab.url;
    }

    $scope.isActiveTab = function(tabUrl) {
        return tabUrl == $scope.currentTab;
    }

    //-----------------------------------------------------------
    $scope.editMode = false;
    $scope.position = '';

    $scope.viewAllUserProfile = function(){
        $http.get('userProfileList').success(function(response){
            $scope.userProfiles = response;
        })
    }

    $scope.viewUserProfile = function () {
        $http.get('userProfile').success(function(response){
            $scope.userProfile = response;
        })
    }

    $scope.resetUserProfile = function(){
        $scope.viewUserProfile();
        $scope.ab = "";
        $scope.editMode = false;
    }

    $scope.addUserProfile = function(ab) {
        $http.post('addUserProfile', ab).success(function(response){
            $scope.viewUserProfile();
            $scope.ab="";
        }).error(function(response){
            console.log(response);
        })
    }

    $scope.updateUserProfile = function(ab) {
        $http.post('updateUserProfile', ab).success(function(response){
            $scope.viewUserProfile();
            $scope.ab = "";

            $scope.editMode = false;
        }).error(function(response){
            console.log(response);
        })
    }

    $scope.deleteUserProfile = function(id) {
        $http.delete('address/delete/' + id).success(function(response){
            $scope.viewUserProfile();
        }).error(function(response){
            console.log(response);
        })
    }

    $scope.deleteAllUserProfile = function(){
        $http.delete('address/delete/all').success(function(response){
//            $scope.viewAllAddressBook();
        })
    }

    $scope.editUserProfile = function(userProfile){
        $scope.ab = userProfile;
        $scope.editMode = true;
    }

    $scope.viewUserProfile();


}

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#uploadimg')
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };

        reader.readAsDataURL(input.files[0]);
    }
}
