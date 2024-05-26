package com.kafka.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMsgProducerService {


    @Autowired
    private KafkaTemplate<String,Object> template;

    public void sendMsgToTopic(String msg){
        CompletableFuture<SendResult<String, Object>> future = template.send("Spring_created_Topic", msg);
        future.whenComplete((result,ex)->{
            if(ex==null){
                System.out.println("Sent message=[ "+ msg +
                        " ] with offset=["+result.getRecordMetadata()
                        .offset()+"]");
            }else{
                System.out.println("Unable to Send message=[ "+ msg +
                        " ] due to: "+ ex.getMessage());
            }
        });
    }
}
