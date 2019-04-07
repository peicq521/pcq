package com.fh.shop.backend.biz.log;

import com.fh.shop.backend.mapper.log.ILogMapper;
import com.fh.shop.backend.po.log.LogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("logService")
public class LogServiceImpl implements ILogService{
    @Autowired
    private ILogMapper logMapper;

    public void addLog(LogInfo log) {
        logMapper.addLog(log);
    }

    public Long totalCount(LogInfo log) {
        Long totalCount = logMapper.totalCount(log);

        return totalCount;
    }

    public List<LogInfo> selectLogPage(LogInfo log) {
       List<LogInfo> AAA = logMapper.selectLogPage(log);
        return AAA;
    }
}
