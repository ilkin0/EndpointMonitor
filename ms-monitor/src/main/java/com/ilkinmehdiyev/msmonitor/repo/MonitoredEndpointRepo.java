package com.ilkinmehdiyev.msmonitor.repo;

import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoredEndpoint;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonitoredEndpointRepo extends JpaRepository<MonitoredEndpoint, Long> {
    @Override
    @EntityGraph(attributePaths = "monitoringResultSet")
    Optional<MonitoredEndpoint> findById(Long aLong);
}
