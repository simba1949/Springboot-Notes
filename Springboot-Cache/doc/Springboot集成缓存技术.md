# Springboot集成缓存技术

Springboot 默认的 ConcurrentMapCacheManager 作为缓存技术

## 缓存简单案例

在 pom.xml 添加依赖

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-cache -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

开启缓存

```java
package top.simba1949.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/25 11:50
 * @EnableCaching 开启缓存
 */
@Configuration
@EnableCaching
public class AppConfig {
}
```

业务层

```java
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

    @Cacheable(value = "country")
    @Override
    public CountryCommon selectOne(CountryCommon countryCommon) {
        CountryCommon common = countryRepository.getOne(countryCommon.getId());
        System.err.println("id、Key为：" + common.getId() + "数据做了缓存");
        return common;
    }
}
```

> @Cacheable(value = "country") 缓存countryCommon数据到country中

## 切换缓存

切换缓存技术除了移除相关依赖包及配置以外，使用方式和实例保持一致。

### Ehcache

在 pom.xml 添加依赖

```xml
<!-- https://mvnrepository.com/artifact/net.sf.ehcache/ehcache -->
<dependency>
    <groupId>net.sf.ehcache</groupId>
    <artifactId>ehcache</artifactId>
</dependency>
```

将 ehcache.xml 配置文件放置类路径下，spirngboot 会自动扫描并自动配置 EhCacheCacheManager 的 bean

ehcache.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ehcache>
    <!--
        磁盘存储:将缓存中暂时不使用的对象,转移到硬盘,类似于Windows系统的虚拟内存
        path:指定在硬盘上存储对象的路径
     -->
    <diskStore path="java.io.tmpdir" />
    <!--
        defaultCache:默认的缓存配置信息,如果不加特殊说明,则所有对象按照此配置项处理
        maxElementsInMemory:设置了缓存的上限,最多存储多少个记录对象
        eternal:代表对象是否永不过期
        timeToIdleSeconds:最大的发呆时间
        timeToLiveSeconds:最大的存活时间
        overflowToDisk:是否允许对象被写入到磁盘
     -->
    <defaultCache maxElementsInMemory="10000" eternal="false"
                  timeToIdleSeconds="120" timeToLiveSeconds="120" overflowToDisk="true" />
    <!--
        cache:为指定名称的对象进行缓存的特殊配置
        name:指定对象的完整名
     -->
    <cache name="top.simba1949.common.CountryCommon" maxElementsInMemory="10000" eternal="false"
           timeToIdleSeconds="300" timeToLiveSeconds="600" overflowToDisk="true" />
</ehcache>
```

### Guava

只需要在 pom.xml 添加 Guava 依赖即可，spirngboot自动配置 GuavaCacheManager 这个Bean

```xml
<!-- https://mvnrepository.com/artifact/com.google.guava/guava -->
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>26.0-jre</version>
</dependency>
```

### Redis

只需要在 pom.xml 添加 redis 依赖即可，spirngboot自动配置 RedisCacheManager 这个Bean 以及 RedisTemplate 的 Bean

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-redis -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

