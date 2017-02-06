package com.cn.chinese.dodemo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by admin on 2017/2/6.
 */

public class TestBean extends BaseBean{
    @JSONField(name = "weatherinfo")
    public WeatherinfoBean weatherinfo;
    public static class WeatherinfoBean {
        @JSONField(name = "city")
        public String city;
        @JSONField(name = "cityid")
        public String cityid;
    }
}
