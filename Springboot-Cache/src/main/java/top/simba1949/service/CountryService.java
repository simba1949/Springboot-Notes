package top.simba1949.service;

import top.simba1949.common.CountryCommon;

import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/25 11:08
 */
public interface CountryService {
    /**
     * 增
     * @param countryCommon
     * @return
     */
    int insert(CountryCommon countryCommon);

    /**
     * 查询所有
     * @return
     */
    List<CountryCommon> selectAll();

    /**
     * 删除
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * 查询一个
     * @param countryCommon
     * @return
     */
    CountryCommon selectOne(CountryCommon countryCommon);
}
