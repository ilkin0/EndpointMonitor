package com.ilkinmehdiyev.msmonitor.repo;

import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoringResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoringResultRepo extends JpaRepository<MonitoringResult, Long> {
}
