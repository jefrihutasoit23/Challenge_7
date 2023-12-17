package com.aplikasi.chapter7.binarfud.utils.kafka;

import com.aplikasi.chapter7.binarfud.utils.kafka.dinamis.KafkaTes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-login/kafka/")
public class KafkaController {

    private final  KafkaProducer producer;

    public KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public void writeMessageToTopic(@RequestParam("message") String message){
        this.producer.writeMessage(message);

    }
    @PostMapping("/publish22")
    public void writeMessageToTopic2(@RequestParam("topic") String topic, @RequestParam("message") String message){
        KafkaTes prod = new KafkaTes(topic, message);
        prod.kirim();
    }
}

