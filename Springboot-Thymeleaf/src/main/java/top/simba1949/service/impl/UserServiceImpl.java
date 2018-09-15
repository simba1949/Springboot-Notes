package top.simba1949.service.impl;

import org.springframework.stereotype.Service;
import top.simba1949.common.UserCommon;
import top.simba1949.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/15 21:12
 */
@Service
public class UserServiceImpl implements UserService {

    private Map<Integer, UserCommon> map = new HashMap<>();
    private List<UserCommon> userCommonList = new ArrayList<>();
    private Integer size;

    @PostConstruct
    public void init(){
        for (int i = 0; i < 20; i++){
            UserCommon userCommon = new UserCommon();
            userCommon.setId(i);
            userCommon.setUsername("李白" + i);
            map.put(i, userCommon);
            size = i;
        }
        map2List();
    }

    @Override
    public List<UserCommon> getAll() {
        return userCommonList;
    }

    @Override
    public void insert(UserCommon userCommon) {
        userCommon.setId(size += 1);
        map.put(userCommon.getId(),userCommon);
        map2List();
    }

    @Override
    public void delete(UserCommon userCommon) {
        map.remove(userCommon.getId());
        map2List();
    }

    @Override
    public void update(UserCommon userCommon) {
        map.put(userCommon.getId(),userCommon);
        map2List();
    }

    public void map2List(){
        userCommonList.clear();
        for (Integer integer : map.keySet()) {
            UserCommon userCommon = map.get(integer);
            userCommonList.add(userCommon);
        }
    }
}
