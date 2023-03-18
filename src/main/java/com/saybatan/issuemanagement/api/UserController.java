package com.saybatan.issuemanagement.api;

import com.saybatan.issuemanagement.dto.*;
import com.saybatan.issuemanagement.service.impl.UserServiceImpl;
import com.saybatan.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.UserCtrl.CTRL)
@Api(value = ApiPaths.UserCtrl.CTRL)
@Slf4j
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By ID Operation", response = UserDTO.class)
    public ResponseEntity<UserDTO> getById(@PathVariable("id") Long id) {
        log.info("ProjectController -> GetByID");
        log.debug("ProjectController -> GetByID -> PARAM: ", id);
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    @ApiOperation(value = "Get All Operation", response = UserDTO.class)
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    @ApiOperation(value = "Create User", response = UserDTO.class)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) throws Exception{
        return ResponseEntity.ok(userService.save(userCreateDTO));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = UserDTO.class)
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @Validated @RequestBody UserSaveDTO userSaveDTO) {
        return ResponseEntity.ok(userService.update(id, userSaveDTO));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }


}
