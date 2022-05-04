package com.ilkinmehdiyev.msmonitor.controller.monitor;

import com.ilkinmehdiyev.msmonitor.model.dto.monitoringresult.MonitoringResultResponseDto;
import com.ilkinmehdiyev.msmonitor.service.interfaces.MonitoringResultService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ilkinmehdiyev.msmonitor.util.Const.ApiUrl.MONITORING_RESULT;

@RestController
@RequestMapping(MONITORING_RESULT)
public record MonitoringResultController(
        MonitoringResultService resultService
) {

    @GetMapping
    public Page<MonitoringResultResponseDto> getAll(@PathVariable Long endpointId) {
        return resultService.getAll(endpointId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitoringResultResponseDto> getById(
            @PathVariable Long endpointId,
            @PathVariable Long id
    ) {
        MonitoringResultResponseDto responseDto = resultService.getById(endpointId, id);
        return ResponseEntity.ok(responseDto);
    }
}
