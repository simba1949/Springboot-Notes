package top.simba1949.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import top.simba1949.common.Person;

import javax.annotation.Resource;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/26 15:47
 */
@Repository
public class PersonDao {

    /**
     * springboot 已经为我们配置 StringRedisTemplate ,可以直接注入
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * @Resource(name = "stringRedisTemplate") 指定 stringRedisTemplate ，可注入基于字符串的简单属性操作方法
     */
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String,String> valOpsStr;

    /**
     * springboot 已经为我们配置 RedisTemplate ,可以直接注入
     */
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    /**
     * @Resource(name = "redisTemplate")，指定 redisTemplate，可注入基于对象的简单属性操作方法
     */
    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valOps;

    public void stringRedisTemplateDemo(){
        valOpsStr.set("xx","yy");
    }

    public void save(Person person){
        valOps.set(person.getId(),person);
    }

    public String getString(){
        return valOpsStr.get("xx");
    }

    public Person getPerson(){
        return (Person) valOps.get("1");
    }
}
