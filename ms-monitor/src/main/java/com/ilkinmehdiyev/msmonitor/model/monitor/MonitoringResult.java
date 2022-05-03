package com.ilkinmehdiyev.msmonitor.model.monitor;

import lombok.*;

import javax.persistence.*;

import java.time.LocalDateTime;

import static com.ilkinmehdiyev.msmonitor.model.monitor.MonitoringResult.TABLE_NAME;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TABLE_NAME)
public class MonitoringResult {
    public static final String TABLE_NAME = "monitoring_result";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime checkDate;

    private int statusCode;

    private String payload;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endpoint_id")
    private MonitoredEndpoint endpoint;
}
