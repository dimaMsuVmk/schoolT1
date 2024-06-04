package com.dimamsu.schoolt1.mapper.util;

import com.dimamsu.schoolt1.model.InfoTimeMethod;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Named("UserMapperUtil")
@Component
@RequiredArgsConstructor
public class UserMapperUtil {
    @Named("getLastTime")
    public Long getLastTime(List<InfoTimeMethod> infoTimeMethods) {
        return infoTimeMethods.get(infoTimeMethods.size() - 1).getExecutionTime();
    }

    @Named("getTotalTime")
    public Long getTotalTime(List<InfoTimeMethod> infoTimeMethods) {
        return infoTimeMethods.stream().mapToLong(InfoTimeMethod::getExecutionTime).sum();
    }

    @Named("getAverageTime")
    public Double getAverageTime(List<InfoTimeMethod> infoTimeMethods) {
        return infoTimeMethods.stream().mapToDouble(InfoTimeMethod::getExecutionTime).average().orElse(0.0);
    }
}
