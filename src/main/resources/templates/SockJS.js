<script src="/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/stomp.min.js"></script>


<script>
    var stompClient = null;

    function connect() {
        var socket = new SockJS('/chat');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/public', function (chatMessage) {
                showMessage(JSON.parse(chatMessage.body));
            });
        });
    }

    function sendMessage() {
        var message = {
            sender: document.getElementById('sender').value,
            content: document.getElementById('content').value,
            type: 'CHAT'
        };

        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(message));
    }

    function showMessage(message) {

        console.log(message);
    }
</script>