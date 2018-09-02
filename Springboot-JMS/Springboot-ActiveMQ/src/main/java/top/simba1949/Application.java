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

    @Autowired
    JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        jmsTemplate.send("my-destination", new Msg());
    }
}
