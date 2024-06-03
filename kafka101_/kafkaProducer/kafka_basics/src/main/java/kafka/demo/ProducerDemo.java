package kafka.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Properties;


public class ProducerDemo {
    private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());

    public static void main(String[] args) {
        //System.out.println("Hello Mom!");
        log.info("hello word");

        Properties properties = new Properties();

        //connect to localhost ("key","value")
        properties.setProperty("bootstrap.servers", "localhost:9092");

        // set producer properties
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        // create producer <key_type,value_type>
        KafkaProducer<String,String> producer = new KafkaProducer<>(properties);

        // create a Producer Record: message to a topic
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("myTopicName","my message");

        // send data
        producer.send(producerRecord);

        // flush and close the producer
        producer.close();
    }
}
