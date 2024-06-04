package com.dimamsu.schoolt1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class AllTimeTrackingResult {
    @Schema(description = "Список Объектов для описания времени выполнения метода")
    List<TimeTrackingResult> timeTrackingResults;
}