package com.liqiang.hrm;

import com.liqiang.hrm.util.RedisUtils;
import org.junit.Test;

public class RedisUtilsTest {
    @Test
    public void test() throws Exception{
        RedisUtils.INSTANCE.getSource().set("xixi", "haha");
    }

    @Test
    public void testGet() throws Exception{
        String xixi = RedisUtils.INSTANCE.get("xixi");
        System.out.println(xixi);
    }
}
