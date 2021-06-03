(function (window,document,undefined)
    {

        window.onload = init;

        //=============================================================================================================

        function init() {

            document.getElementById('form').addEventListener('submit',addMessage);

        }
        //=============================================================================================================
        function addMessage(event)
        {
            event.preventDefault();
             let message =document.getElementById("message_input").value
            let data = {"message": document.getElementById("message_input").value}
            fetch('/chat/newMessage', {
                method: 'POST',
               body: message,
                headers: {'Content-Type': 'application/json'} })
                .then(function (response) {
                    if (response.status !== 200) {
                        alert("Looks like there was a problem");
                        return ;
                    }
                    response.json().then(function (data){displayList(data)});
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

                let new_message=document.createElement("li");
                new_message.className="message right appeared";
                let avatar=document.createElement("div");
                avatar.className="avatar";
                let text_wrapper=document.createElement("div");
                text_wrapper.className="text_wrapper";
                let text=document.createElement("div");
                text.className="text";

                text.innerText=(data[i].author +" : "+ data[i].message).toString();
                text_wrapper.append(text);
                new_message.append(text_wrapper);
                new_message.append(avatar);

                target.append(new_message);


            }
            message.value="";

        }

    }
)(window,document,undefined);