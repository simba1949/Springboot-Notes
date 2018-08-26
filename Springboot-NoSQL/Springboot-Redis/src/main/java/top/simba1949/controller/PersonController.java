package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.common.Person;
import top.simba1949.dao.PersonDao;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/26 16:03
 */
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping("set")
    public void set(){
        Person lb = new Person("1", "李白", 666);
        personDao.save(lb);
        personDao.stringRedisTemplateDemo();
    }

    @RequestMapping("getstr")
    public String getStr(){
        return personDao.getString();
    }

    @RequestMapping("getperson")
    public Person getPerson(){
        return personDao.getPerson();
    }
}
