package com.mkt.email.consumer;

import com.mkt.email.dtos.EmailRecordDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component //vai ser Bin do Spring, porem mais generico (Component)
public class EmailConsumer {

    @RabbitListener(queues = "${broker.queue.email.name}")     //fila que vai ser ouvida para ser consumida
    public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto){     //Payload recebe o corpo que esta sendo enviado
        System.out.printf(emailRecordDto.emailTo());
    }

}
