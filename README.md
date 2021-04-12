# RMI_JAVA_CHAT_APP
Simple chat application implemented in Java utilizing RMI

# UPDATED TO FOLLOW REST ARCHITECTURE STYLE


## API CALLS FROM CLIENT SIDE

SERVANT NAME: SERVANT URL : SERVANT FUNCTIONS
- enterServer: rmi://localhost:5099/enterServer : echo(GET request to confirm you are connected to the server)

- listRooms: rmi://localhost:5099/listRooms : listRooms(GET request returning arraylist of all rooms)

- addNewRoom: rmi://localhost:5099/addRoom : echo (POST request with body string param of the new room name)

- loadRoom: rmi://localhost:5099/loadRoom: getRoom (GET request with body string param of the room you want, returns arrayList representation of the available rooms)

- updateChat: rmi://localhost:5099/updateChatlogs: updateChatLogs (POST request with two params, currentRoom and the users message which must also contain their username)



# EXAMPLE

LoadRoom service4 = (LoadRoom) Naming.lookup("rmi://localhost:5099/loadRoom");

ArrayList<String>chats = service4.getRoom(currentRoom);
