# chat room  JAVA spring server

The site supports multiple users,
Each user will be saved in the database along with his messages.


Search tab -You can search for messages by
  1. The message itself or part of it.
  2. First name.
  3. First name + last name.
The result will be a list of messages that matches the query


At each login the program will check if there is already a user with this name,
If it is connected - an error message will be issued
If not then the same user will be added to the database and log in with that name

The chat page will show all the registered users of the website Connected or not and also the list of messages
These lists will be provided every 10 seconds by ajax calls

A logged in user will be displayed with a green dot
An offline user will be displayed with a red dot



