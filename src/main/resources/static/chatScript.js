(function (window,document,undefined) {

        window.onload = init;

        //=============================================================================================================

        function init() {

            document.getElementById("open_connecting_users").addEventListener('click', open_user_grid);
            document.getElementById("close_connecting_users").addEventListener('click', close_user_grid);
            document.getElementById("open_search").addEventListener('click', open_search_grid);
            document.getElementById("close_search").addEventListener('click', close_search_grid);
            document.getElementById('form').addEventListener('submit', addMessage);

        }

        //=============================================================================================================
        function addMessage(event) {
            event.preventDefault();
            let message = document.getElementById("message_input").value
            let data = {"message": document.getElementById("message_input").value}
            fetch('/chat/newMessage', {
                method: 'POST',
                body: message,
                headers: {'Content-Type': 'application/json'}
            })
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
            var htmlData = "";
            var target = document.getElementById("wall");

            while (target.hasChildNodes()) {
                target.removeChild(target.firstChild);
            }


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


                message.value = "";

            }
        }

        function search_user_message() {
            let userId = get_input("searchUser'sMessage");
            fetch('/chat/newMessage', {
                method: 'POST',
                body: message,
                headers: {'Content-Type': 'application/json'}
            })
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

        function search_message() {
            let message = get_input("searchInput");
            fetch('/chat/newMessage', {
                method: 'POST',
                body: message,
                headers: {'Content-Type': 'application/json'}
            })
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

        function get_input(object_id) {
            let input = document.getElementById(object_id).value;
            if (input.trim() === "" || input === null) {
                alert("please enter a valid string!");
            } else
                return input;
        }

        function open_user_grid() {
            document.getElementById("connecting_users_div").style.display = "block";
        }

        function close_user_grid() {
            document.getElementById("connecting_users_div").style.display = "none";
        }

        function open_search_grid() {
            document.getElementById("search_div").style.display = "block";
        }

        function close_search_grid() {
            document.getElementById("search_div").style.display = "none";
        }

    }
)(window,document,undefined);