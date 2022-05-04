package com.ilkinmehdiyev.msmonitor.service.interfaces;

import com.ilkinmehdiyev.msmonitor.model.dto.monitoringresult.MonitoringResultResponseDto;
import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoringResult;
import org.springframework.data.domain.Page;

public interface MonitoringResultService {
    Page<MonitoringResultResponseDto> getAll(Long endpointId, String authorization);

    MonitoringResultResponseDto getById(long endpointId, long id);
    void save(MonitoringResult result);
}
