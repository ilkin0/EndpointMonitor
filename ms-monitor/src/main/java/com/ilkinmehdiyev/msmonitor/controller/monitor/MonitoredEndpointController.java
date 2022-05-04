package com.ilkinmehdiyev.msmonitor.controller.monitor;

import com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint.MonitoredEndpointRequestDto;
import com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint.MonitoredEndpointResponseDto;
import com.ilkinmehdiyev.msmonitor.service.interfaces.MonitoredEndpointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.ilkinmehdiyev.msmonitor.util.Const.ApiUrl.MONITORED_ENDPOINT;

@RestController
@RequestMapping(MONITORED_ENDPOINT)
public record MonitoredEndpointController(MonitoredEndpointService endpointService) {

    @GetMapping
    public ResponseEntity<List<MonitoredEndpointResponseDto>> getAll(
            @RequestHeader String authorization
    ) {
        return ResponseEntity.ok(endpointService.getAll(authorization));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitoredEndpointResponseDto> get(@PathVariable Long id, @RequestHeader String authorization) {
        return ResponseEntity.ok(endpointService.getById(id, authorization));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid MonitoredEndpointRequestDto requestDto) {
        endpointService.save(requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @RequestHeader String authorization) {
        endpointService.delete(id, authorization);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
