package top.simba1949.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.simba1949.common.CountryCommon;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/25 14:30
 */
public interface CountryRepository extends JpaRepository<CountryCommon, Integer> {
}
