(function (window, document, undefined) {

        window.onload = init;

        //=============================================================================================================


        function init() {
           setInterval(() => {
                getAllMessages();
            }, 10000);//every 10 sec fetch list
            setInterval(() => {
                getConnectedUsers();
            }, 10000);//every 10 sec fetch ConnectedUsers

            getAllMessages();
            getConnectedUsers();

            document.getElementById("searchByMessage").addEventListener('click', searchByMessage);
            document.getElementById("searchByUser").addEventListener('click', searchUser);
            document.getElementById("form").addEventListener('submit', addMessage);

        }

        //=============================================================================================================
        //the function get all messages from server
        function getAllMessages() {

            console.log("getAllMessages")
            fetch('/repo/getAllMessages', {method: 'get', headers: {'Content-Type': 'application/json'}})
                .then(function (response) {
                    if (response.status !== 200) {
                        alert("Looks like there was a problem");
                        window.location.replace('/error/notLoggedIn');
                        return;
                    }
                    response.json().then(function (data) {
                        displayList(data)
                    });
                })
                .catch(function (err) {
                    alert("fetch err")
                });
        }
        //=============================================================================================================
        //the function add a new message to db
        function addMessage(event) {
            event.preventDefault();
            let message = document.getElementById("message_input").value
            document.getElementById("message_input").value = ""

            if (message.trim() === "" || message === null) {
                alert("please enter a valid string!");
                return;
            }
            fetch('/repo/newMessage', {method: 'POST', body: message, headers: {'Content-Type': 'application/json'}})
                .then(function (response) {
                    if (response.status !== 200) {
                        alert("Looks like there was a problem");
                        window.location.replace('/error/notLoggedIn');
                        return;
                    }
                    response.json().then(function (data) {
                        displayList(data)
                    });
                })
                .catch(function (err) {
                    alert("fetch err")
                });
        }

        //=============================================================================================================

        function searchUser()
        {
            let message = document.getElementById("searchInput").value
            document.getElementById("searchInput").value = ""

            if (message.trim() === "" || message === null) {
                alert("please enter a valid string!");
                return;
            }
            let url = '/repo/' + this.id
            fetch(url, {method: 'post', body: message, headers: {'Content-Type': 'application/json'}})
                .then(function (response) {
                    if (response.status !== 200) {
                        alert("Looks like there was a problem");
                        window.location.replace('/error/notLoggedIn');
                        return;
                    }
                    response.json().then(function (data) {
                        displayListByUser(data)
                    });
                })
                .catch(function (err) {
                    alert("fetch err")
                });

        }
        //=============================================================================================================
        //show the results of message's search that ordering by user
        function displayListByUser(data)
        {
            var target = document.getElementById("search_message_list");
            destroyChildNodes(target);
            if (data.length === 0)
                target.innerText += ("nothing to show!")

            for (let i = 0; i < data.length; i++)
            {
                let new_message_li = document.createElement("li");
                let new_message = document.createElement("ul");
                new_message_li.innerText = ( data[i][0].author).toString();
                new_message_li.append(new_message);
                for(let j=0;j< data[i].length;j++)
                {
                    let new_message_sub_li = document.createElement("li");
                    new_message_sub_li.innerText= (data[i][j].message).toString();
                    new_message.append(new_message_sub_li);
                }
                target.append(new_message_li);
            }
        }
        //=============================================================================================================
        //show list of messages
        function displayList(data) {
            var target = document.getElementById("wall");
            destroyChildNodes(target)
            var user_id=document.getElementById("id_user").innerText;
            for (let i = 0; i < data.length; i++) {
                let chatAvatar = document.createElement("div");
                let new_message = document.createElement("li");

                let chatName = document.createElement("div");
                chatName.innerText=(data[i].author).toString()
                chatName.className = "chat-name";
                chatAvatar.append(chatName)

                let text = document.createElement("div");
                text.className = "chat-text";
                text.innerText = ( data[i].message).toString();

                if(data[i].userId==user_id) {
                    new_message.className = "chat-right";
                    new_message.append(text);
                    new_message.append(chatAvatar);
                }
                else
                {
                    new_message.className = "chat-left";
                    new_message.append(chatAvatar);
                    new_message.append(text);
                }
                chatAvatar.className = "chat-avatar";

                target.append(new_message);
            }
        }
        //=============================================================================================================
        //show list of users
        function diplayUsersList(data) {
            var target = document.getElementById("connecting_list");
            destroyChildNodes(target);
            for (let i = 0; i < data.length; i++) {
                let new_message = document.createElement("li");
                new_message.className="person"
                let user = document.createElement("div");
                user.className ="user"
                let status=document.createElement("span");

                if(data[i].aliveState)
                    status.className="status online"
                else
                    status.className="status busy"

                user.append(status)
                let name = document.createElement("li");
                name.className="name-time"
                let spanName=document.createElement("span");
                spanName.className="name"
                spanName.innerText= (data[i].firstName + " " + data[i].lastName).toString();
                new_message.append(user)
                new_message.append(spanName)

                target.append(new_message)
            }

        }
        //=============================================================================================================

        function getConnectedUsers() {
            fetch('/repo/getConnectedUsers', {
                method: 'get',
                headers: {'Content-Type': 'application/json'}
            })
                .then(function (response) {
                    if (response.status !== 200) {
                        alert("Looks like there was a problem");
                        window.location.replace('/error/notLoggedIn');
                        return;
                    }
                    response.json().then(function (data) {
                        diplayUsersList(data)

                    });
                })
                .catch(function (err) {
                    alert("fetch err")
                });
        }

        //=============================================================================================================
        function searchByMessage() {
            let message = document.getElementById("searchInput").value
            document.getElementById("searchInput").value = ""

            if (message.trim() === "" || message === null) {
                alert("please enter a valid string!");
                return;
            }
            let url = '/repo/' + this.id
            fetch(url, {method: 'post', body: message, headers: {'Content-Type': 'application/json'}})
                .then(function (response) {
                    if (response.status !== 200) {
                        alert("Looks like there was a problem");
                        window.location.replace('/error/notLoggedIn');
                        return;
                    }
                    response.json().then(function (data) {
                        displayListByMessage(data)
                    });
                })
                .catch(function (err) {
                    alert("fetch err")
                });
        }

        //=============================================================================================================
        function destroyChildNodes(div) {
            while (div.hasChildNodes()) {
                div.removeChild(div.firstChild);
            }
        }

        //=============================================================================================================
        function displayListByMessage(data) {

            var target = document.getElementById("search_message_list");
            destroyChildNodes(target);
            if (data.length === 0)
                target.innerText += ("nothing to show!")
            for (let i = 0; i < data.length; i++) {
                let new_message = document.createElement("li");
                new_message.innerText = (i + 1 + ": " + data[i].author + " " + data[i].message).toString();
                target.append(new_message);
            }
        }

        //=============================================================================================================



    }

)(window, document, undefined);