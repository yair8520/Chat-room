(function (window, document, undefined) {

        window.onload = init;

        //=============================================================================================================


        function init() {
           /* setInterval(() => {
                getAllMessages();
            }, 10000);//every 10 sec fetch list
            setInterval(() => {
                getConnectedUsers();
            }, 10000);//every 10 sec fetch list*/

            getAllMessages();
            getConnectedUsers();

            document.getElementById("searchByMessage").addEventListener('click', searchMessagesByTextOrUser);
            document.getElementById("searchByUser").addEventListener('click', searchMessagesByTextOrUser);
            document.getElementById('form').addEventListener('submit', addMessage);

        }

        //=============================================================================================================

        function getAllMessages() {

            fetch('/chat/getAllMessages', {method: 'get', headers: {'Content-Type': 'application/json'}})
                .then(function (response) {
                    if (response.status !== 200) {
                        alert("Looks like there was a problem");
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

        function addMessage(event) {
            event.preventDefault();
            let message = document.getElementById("message_input").value
            document.getElementById("message_input").value = ""

            let data = {"message": document.getElementById("message_input").value}
            fetch('/chat/newMessage', {method: 'POST', body: message, headers: {'Content-Type': 'application/json'}})
                .then(function (response) {
                    if (response.status !== 200) {
                        alert("Looks like there was a problem");
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
        function displayList(data) {
            var target = document.getElementById("wall");
            destroyChildNodes(target)

            for (let i = 0; i < data.length; i++) {

                let new_message = document.createElement("li");
                new_message.className = "message right appeared";
                let avatar = document.createElement("div");
                avatar.className = "avatar";
                let text_wrapper = document.createElement("div");
                text_wrapper.className = "text_wrapper";
                let text = document.createElement("div");
                text.className = "text";
                text.innerText = (data[i].author + " : " + data[i].message).toString();
                text_wrapper.append(text);
                new_message.append(text_wrapper);
                new_message.append(avatar);

                target.append(new_message);
            }
        }

        function open_user_grid(data) {
            var target = document.getElementById("connecting_list");
            destroyChildNodes(target);
            for (let i = 0; i < data.length; i++) {
                let new_message = document.createElement("li");

                new_message.innerText = (i + 1 + ": " + data[i].firstName + " " + data[i].lastName).toString();
                target.append(new_message);
            }

        }


        function getConnectedUsers() {
            fetch('/chat/getConnectedUsers', {
                method: 'get',
                headers: {'Content-Type': 'application/json'}
            })
                .then(function (response) {
                    if (response.status !== 200) {
                        alert("Looks like there was a problem");
                        return;
                    }
                    response.json().then(function (data) {
                        open_user_grid(data)
                    });
                })
                .catch(function (err) {
                    alert("fetch err")
                });
        }

        //=============================================================================================================
        function searchMessagesByTextOrUser() {
            let message = document.getElementById("searchInput").value
            document.getElementById("searchInput").value = ""

            if (message.trim() === "" || message === null) {
                alert("please enter a valid string!");
                return;
            }
            let url = '/chat/' + this.id
            fetch(url, {method: 'post', body: message, headers: {'Content-Type': 'application/json'}})
                .then(function (response) {
                    if (response.status !== 200) {
                        alert("Looks like there was a problem");
                        return;
                    }
                    response.json().then(function (data) {
                        displayListByMessageOrUser(data)
                    });
                })
                .catch(function (err) {
                    alert("fetch err")
                });
        }

        //=============================================================================================================

        function get_input(object_id) {
            let input = document.getElementById(object_id).value;
            if (input.trim() === "" || input === null) {
                alert("please enter a valid string!");
            } else
                return input;
        }

        //=============================================================================================================
        function destroyChildNodes(div) {
            while (div.hasChildNodes()) {
                div.removeChild(div.firstChild);
            }
        }

        //=============================================================================================================
        function displayListByMessageOrUser(data) {

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