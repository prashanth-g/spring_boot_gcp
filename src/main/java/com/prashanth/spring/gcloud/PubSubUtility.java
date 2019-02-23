package com.prashanth.spring.gcloud;

import com.google.protobuf.ByteString;
import com.prashanth.spring.gcloud.model.SpannerReservation;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.gcp.pubsub.core.publisher.PubSubPublisherTemplate;
import org.springframework.cloud.gcp.pubsub.core.subscriber.PubSubSubscriberTemplate;
import org.springframework.cloud.gcp.pubsub.support.BasicAcknowledgeablePubsubMessage;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.function.Consumer;

@Component
@Log4j2
public class PubSubUtility {

    private final PubSubPublisherTemplate publisher;
    private final PubSubSubscriberTemplate subscriber;

    PubSubUtility(PubSubPublisherTemplate publisher, PubSubSubscriberTemplate subscriber) {
        this.publisher = publisher;
        this.subscriber = subscriber;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void launch() throws Exception {
        this.subscriber.subscribe("reservations-subscription", new Consumer<BasicAcknowledgeablePubsubMessage>() {
            @Override
            public void accept(BasicAcknowledgeablePubsubMessage msg) {
                String data =  msg.getPubsubMessage().getData().toStringUtf8();
                log.info("message received: " + data);
                msg.ack();
            }
        });

        this.publisher.publish("reservations", "Hola " + Instant.now().toString());
    }
}
