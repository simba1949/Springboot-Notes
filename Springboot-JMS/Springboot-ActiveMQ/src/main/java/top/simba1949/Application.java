package top.simba1949;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/26 21:50
 * implements CommandLineRunner 重写 run 方法：消息发送及目的地定义
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    /**
     * 注入 springboot 为我们配置好的 JmsTemplate 的 Bean
     */
    @Autowired
    JmsTemplate jmsTemplate;

    /**
     * 实现 CommandLineRunner 接口，
     * 通过 JmsTemplate 的 send 方法向 my-destination 目的地发送 msg 消息
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        jmsTemplate.send("my-destination", new Msg());
    }
}
