package com.ilkinmehdiyev.msmonitor.job;

import com.ilkinmehdiyev.msmonitor.mapper.monitor.MonitoredEndpointMapper;
import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoredEndpoint;
import com.ilkinmehdiyev.msmonitor.model.monitor.MonitoringResult;
import com.ilkinmehdiyev.msmonitor.repo.MonitoredEndpointRepo;
import com.ilkinmehdiyev.msmonitor.service.interfaces.MonitoredEndpointService;
import com.ilkinmehdiyev.msmonitor.service.interfaces.MonitoringResultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
@RequiredArgsConstructor
public class MonitoringJob {

    private final MonitoredEndpointService endpointService;

    private final MonitoredEndpointRepo endpointRepo;

    private final MonitoringResultService resultService;

    private final MonitoredEndpointMapper endpointMapper;

    private final RestTemplate restTemplate;

    @Scheduled(fixedDelayString = "PT30S")
    public void monitorResults() {
        List<MonitoredEndpoint> endpoints = endpointRepo.findAll();

        ExecutorService executor = Executors.newFixedThreadPool(endpoints.size());

        executor.execute(() -> monitor(endpoints));

        executor.shutdown();
    }

    private void monitor(List<MonitoredEndpoint> endpoints) {
        for (MonitoredEndpoint endpoint : endpoints) {

            ResponseEntity<String> response;
            try {
                response = restTemplate.getForEntity(endpoint.getUrl(), String.class);
                log.info("Request result: {}", response.getStatusCode());
            } catch (Exception e) {
                log.error("Error getting the response", e);
                throw new IllegalStateException();
            }

            MonitoringResult monitoringResult = MonitoringResult.builder()
                    .endpoint(endpoint)
                    .checkDate(LocalDateTime.now())
                    .statusCode(response.getStatusCode().value())
                    .payload(response.getBody())
                    .build();


            endpoint.setLastCheck(LocalDateTime.now());
            endpointRepo.save(endpoint);
            resultService.save(monitoringResult);
        }
    }
}
