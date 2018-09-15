package top.simba1949.service;

import top.simba1949.common.UserCommon;

import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/15 21:08
 */
public interface UserService {

    List<UserCommon> getAll();

    void  insert(UserCommon userCommon);

    void delete(UserCommon userCommon);

    void update(UserCommon userCommon);

}
