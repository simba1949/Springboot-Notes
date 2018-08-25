package top.simba1949.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.common.CountryCommon;
import top.simba1949.service.CountryService;

import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/25 11:08
 */
@RestController
@RequestMapping("country")
@Slf4j
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("insert")
    public String insert(CountryCommon countryCommon){
        log.info(countryCommon.toString());
        int i = countryService.insert(countryCommon);
        return i + "";
    }

    @GetMapping("delete")
    public String delete(Integer id){
        log.info(id + "");
        countryService.delete(id);
        return "删除成功";
    }

    @GetMapping("select")
    public List<CountryCommon> select(){
        return countryService.selectAll();
    }

    @GetMapping("selectone")
    public CountryCommon selectOne(CountryCommon req){
        CountryCommon countryCommon = countryService.selectOne(req);
        log.info(countryCommon.toString());
        return countryCommon;
    }
}
