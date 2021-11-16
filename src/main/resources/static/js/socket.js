let stompClient = null;

function connect() {
    let socket = new SockJS('/gameplay');
    stompClient = Stomp.over(socket);

}