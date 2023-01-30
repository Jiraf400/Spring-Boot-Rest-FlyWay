package com.jirafik.ulbi.boot.jirafik_ulbitv.Controller;

import com.jirafik.ulbi.boot.jirafik_ulbitv.Entity.UserEntity;
import com.jirafik.ulbi.boot.jirafik_ulbitv.Exceptions.UserAlreadyExistException;
import com.jirafik.ulbi.boot.jirafik_ulbitv.Exceptions.UserNotFoundException;
import com.jirafik.ulbi.boot.jirafik_ulbitv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity entity) {
        try {
            userService.registration(entity);
            return ResponseEntity.ok("Entity was saved to database");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }

    }

    @GetMapping
    public ResponseEntity getUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getUser(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/getAll")
    public ResponseEntity getAllUsers() {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.removeUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("An error has occurred");
        }
    }
}
