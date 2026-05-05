package com.delivery.deliveryman.service;

import com.delivery.deliveryman.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaService {
    private KafkaTemplate<String, String> kafkaTemplate;
    public kafkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    private Logger logger = LoggerFactory.getLogger(kafkaService.class);
    public boolean updateLocation(String location){
        this.kafkaTemplate.send(AppConstants.LOCATION_UPDATE_TOPIC, location);
        this.logger.info(location);
        return true;
    }
}
