package com.ilkinmehdiyev.msmonitor.service.interfaces;

import com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint.MonitoredEndpointRequestDto;
import com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint.MonitoredEndpointResponseDto;
import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoredEndpoint;

import java.util.List;

public interface MonitoredEndpointService {
    List<MonitoredEndpointResponseDto> getAll(String accessToken);

    MonitoredEndpoint get(Long id, String accessToken);

    MonitoredEndpointResponseDto getById(Long id, String accessToken);

    void save(MonitoredEndpointRequestDto requestDto);

    void delete(Long id, String authorization);
}
