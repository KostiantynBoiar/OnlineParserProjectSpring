package com.scrapper.usermicroservice.Controller;

import com.scrapper.usermicroservice.Model.AuthModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:4200" })
public class AuthController {

    @GetMapping("/auth")
    public AuthModel getAuthController() {
        return new AuthModel("You are authenticated");
    }

}
