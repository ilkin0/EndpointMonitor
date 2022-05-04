package com.ilkinmehdiyev.msmonitor.model.monitor;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static com.ilkinmehdiyev.msmonitor.model.monitor.MonitoringResult.TABLE_NAME;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = TABLE_NAME)
public class MonitoringResult {
    public static final String TABLE_NAME = "monitoring_result";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime checkDate;

    private int statusCode;

    @Column(length = 6000)
    private String payload;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endpoint_id")
    private MonitoredEndpoint endpoint;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonitoringResult that)) return false;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
