package com.prashanth.spring.gcloud;

import com.prashanth.spring.gcloud.model.SpannerReservation;
import com.prashanth.spring.gcloud.repository.SpannerReservationRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Log4j2
@Component
public class SpannerConnectionUtility {

    private final SpannerReservationRepository spannerReservationRepository;

    public SpannerConnectionUtility(SpannerReservationRepository spannerReservationRepository) {
        this.spannerReservationRepository = spannerReservationRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void launch() throws Exception {
        this.spannerReservationRepository.deleteAll();

        Stream.of("Persey", "Nood", "Mike", "Hersley", "Cog")
                .map(name -> new SpannerReservation(null, name))
                .map(this.spannerReservationRepository::save)
                .forEach(log::info);
    }
}
