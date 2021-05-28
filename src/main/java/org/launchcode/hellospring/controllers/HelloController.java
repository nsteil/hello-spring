package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by Nate Steil
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }
    public static String createMessage(String name, String language){
        if (language.equals("Spanish")){
            return "Hola, " + name + "!";
        } else if (language.equals("French")){
            return "Bonjour, " + name + "!";
        } else if (language.equals("German")){
            return "Hallo, " + name + "!";
        } else if (language.equals("Gaelic")){
            return "Halò, " + name + "!";
        } else {
            return "Hello, " + name + "!";
        }
    }

    //now lives at /hello/goodbye due to the request mapping above the class
    @GetMapping("goodbye")

    public String goodbye(){
        return "Goodbye, Spring";
    }

    // Handles requests of the form /hello?name=LaunchCode

    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST}) // Allows us to use both get and post

    public String helloWithQueryParam(@RequestParam String name, String language){
        return this.createMessage(name,language);
    }

    // Handles requests of the form /hello/LaunchCode

    @GetMapping("{name}")

    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //now lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='/hello' method='post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name'>" +
                "<select name='language'>" +
                "<option value='English'>English</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='French'>French</option>" +
                "<option value='German'>German</option>" +
                "<option value='Gaelic'>Gaelic</option>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


}
