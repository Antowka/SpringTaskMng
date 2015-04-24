/**
 * Created by Anton Nikanorov on 4/23/15.
 */

angular.module('socketService', []).factory('socketService', ['$q', '$rootScope', function($q, $rootScope) {

    // We return this object to anything injecting our service
    var Service = {};
    // Keep all pending requests here until they get responses
    var callbacks = {};
    // Create our websocket object with the address to the websocket
    var ws = new WebSocket("ws://localhost:8080/websoc");

    ws.onopen = function(){
        console.log("Socket has been opened!");
    };

    ws.onmessage = function(message) {
        listener(JSON.parse(message.data));
    };

    function sendRequest(request, callback) {
        var defer = $q.defer();
        callbacks[request.id] = {
            time: new Date(),
            cb:defer
        };
        console.log('Sending request', request);
        ws.send(JSON.stringify(request));
        if(typeof callback == 'function') {
            defer.promise.then(function(data) {
                    callback(null, data);
                },
                function(error) {
                    callback(error, null);
                });
        }
        return defer.promise;
    }

    function listener(data) {
        var messageObj = data;
        console.log("Received data from websocket: ", messageObj);
        // If an object exists with callback_id in our callbacks object, resolve it
        if(callbacks.hasOwnProperty(messageObj.id)) {
            $rootScope.$apply(callbacks[messageObj.id].cb.resolve(messageObj));
            delete callbacks[messageObj.id];
        }
    }


    // ********** Service methods ***********
    Service.sendToWs = function(loginDate, callback) {
        return sendRequest(loginDate, callback);
    }

    return Service;
}]);