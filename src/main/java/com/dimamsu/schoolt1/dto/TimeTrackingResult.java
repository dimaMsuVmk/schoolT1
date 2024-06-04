package com.dimamsu.schoolt1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
@Schema(description = "Объект для описания времени выполнения метода")
public class TimeTrackingResult {
    @Schema(description = "Название класса", example = "TimeTrackingService")
    @NotNull
    String className;
    @Schema(description = "Название метода", example = "trackTime")
    @NotNull
    String methodName;
    @Schema(description = "Последнее измерение времени", example = "1")
    @Positive
    Long lastTime;
    @Schema(description = "Суммарное измерение времени", example = "1")
    @Positive
    Long totalTime;
    @Schema(description = "Среднее измерение времени", example = "1")
    @Positive
    Double averageTime;

}