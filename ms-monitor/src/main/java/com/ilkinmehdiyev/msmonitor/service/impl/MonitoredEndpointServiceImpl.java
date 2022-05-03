package com.ilkinmehdiyev.msmonitor.service.impl;

import com.ilkinmehdiyev.msmonitor.mapper.monitor.MonitoredEndpointMapper;
import com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint.MonitoredEndpointRequestDto;
import com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint.MonitoredEndpointResponseDto;
import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoredEndpoint;
import com.ilkinmehdiyev.msmonitor.repo.MonitoredEndpointRepo;
import com.ilkinmehdiyev.msmonitor.repo.MonitoringResultRepo;
import com.ilkinmehdiyev.msmonitor.service.interfaces.MonitoredEndpointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public record MonitoredEndpointServiceImpl(
        MonitoredEndpointRepo endpointRepo,
        MonitoredEndpointMapper endpointMapper,
        MonitoringResultRepo resultRepo
) implements MonitoredEndpointService {


    @Override
    public List<MonitoredEndpointResponseDto> getAll() {
        return endpointRepo.findAll()
                .stream()
                .map(endpointMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MonitoredEndpoint get(Long id) {
        return endpointRepo.findById(id)
                .orElseThrow(() -> {
                    log.error("Cannot find MonitoredEndpoint with {} id", id);
                    throw new IllegalArgumentException("Cannot find MonitoredEndpoint with " + id + " id");
                });
    }

    @Override
    public MonitoredEndpointResponseDto getById(Long id) {
        return endpointMapper.toResponse(get(id));
    }

    @Override
    public void save(MonitoredEndpointRequestDto requestDto) {
        MonitoredEndpoint monitoredEndpoint = endpointMapper.requestToEntity(requestDto);

        try {
            endpointRepo.save(monitoredEndpoint);
            log.info("{} entity has been saved", monitoredEndpoint);
        } catch (Exception e) {
            log.error("Cannot save: {}", monitoredEndpoint, e);
            throw new IllegalStateException("Cannot save: " + monitoredEndpoint);
        }
    }

    @Override
    public void delete(Long id) {

        MonitoredEndpoint endpoint = get(id);

        try {
            endpointRepo.delete(endpoint);
            log.info("{} entity have been deleted", endpoint);
        } catch (Exception e) {
            log.error("Cannot delete {} entity", endpoint, e);
            throw new IllegalStateException("Cannot delete " + endpoint + " entity");
        }
    }
}
