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
  
  
  
  
  
  
# WHAT MAKES THIS RESTFUL?

- Uniform standardized API independent of the server 
- Stateless interaction, at no point does the server ever preserve anything to do with the clients communication history it only intakes state data regarding either chatroom messages or new chatroom additions and writes this data to the database
- Layered System, the client has no information on the operating backend of the server and only recieves states(represented as ArrayLists) regarding the current chat messages and available rooms. This data can be updated to be stored anywhere server side, including another server, and I have included a dummy function if individuals wish to implement this functionality. 
- Standard Server/Client architecture and interface

