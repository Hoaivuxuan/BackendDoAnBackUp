package com.duy.BackendDoAn.controllers;

import com.duy.BackendDoAn.dtos.UserDTO;
import com.duy.BackendDoAn.dtos.UserLoginDTO;
import com.duy.BackendDoAn.dtos.UserRegisterDTO;
import com.duy.BackendDoAn.models.User;
import com.duy.BackendDoAn.responses.LoginResponse;
import com.duy.BackendDoAn.responses.RegisterResponse;
import com.duy.BackendDoAn.responses.UserListResponse;
import com.duy.BackendDoAn.responses.UserResponse;
import com.duy.BackendDoAn.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody UserRegisterDTO userRegisterDTO){
        RegisterResponse registerResponse = new RegisterResponse();
        try {
            User user = userService.add(userRegisterDTO);
            registerResponse.setMessage("Register Successfully");
            registerResponse.setUser(user);
            return ResponseEntity.ok(registerResponse);
        } catch (Exception e) {
            registerResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(registerResponse);
        }
    }

    @PostMapping("/createAdmin")
    public ResponseEntity<RegisterResponse> createAdmin(@Valid @RequestBody UserRegisterDTO userRegisterDTO){
        RegisterResponse registerResponse = new RegisterResponse();
        try {
            User user = userService.addAdmin(userRegisterDTO);
            registerResponse.setMessage("Register Successfully");
            registerResponse.setUser(user);
            return ResponseEntity.ok(registerResponse);
        } catch (Exception e) {
            registerResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(registerResponse);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody UserLoginDTO userLoginDTO){
        LoginResponse loginResponse = new LoginResponse();
        try {
            String token  = userService.login(userLoginDTO.getEmail(), userLoginDTO.getPassword());
            User user = userService.getUserDetailFromToken(token);
            loginResponse.setId(user.getId());
            loginResponse.setUsername(user.getName());
            loginResponse.setToken(token);
            loginResponse.setRole(user.getRole());
            loginResponse.setMessage("Login successfully");
            return ResponseEntity.ok(loginResponse);
        } catch (Exception e) {
            loginResponse.setMessage("Login failed");
            return ResponseEntity.badRequest().body(loginResponse);
        }
    }

    @GetMapping("/details")
    public ResponseEntity<UserResponse> getUserDetailsFromId(@RequestParam long id){
        try {
            User user = userService.getUserFromId(id);
            return ResponseEntity.ok(UserResponse.fromUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@Valid @RequestBody UserDTO userDTO, @RequestHeader("Authorization") String authorizationHeader){
        try {
            String extractedToken = authorizationHeader.substring(7);
            UserResponse userResponse = new UserResponse();
            User updatedUser = userService.updateUserDetails(userDTO, extractedToken);
            return ResponseEntity.ok(UserResponse.fromUser(updatedUser));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<UserListResponse> getAllUsers(
            @RequestParam(defaultValue = "", required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        PageRequest pageRequest = PageRequest.of(
                page, limit,
                Sort.by("id").ascending()
        );
        Page<UserResponse> userPage = userService.getAllUsers(keyword, pageRequest);
        int totalPages = userPage.getTotalPages();
        List<UserResponse> users = userPage.getContent();
        return ResponseEntity.ok(UserListResponse.builder()
                        .users(users)
                        .totalPages(totalPages)
                .build());
    }

    @PatchMapping("/{userID}/switchActive")
    public ResponseEntity<String> switchUserActive(@PathVariable Long userID) throws Exception {
        userService.switchActive(userID);
        return ResponseEntity.ok("Switch successfully");
    }
}
