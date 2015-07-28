package com.laricafood.resources;

import com.google.gson.Gson;
import com.laricafood.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Rodrigo on 25/07/15.
 */
@Controller
@RequestMapping("/user")
public class UserResource
{

    @ResponseBody
    @RequestMapping(value = "/{facebookId}", method = RequestMethod.GET)
    public String getUser(@PathVariable int facebookId)
    {
        User user = new User(123L,1,"24324323","Rodrigo","Haus","Bacellar","https://graph.facebook.com/10153016626303831/picture?height=130&width=130",new Date());
       return new Gson().toJson(user);
    }

}
