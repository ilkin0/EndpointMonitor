package com.ilkinmehdiyev.msmonitor.service.interfaces;

import com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint.MonitoredEndpointRequestDto;
import com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint.MonitoredEndpointResponseDto;
import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoredEndpoint;

import java.util.List;

public interface MonitoredEndpointService {
    List<MonitoredEndpointResponseDto> getAll();

    MonitoredEndpoint get(Long id);

    MonitoredEndpointResponseDto getById(Long id);

    void save(MonitoredEndpointRequestDto requestDto);

    void delete(Long id);

    void monitor();
}
