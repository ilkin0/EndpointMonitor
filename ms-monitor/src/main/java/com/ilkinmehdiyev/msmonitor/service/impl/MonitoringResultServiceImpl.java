package com.ilkinmehdiyev.msmonitor.service.impl;

import com.ilkinmehdiyev.msmonitor.mapper.monitor.MonitoringResultMapper;
import com.ilkinmehdiyev.msmonitor.model.dto.monitoringresult.MonitoringResultResponseDto;
import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoringResult;
import com.ilkinmehdiyev.msmonitor.repo.MonitoringResultRepo;
import com.ilkinmehdiyev.msmonitor.service.interfaces.MonitoredEndpointService;
import com.ilkinmehdiyev.msmonitor.service.interfaces.MonitoringResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record MonitoringResultServiceImpl(
        MonitoringResultRepo resultRepo,
        MonitoringResultMapper mapper,
        MonitoredEndpointService endpointService
) implements MonitoringResultService {

    @Override
    public Page<MonitoringResultResponseDto> getAll() {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("id").descending());
        return resultRepo.findAll(pageRequest)
                .map(mapper::toResponse);
    }

    @Override
    public MonitoringResultResponseDto getById(long endpointId, long id) {
        MonitoringResult monitoringResult = endpointService.get(endpointId)
                .getMonitoringResultSet()
                .stream()
                .filter(result -> result.getId() == id)
                .findFirst()
                .orElseThrow(() -> {
                    log.error("Cannot find Monitoring Result with {} id", id);
                    throw new IllegalArgumentException("Cannot find Monitoring Result with " + id + " id");
                });

        return mapper.toResponse(monitoringResult);
    }

    @Override
    public void save(MonitoringResult result) {
        try {
            resultRepo.save(result);
            log.info("{} has been saved.", result);
        } catch (Exception e) {
            log.error("Cannot save {} entity", result, e);
            throw new IllegalStateException("Cannot save " + result + " entity.");
        }
    }
}
