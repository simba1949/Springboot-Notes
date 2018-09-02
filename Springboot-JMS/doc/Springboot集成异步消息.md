# Springboot集成异步消息

## 异步消息

> 异步消息主要的目的是为了系统和系统之间的通信。所谓异步消息即消息发送者无须等待消息接受者的处理及返回，甚至无须关心消息是否发送成功
>
> 在异步消息中有两个重要的概念，即消息代理和目的地。当消息发送者发送消息后，消息将由消息代理接管，消息代理保证消息传递到指定的目的地。
>
> 异步消息主要有两种形式的目的地：队列（queue）和主题（topic）。队列用于点对点（point-to-point）的消息通信；主题用于发布/订阅式（publish/subscribe）的消息通信。

### 点对点式

>当消息发送者发送消息，消息代理获得消息后将消息放进一个队列里，当有消息接收者来接收消息的时候，消息将从队列中取出来传递给消息接收者，这时候队列就没有这条消息了。
>
>点对点式确保一条消息只有一个消息发送者和一个接受者，但这不能说明只有一个接收者可以从队列中获取消息。因为队列里有多个消息，点对点式只保证每一条消息只有唯一的发送者和接收者。

### 发布订阅式

>与点对点式不同，发布/订阅式是消息发送者发送消息到主题，而多个消息接收者监听这个主题。此时的消息发送者和接收者分别叫做发布者和订阅者。

## 企业级消息代理

JMS（Java Message Service）即 Java 消息服务，是基于 JVM 消息代理的规范。而 ActiveMQ、HornetQ 是一个 JMS 消息代理的实现。

AMQP（Advanced Message Queuing Protocol）也是消息代理的规范，但它不仅兼容 JMS，还支持跨语言和平台。AMQP 的主要实现是 RabbitMQ

## Spring 的支持

Spring 对 JMS 和 AMQP 的支持分别来自于 spring-jms 和 spring-rabbit

他们分别需要 ConnectionFactory 的实现来连接消息代理，并分别提供了 JmsTemplate 、RabbitTemplate 来发送消息。

Spring 为 JMS、AMQP 提供了 @JmsListener、@RabbitListener 注解在方法监听消息代理发布消息。我们需要分别通过 @EnableJms、@EnableRabbit 开启支持。

## Springboot 的支持

Springboot 对 JMS 的自动配置支持位于 org.springframework.boot.autoconfigure.jms 下，支持 JMS 的实现由 ActiveMQ、HornetMQ、Artemis。

Springboot 为我们定义了 ActiveMQConnectionFactory 的 Bean 作为连接，并通过 “spring.activemq” 为前缀的属性来配置 ActiveMQ 的连接属性，

```

```

Springboot 在 JmsAutoConfiguration 还为我们配置好了 JmsTemplate，且为我们开启了注解式消息监听的支持，即自动开启 @EnableJms

Springboot 对 AMQP 的自动配置支持位于 rg.springframework.boot.autoconfigure.amqp 下，他为我们配置了连接 ConnectionFactory 和 RabbitTemplate，且为我们开启了注解式消息监听，即自动开启 @EnableRabbit。RabbitMQ 的配置可通过 “spring.rabbitmq” 来配置 RabbitMQ

```

```

