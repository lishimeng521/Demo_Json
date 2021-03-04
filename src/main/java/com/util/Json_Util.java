package com.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Json_Util {
    public static String getJson(Object object){
        return jsonUtil(object,"yyyy-MM-dd HH:mm:ss");
    }
    public static String jsonUtil(Object object,String sdf){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //设置时间格式
        SimpleDateFormat df = new SimpleDateFormat(sdf);
        mapper.setDateFormat(df);
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

