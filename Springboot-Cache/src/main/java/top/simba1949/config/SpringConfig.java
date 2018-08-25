package top.simba1949.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/25 11:09
 */
@Configuration
@ImportResource(locations = "classpath*:applicationContext.xml")
public class SpringConfig {
}
