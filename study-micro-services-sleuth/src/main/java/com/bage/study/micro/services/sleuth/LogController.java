package com.bage.study.micro.services.sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/param")
    public String run(@RequestParam(value = "param", defaultValue = "bage") String param) throws Exception {
        logger.info("param = {}", param);
        logger.error("something run. param = {}", param);


        return "";
    }
}
