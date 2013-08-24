'use strict';

var NavbarController = function($scope, $dialog) {

    $scope.opts = {
        backdrop: true,
        keyboard: true,
        backdropClick: true,
        //templateUrl:  'dialogs/loginDialog',
        template:   '<div class="modal-header">'+
            '<button type="button" class="close"  ng-click="close(result)">X</button>'+
            '<h3 id="myModalLabel">Autenticação</h3>'+
            '</div>'+
            '<div class="modal-body">'+
            '<form class="form-horizontal">'+
            '<div class="control-group">'+
            '<label class="control-label" for="inputEmail">E-mail</label>'+
            '<div class="controls">'+
            '<input type="text" id="inputEmail" placeholder="usuario@dominio.com">'+
            '</div>'+
            '</div>'+
            '<div class="control-group">'+
            '<label class="control-label" for="inputPassword">Senha</label>'+
            '<div class="controls">'+
            '<input type="password" id="inputPassword" placeholder="****">'+
            '</div>'+
            '</div>'+
            '</form>'+
            '</div>'+
            '<div class="modal-footer">'+
            '<button class="btn btn-warning">Entrar</button>'+
            '</div>',
        controller: DialogController
    };

    $scope.openDialog = function(){
        var d = $dialog.dialog($scope.opts);
        d.open().then(function(result){
            if(result)
            {
                alert('dialog closed with result: ' + result);
            }
        });
    };

}