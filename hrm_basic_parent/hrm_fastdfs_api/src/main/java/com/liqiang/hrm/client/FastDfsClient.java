package com.liqiang.hrm.client;

import com.liqiang.hrm.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "hrm-fastdfs",configuration = FeignClientsConfiguration.class,
        fallbackFactory = FastDfsClientHystrixFallbackFactory.class)
@RequestMapping("fastdfs")
public interface FastDfsClient {
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    String upload(@RequestParam MultipartFile file);

    @RequestMapping(value="/delete",method=RequestMethod.DELETE)
    AjaxResult delete(@RequestParam("path") String path);

    @RequestMapping(value = "/download",method = RequestMethod.GET)
    void download(@RequestParam("path")String path); //直接把流写到response

}

