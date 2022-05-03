package com.ilkinmehdiyev.msmonitor.repo;

import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoredEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoredEndpointRepo extends JpaRepository<MonitoredEndpoint, Long> {
}
