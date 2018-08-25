package top.simba1949.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.simba1949.common.CountryCommon;
import top.simba1949.dao.CountryRepository;
import top.simba1949.service.CountryService;

import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/25 11:09
 */
@Service
@Slf4j
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public int insert(CountryCommon countryCommon) {
        log.info("CountryServiceImpl" + countryCommon);
        CountryCommon common = countryRepository.save(countryCommon);
        System.err.println("id、key为：" + common.getId() + "数据做了缓存");
        return common.getId();
    }

    @Override
    public List<CountryCommon> selectAll() {
        return countryRepository.findAll();
    }


    @Override
    public void delete(Integer id) {
        System.err.println("删除了id、key为" +  id + "的数据缓存");
        countryRepository.deleteById(id);
    }

    @Cacheable(value = "country",key = "#countryCommon")
    @Override
    public CountryCommon selectOne(CountryCommon countryCommon) {
        CountryCommon common = countryRepository.getOne(countryCommon.getId());
        System.err.println("id、Key为：" + common.getId() + "数据做了缓存");
        return common;
    }
}
