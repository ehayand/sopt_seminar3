package org.sopt.seminar3.lombok;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by ehay@naver.com on 2018-10-27
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@RequiredArgsConstructor
public class TestRequiredArgsConstructor {

    private int userIdx;
    @NonNull
    private String name;
    private String email;
}
