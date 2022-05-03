package com.ilkinmehdiyev.msmonitor.model.dto.monitoredendpoint;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonitoredEndpointRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String url;

    private LocalDateTime createdDate = LocalDateTime.now();

    private LocalDateTime lastCheck;

    @NotNull
    private int monitoredInterval;
}
