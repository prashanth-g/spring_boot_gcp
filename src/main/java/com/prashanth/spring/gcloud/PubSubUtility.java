package com.prashanth.spring.gcloud;

import com.prashanth.spring.gcloud.model.SpannerReservation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.gcp.pubsub.core.publisher.PubSubPublisherTemplate;
import org.springframework.cloud.gcp.pubsub.core.subscriber.PubSubSubscriberTemplate;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class PubSubUtility {

    private final PubSubPublisherTemplate pubSubPublisherTemplate;
    private final PubSubSubscriberTemplate pubSubSubscriberTemplate;

    PubSubUtility(PubSubPublisherTemplate pubSubPublisherTemplate, PubSubSubscriberTemplate pubSubSubscriberTemplate) {
        this.pubSubPublisherTemplate = pubSubPublisherTemplate;
        this.pubSubSubscriberTemplate = pubSubSubscriberTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void launch() throws Exception {

    }
}
