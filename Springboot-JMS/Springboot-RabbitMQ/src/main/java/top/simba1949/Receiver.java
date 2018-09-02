package top.simba1949;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/2 9:38
 */
@Component
public class Receiver {

    @RabbitListener(queues = "my-queue")
    public void receiverMessage(String message){
        System.err.println("Receiver<" + message + ">");
    }
}
