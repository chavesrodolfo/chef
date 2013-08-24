function DialogController($scope, dialog){
    $scope.close = function(result){
        dialog.close(result);
    };
}