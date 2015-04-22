/**
 * Created by Anton Nikanorov on 4/22/15.
 */

wsConnection = {
    "ws": null,
    "wsurl": "ws://" + document.domain + ":8080/websoc",
    "isError": false,

    "create": function () {

        var classEnv = this;

        this.ws = new WebSocket(this.wsurl);

        this.ws.onopen = function () {
            console.log("WebSocket opened");
            classEnv.sendrpc({'topic':'showResult'});
        }

        this.ws.onmessage = function (e) {

            console.log(e);

            this.ws.onclose = function () {
                console.log("WebSocket closed");
            }

            this.ws.onerror = function (e) {
                console.log("Client got an error!" + e);
            }

        }
    },
    "sendrpc": function (message) {

        if (this.ws == null) {
            console.log('WebSocket isn`t initialized');
            this.create(function () {
            });
        }

        if (this.ws.readyState == 3) {
            console.log('WebSocket is already in CLOSING or CLOSED state.');
            return false;
        }

        var strJSON = JSON.stringify(message, null, ' ');

        try {
            console.log(strJSON);
            this.ws.send(strJSON);
        } catch (e) {
            console.log(e);
        }
    },
}
