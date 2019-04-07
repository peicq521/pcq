package com.fh.shop.backend.mapper.log;

import com.fh.shop.backend.po.log.LogInfo;

import java.util.List;

public interface ILogMapper {
    public void addLog(LogInfo log);

    public Long totalCount(LogInfo log);

    public List<LogInfo> selectLogPage(LogInfo log);
}
