package org.third.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Consumer {

    public static void main(String[] args) {


        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.215:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());


        final KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);

        //Create the ProducerRecord
        ProducerRecord<String, String> record = new ProducerRecord<>("test", "key1", "value1");

        producer.send(record);

        producer.flush();
        
        producer.close();
    }
}
