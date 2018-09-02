package top.simba1949;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/27 22:15
 */
@Component
public class Receiver {

    /**
     * 使用 @JmsListener(destination = "my-destination")
     * 监听属性 destination 指定要监听的目的地，即可接收向该目的地发送的消息
     * @param message
     */
    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message){
        System.err.println("接收到：" + message);
    }
}
