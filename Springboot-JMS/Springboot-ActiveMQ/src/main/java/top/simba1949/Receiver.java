package top.simba1949;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/27 22:15
 */
@Component
public class Receiver {

    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message){
        System.err.println("接收到：" + message);
    }
}
