package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by Nate Steil
 */
@Controller


public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }

    //now lives at /hello/goodbye due to the request mapping above the class
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring";
    }

    // Handles requests of the form /hello?name=LaunchCode

    @RequestMapping(value ="hello", method= {RequestMethod.GET, RequestMethod.POST}) // Allows us to use both get and post
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "! ";
    }

    // Handles requests of the form /hello/LaunchCode

    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //now lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";

    }
}
