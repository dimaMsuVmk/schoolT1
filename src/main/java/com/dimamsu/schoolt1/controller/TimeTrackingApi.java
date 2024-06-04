package com.dimamsu.schoolt1.controller;

import com.dimamsu.schoolt1.dto.AllMethodNamesResult;
import com.dimamsu.schoolt1.dto.AllTimeTrackingResult;
import com.dimamsu.schoolt1.exception.InternalServerException;
import com.dimamsu.schoolt1.exception.ResponseException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "TimeTracking", description = "TimeTracking API сервис для хранения и получения времени работы метода")
@RequestMapping("/api/v1")
public interface TimeTrackingApi {

    @Operation(summary = "Получить average, last, total time для Всех методов")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное выполнение",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AllTimeTrackingResult.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка клиента",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ResponseException.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "В случае внутренних ошибок",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = InternalServerException.class))
            )
    })

    @GetMapping("/time/all-info")
    ResponseEntity<AllTimeTrackingResult> getAllTimeTrackingResult();

    @Operation(summary = "Получить время работы метода")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное выполнение",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AllTimeTrackingResult.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка клиента",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ResponseException.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "В случае внутренних ошибок",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = InternalServerException.class))
            )
    })
    @GetMapping("/time/methods/{methodName}/info")
    ResponseEntity<AllTimeTrackingResult> getInfoTimeMethods(@PathVariable("methodName") String methodName);

    @Operation(summary = "Получение списка всех отслеживаемых методов")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное выполнение",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AllMethodNamesResult.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "В случае нарушения контракта",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ResponseException.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "В случае внутренних ошибок",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = InternalServerException.class))
            )
    })
    @GetMapping("/time/methods")
    ResponseEntity<AllMethodNamesResult> getAllMethods();


}