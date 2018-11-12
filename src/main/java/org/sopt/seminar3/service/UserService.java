package org.sopt.seminar3.service;

import org.sopt.seminar3.model.DefaultRes;
import org.sopt.seminar3.model.User;

import java.util.List;

/**
 * Created by ehay@naver.com on 2018-10-27
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

public interface UserService {

    DefaultRes<List<User>> findAll();

    DefaultRes<User> findByUserIdx(final int userIdx);

    DefaultRes save(final User user);

    DefaultRes<User> update(final int userIdx, final User user);

    DefaultRes deleteByUserIdx(final int userIdx);
}
