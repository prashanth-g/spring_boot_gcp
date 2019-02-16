package com.prashanth.spring.gcloud;

import com.prashanth.spring.gcloud.model.Reservation;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class ConnectionUtility {

    private final JdbcTemplate jdbcTemplate;

    public ConnectionUtility(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void launch() throws Exception {
        List<Reservation> reservationList = this.jdbcTemplate.query("select * from reservation",
                (rs, rowNumber) -> new Reservation(rs.getInt("id"), rs.getString("name")));
        reservationList.forEach(log::info);
    }
}

