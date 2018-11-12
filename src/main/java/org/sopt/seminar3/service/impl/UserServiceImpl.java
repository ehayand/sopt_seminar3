package org.sopt.seminar3.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;
import org.sopt.seminar3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ehay@naver.com on 2018-10-27
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@Slf4j
@Service(value = "UserServiceImpl")
public class UserServiceImpl implements UserService {
    private static final List<User> userList = new LinkedList<>();

    @Override
    public DefaultRes<List<User>> findAll() {
        if (userList.isEmpty()) return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "리스트 빔");
        return DefaultRes.res(HttpStatus.OK.value(), "Success find all", userList);
    }

    @Override
    public DefaultRes<User> findByUserIdx(int userIdx) {
        if (userList.isEmpty()) return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "리스트 빔.");

        User user = null;

        for (final User target : userList) {
            if (target.getUserIdx() == userIdx) user = target;
        }

        if (user == null) return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "유저 없음.");

        return DefaultRes.res(HttpStatus.OK.value(), "Success find user", user);
    }

    @Override
    public DefaultRes save(User user) {
        if (user == null) return DefaultRes.res(HttpStatus.BAD_REQUEST.value(), "빈 유저");

        userList.add(user);

        return DefaultRes.res(HttpStatus.OK.value(), "Success save");
    }

    @Override
    public DefaultRes<User> update(int userIdx, User user) {
        if (user == null) return DefaultRes.res(HttpStatus.BAD_REQUEST.value(), "빈 유저");

        User beforeUser = null;

        for (final User target : userList) {
            if (target.getUserIdx() == userIdx) beforeUser = target;
        }

        if (beforeUser == null) return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "유저 없음.");

        userList.remove(beforeUser);
        userList.add(user);

        return DefaultRes.res(HttpStatus.OK.value(), "Success update", beforeUser);
    }

    @Override
    public DefaultRes deleteByUserIdx(int userIdx) {
        User user = null;

        for (final User target : userList) {
            if (target.getUserIdx() == userIdx) user = target;
        }

        if (user == null) return DefaultRes.res(HttpStatus.NOT_FOUND.value(), "유저 없음.");

        userList.remove(user);

        return DefaultRes.res(HttpStatus.OK.value(), "Success delete");
    }
}
