package com.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.domain.DomainObj;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Api(value = "test", tags = { "스와거 GET POST SAMPLE" })
public class TestController {
    @ApiOperation(value = "테스트 GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "area", value = "지역", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "param1", value = "파라미터1", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "param2", value = "파라미터2", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "param3", value = "파라미터3", required = false, dataType = "int", paramType = "query") })
    @GetMapping(value = "/main/{area}")
    public DomainObj get(@PathVariable String area, @RequestParam String param1, @RequestParam int param2,
            @RequestParam(required = false, defaultValue = "0") int param3,
            @RequestHeader("remoteAddr") String remoteAddr) {

        DomainObj result = new DomainObj();
        result.setParam1(param1);
        result.setParam2(param2);
        result.setParam3(param3);

        log.info(remoteAddr);
        return result;
    }

    @ApiOperation(value = "테스트 POST")
    @ApiImplicitParam(name = "area", value = "지역", required = true, dataType = "string", paramType = "path")
    @PostMapping(value = "/main/{area}")
    public DomainObj post(@PathVariable String area, @RequestBody DomainObj domainObj,
            @RequestHeader("remoteAddr") String remoteAddr) {

        log.info(remoteAddr);
        return domainObj;
    }
}
