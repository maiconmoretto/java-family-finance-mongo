package com.user.rest;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable String id) throws Exception {
        return userService.findById(id);
    }

    @PostMapping()
    public User save(@RequestBody User user) {
        return userService.save(user);
    }


    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    public Page<User> findWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<User> usersPagination = userService.findWithPaginationAndSorting(offset, pageSize, field);
        return usersPagination;
    }
}