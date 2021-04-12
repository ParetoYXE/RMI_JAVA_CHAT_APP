# RMI_JAVA_CHAT_APP
Simple chat application implemented in Java utilizing RMI

# UPDATED TO FOLLOW REST ARCHITECTURE STYLE


## API CALLS FROM CLIENT SIDE

SERVANT NAME: SERVANT URL : SERVANT FUNCTIONS
- enterServer: rmi://localhost:5099/enterServer : echo(GET request to confirm you are connected to the server)

- listRooms: rmi://localhost:5099/listRooms : listRooms(GET request returning arraylist of all rooms)
