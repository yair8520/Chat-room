
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Vector;

@RestController
@RequestMapping("/manage")
public class ListController {

    private final UserServices userServices;
    private final MessageServices messageServices;
    @Resource(name = "id")
    UserData sessionScopeId;
    @Autowired
    public ListController(UserServices userServices, MessageServices messageServices) {
        this.userServices = userServices;
        this.messageServices = messageServices;
    }


    @RequestMapping(value = "/newMessage", method = RequestMethod.POST)
    public String new_message(@RequestParam(name="message") String message,
                              @RequestParam(name="name") String userName,
                              Model model) {

        System.out.println(userName+message);

        long id=sessionScopeId.getId();
        Message new_message=new Message(message,id);
        messageServices.addMessage(new_message);
        List<MessagePair> authorAndMessage= add_authors();
        model.addAttribute("topFiveMessages", add_authors());
        return "chatPage";
    }


    private List<MessagePair> add_authors()
    {
        List<MessagePair> authorAndMessage =  new Vector<MessagePair>();
        var fiveMessages=messageServices.get5Message();
        for (var message:fiveMessages)
        {
            var author=userServices.findById(message.getUser_id()).toString();
            var ma=new MessagePair(message.getMessage(),author);
            authorAndMessage.add(ma);
        }

        return authorAndMessage;
    }



}
