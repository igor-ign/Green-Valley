package br.com.gv.api.controller;

import br.com.gv.api.controller.request.UserRequest;
import br.com.gv.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequest request) {
        return userService.login(request);
    }
}
