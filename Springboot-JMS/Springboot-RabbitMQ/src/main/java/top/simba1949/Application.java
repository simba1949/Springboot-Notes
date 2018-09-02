package top.simba1949;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/2 9:23
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    /**
     * 可注入 springboot 为我们自动配置的 RabbitTemplate
     */
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 定义目的地即队列，队列名称为 my-queue
     * @return
     */
    @Bean
   public Queue wiselyQueue(){
       return new Queue("my-queue");
   }

    /**
     * 实现 CommandLineRunner 接口，
     * 通过 RabbitTemplate 的convertAndSend 方法向队列 my-queue 发送消息
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        rabbitTemplate.convertAndSend("my-queue","来自RabbitMQ的消息");
    }
}
