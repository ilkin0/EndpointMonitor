package com.ilkinmehdiyev.msmonitor.model.monitor;

import com.ilkinmehdiyev.msmonitor.model.user.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static com.ilkinmehdiyev.msmonitor.model.monitor.MonitoredEndpoint.TABLE_NAME;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TABLE_NAME)
public class MonitoredEndpoint {
    public static final String TABLE_NAME = "monitored_endpoint";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String url;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastCheck;

    private int monitoredInterval;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonitoredEndpoint)) return false;
        MonitoredEndpoint that = (MonitoredEndpoint) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
