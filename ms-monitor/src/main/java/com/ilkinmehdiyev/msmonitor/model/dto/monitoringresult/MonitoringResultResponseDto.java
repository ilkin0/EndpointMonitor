package com.ilkinmehdiyev.msmonitor.model.dto.monitoringresult;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonitoringResultResponseDto {

    private long id;

    private LocalDateTime checkDate;

    private int statusCode;

    private String payload;
}
