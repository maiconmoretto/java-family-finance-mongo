package com.user.rest;

import com.user.entity.User;
import com.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/")
@Api(value = "users")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "List all users")
    @GetMapping()
    public List<User> findAll() {
        return userService.findAll();
    }

    @ApiOperation(value = "Find a user by id")
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable String id) throws Exception {
        return userService.findById(id);
    }

    @ApiOperation(value = "Save a user")
    @PostMapping()
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @ApiOperation(value = "Find a user with Pagination and Sorting")
    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    public Page<User> findWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<User> usersPagination = userService.findWithPaginationAndSorting(offset, pageSize, field);
        return usersPagination;
    }
}