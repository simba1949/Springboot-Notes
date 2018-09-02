package top.simba1949;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/2 9:38
 */
@Component
public class Receiver {
    /**
     * 使用 @RabbitListener(queues = "my-queue")
     * 监听 RabbitMQ 的目的地发送的消息，通 queues 属性指定要监听的目的地
     * @param message
     */
    @RabbitListener(queues = "my-queue")
    public void receiverMessage(String message){
        System.err.println("Receiver<" + message + ">");
    }
}
