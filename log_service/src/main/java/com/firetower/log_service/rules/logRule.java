package com.firetower.log_service.rules;

import com.firetower.log_service.common.models.Log;

import java.util.List;

public interface logRule {

    public Boolean isActive();

    public Boolean check(List<Log> history);

    public String getMessage();

}
