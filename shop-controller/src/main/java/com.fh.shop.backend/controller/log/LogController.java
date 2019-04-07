package com.fh.shop.backend.controller.log;

import com.fh.shop.backend.biz.log.ILogService;
import com.fh.shop.backend.po.log.LogInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LogController {
    @Resource(name = "logService")
    private ILogService logService;

    @RequestMapping("selectLogPage")
    public Map selectLogPage(LogInfo log, Integer draw, Integer start, Integer length) {
        Map<Object, Object> resultMap = new HashMap<>();

        Long totalCount = logService.totalCount(log);


        log.setStartPos(start);

        log.setPageSize(length);


        List<LogInfo> logList = logService.selectLogPage(log);

        resultMap.put("draw", draw);
        resultMap.put("recordsTotal", totalCount);
        resultMap.put("recordsFiltered", totalCount);
        resultMap.put("data", logList);

        return resultMap;
    }

    @RequestMapping("toLog")
    public String toLog() {
        return "log/showLog";
    }
}
