package com.mkt.email.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;


@Configuration      //classe de configuração - fila do rabbitMQ  //4324we45fwef1w145ger
public class RabbitMQConfig {

    @Value("${broker.queue.email.name}")  //propriedade definida no properties - dando acesso para ela
    private String queue;

    @Bean  //informa ao Spring que Queue sera criada quando necessario
    public Queue queue(){
        return new Queue(queue,true);  //nome da fila que sera criada e se sera duravel ou nao (se broker cair e volta a fila vai ser preservada)
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){   //recebemos em json e precisamos converter para java e usar no Dto
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }




}
