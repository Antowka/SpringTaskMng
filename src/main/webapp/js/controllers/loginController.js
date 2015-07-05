/**
 * Created by Anton Nikanorov on 4/23/15.
 */

angular.module('loginController', []).controller('loginController', function($scope, socketService) {

    $scope.alerts = [];

    $scope.login = function(){

        var login    = $scope.signin.login;
        var password = $scope.signin.password;

        var rpcLogin = {
            "id": Math.round(Math.random() * 10e12),
            "type": "user",
            "action": "get",
            "params": {
                "login": login,
                "password": password,
                "deviceID": "3A7A481-AFC9-5A20-ABF5-CD7C46D58444",
                "devicePlatform": 1,
                "deviceToken": "75185822453637391d12fd5b04cb55555bdbab1cc5cc90fbbebb41f8cda0dc63",
                "deviceLocale": "en",
                "api": "0.0.1"
            }
        };

        socketService.sendToWs(rpcLogin, function(error, msg){
           if(error == null) {
               console.log(msg);
           }
        });
    }

});