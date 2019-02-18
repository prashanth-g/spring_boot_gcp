package com.prashanth.spring.gcloud.repository;

import com.prashanth.spring.gcloud.model.SpannerReservation;
import org.springframework.cloud.gcp.data.spanner.repository.SpannerRepository;

public interface SpannerReservationRepository extends SpannerRepository<SpannerReservation, String> {
}
