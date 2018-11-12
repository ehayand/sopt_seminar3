package org.sopt.seminar3.lombok;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * Created by ehay@naver.com on 2018-10-27
 * Blog : http://ehay.tistory.com
 * Github : http://github.com/ehayand
 */

@AllArgsConstructor
public class TestNonNull {

    private int userIdx;
    @NonNull
    private String name;
    private String email;
}
