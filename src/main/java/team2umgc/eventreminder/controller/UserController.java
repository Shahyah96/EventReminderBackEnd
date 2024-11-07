package team2umgc.eventreminder.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team2umgc.eventreminder.util.EndPoint;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@Validated
public class UserController {

    @GetMapping(value = EndPoint.HELLO_WORLD)
    public String HelloWorld() throws Exception {
        return "Hello World!";
    }
}
