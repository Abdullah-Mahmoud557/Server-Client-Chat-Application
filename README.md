# TCP Server-Client-Chat-Application
Overview
This project is a basic chat application using TCP, built in Java. It enables clients to connect to a central server and exchange messages in real-time. The server supports multiple clients simultaneously by managing each connection in a separate thread. Messages sent by any client are received and distributed by the server to all connected clients.

Technologies Used
Java: The programming language for both the server and client implementations.
TCP/IP: The communication protocol that ensures reliable data transfer between the client and server.
Sockets: Java’s Socket and ServerSocket classes handle network communication and connection management.
