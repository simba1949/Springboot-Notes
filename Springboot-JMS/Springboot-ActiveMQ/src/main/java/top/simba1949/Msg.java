package top.simba1949;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/27 22:10
 * 定义 JMS 发送的消息需要实现 MessageCreator 接口，并重写器 createMessage 方法
 */
public class Msg implements MessageCreator {

    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("测试消息");
    }
}
