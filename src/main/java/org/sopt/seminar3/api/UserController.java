package org.sopt.seminar3.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;
import org.sopt.seminar3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ehay@naver.com on 2018-10-27
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity getAllUsers() {
        log.info("get All Users");
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{user_idx}")
    public ResponseEntity getUser(@PathVariable(value = "user_idx") final int userIdx){
        log.info("get User");
        return new ResponseEntity<>(userService.findByUserIdx(userIdx), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody final User user){
        log.info("save User");
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }
}
