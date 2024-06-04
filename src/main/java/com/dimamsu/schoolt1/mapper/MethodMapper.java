package com.dimamsu.schoolt1.mapper;

import com.dimamsu.schoolt1.dto.TimeTrackingResult;
import com.dimamsu.schoolt1.mapper.util.UserMapperUtil;
import com.dimamsu.schoolt1.model.Method;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring",
        uses = {
                UserMapperUtil.class
        })
public interface MethodMapper {
    @Mapping(target = "className", source = "className")
    @Mapping(target = "methodName", source = "methodName")
    @Mapping(target = "lastTime", source = "infoTimeMethods", qualifiedByName = {"UserMapperUtil", "getLastTime"})
    @Mapping(target = "totalTime", source = "infoTimeMethods", qualifiedByName = {"UserMapperUtil", "getTotalTime"})
    @Mapping(target = "averageTime", source = "infoTimeMethods", qualifiedByName = {"UserMapperUtil", "getAverageTime"})
    TimeTrackingResult toDto(Method methods);
}