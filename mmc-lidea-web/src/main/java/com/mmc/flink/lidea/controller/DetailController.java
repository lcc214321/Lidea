/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 *
 */
package com.mmc.flink.lidea.controller;

import com.mmc.flink.lidea.dto.*;
import com.mmc.flink.lidea.service.LideaLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Joey
 * @date 2019/7/28 16:11
 */
@RestController
@RequestMapping("/lidea/detail/")
@Slf4j
public class DetailController {

    @Resource
    private LideaLogService lidiaLogService;

    @RequestMapping("/apps")
    public ResultDTO<LideaAppResp> getApps() {

        LideaAppResp data = lidiaLogService.listApps();

        return ResultDTO.handleSuccess("SUCESS", data);

    }

    @RequestMapping("/services")
    public ResultDTO<LideaServiceResp> getServices(LideaServiceReq req) {

        LideaServiceResp data = lidiaLogService.listServices(req);

        return ResultDTO.handleSuccess("SUCESS", data);

    }

    @RequestMapping("/methods")
    public ResultDTO<LideaMethodResp> methods(LideaMethodReq req) {

        LideaMethodResp data = lidiaLogService.listMethods(req);

        return ResultDTO.handleSuccess("SUCESS", data);

    }

    @RequestMapping("/access")
    public ResultDTO<LideaLogResp> getAccess(LideaLogReq req) {

        if (null == req) {
            throw new RuntimeException("req can't be null.");
        }


        LideaLogResp data = lidiaLogService.listAccess(req);

        return ResultDTO.handleSuccess("SUCESS", data);
    }

    @RequestMapping("/error")
    public ResultDTO<LideaLogErrorDetailResp> getError(LideaLogReq req) {

        if (null == req) {
            return ResultDTO.handleError("req can't be null.", null);
        }

        LideaLogErrorDetailResp data = lidiaLogService.listError(req);

        return ResultDTO.handleSuccess("SUCESS", data);
    }
}
