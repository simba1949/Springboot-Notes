package top.simba1949.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/25 11:09
 */
@Data
@Entity(name = "country")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CountryCommon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "countryname")
    private String countryName;
    @Column(name = "countrycode")
    private String countryCode;
}
