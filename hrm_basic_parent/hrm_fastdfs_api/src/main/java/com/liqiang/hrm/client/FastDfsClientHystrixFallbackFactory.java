package com.liqiang.hrm.client;

import com.liqiang.hrm.util.AjaxResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author liqiang
 * @date 2019-09-02
 */
@Component
public class FastDfsClientHystrixFallbackFactory implements FallbackFactory<FastDfsClient> {

    @Override
    public FastDfsClient create(Throwable throwable) {
        //return null;
        return new FastDfsClient() {
            @Override
            public String upload(MultipartFile file) {
                return "上传失败";
            }

            @Override
            public AjaxResult delete(String path) {
                return null;
            }

            @Override
            public void download(String path) {

            }
        };
    }
}
