package com.ilkinmehdiyev.msmonitor.mapper.monitor;

import com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint.MonitoredEndpointRequestDto;
import com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint.MonitoredEndpointResponseDto;
import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoredEndpoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MonitoredEndpointMapper {

    MonitoredEndpointRequestDto toRequest(MonitoredEndpoint monitoredEndpoint);

    MonitoredEndpointResponseDto toResponse(MonitoredEndpoint monitoredEndpoint);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    MonitoredEndpoint requestToEntity(MonitoredEndpointRequestDto requestDto);

    @Mapping(target = "user", ignore = true)
    MonitoredEndpoint responseToEntity(MonitoredEndpointResponseDto responseDto);
}
