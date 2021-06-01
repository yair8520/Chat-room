(function (window,document,undefined)
    {

        window.onload = init;

        //=============================================================================================================

        function init() {

            document.getElementById("send_message").addEventListener('click',foo);

        }
        //=============================================================================================================
        //validate if password are equal
        function foo(event) {
            let message=document.getElementById("message_input");
            let new_message=document.createElement("li");
            new_message.className="message right appeared";
            let avatar=document.createElement("div");
            avatar.className="avatar";
            let text_wrapper=document.createElement("div");
            text_wrapper.className="text_wrapper";
            let text=document.createElement("div");
            text.className="text";
            text.innerText=message.value;
            text_wrapper.append(text);
            new_message.append(text_wrapper);
            new_message.append(avatar);
            let wall=document.getElementById("wall");
            wall.append(new_message);

            message.value="";

        }

    }
)(window,document,undefined);