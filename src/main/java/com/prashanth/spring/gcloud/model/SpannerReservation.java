package com.prashanth.spring.gcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

@Table(name = "reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpannerReservation {
    private String id;
    private String name;
}
