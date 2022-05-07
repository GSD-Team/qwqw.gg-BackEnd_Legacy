package com.gsd.fifa4.domain.gameRecord.controller;

import com.gsd.fifa4.domain.gameRecord.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yohan lee
 * Created on 2021-02-05.
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{accessId}")
    public ResponseEntity<?> getUser(@PathVariable("accessId") String accessId) {
        return ResponseEntity.ok(userService.getUserSquad(accessId));
    }

}
