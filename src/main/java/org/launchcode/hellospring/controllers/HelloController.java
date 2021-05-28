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

    //now lives at /hello/goodbye due to the request mapping above the class
    @GetMapping("goodbye")

    public String goodbye(){
        return "Goodbye, Spring";
    }

    // Handles requests of the form /hello?name=LaunchCode

    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST}) // Allows us to use both get and post

    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "! ";
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
                "<form action='hello' method='post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


}
