package com.ilkinmehdiyev.msmonitor.mapper.monitor;

import com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint.MonitoredEndpointRequestDto;
import com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint.MonitoredEndpointResponseDto;
import com.ilkinmehdiyev.msmonitor.model.dto.monitoringresult.MonitoringResultResponseDto;
import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoredEndpoint;
import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoringResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MonitoringResultMapper {

    MonitoringResultResponseDto toResponse(MonitoringResult result);
}
