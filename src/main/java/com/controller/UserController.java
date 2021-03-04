package com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static com.util.Json_Util.getJson;
@Controller
//方法2加@RestController注解，所有返回的都会是Json格式
@RestController
public class UserController {
    /*    方法1
    //@RequestMapping,produces = "application/json;charset=utf-8",用于解决乱码问题
    @RequestMapping(value = "/json",produces = "application/json;charset=utf-8")
    @ResponseBody
    //@ResponseBody会返回Json字符串
 */
    @RequestMapping("/JSON")
    public String json() throws JsonProcessingException {
        //创建一个对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("秦疆",25,"男");
        //将我们的对象转化为json格式
        String str = mapper.writeValueAsString(user);
        return str;
    }
    @RequestMapping("/JSON1")
    public String json1() throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("王博",22,"nan");
        User user1 = new User("si",22,"nan");
        User user2 = new User("wu",22,"nan");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        return mapper.writeValueAsString(list);
    }
    //时间日期
    @RequestMapping("/JSON2")
    public String json2() throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        String str = mapper.writeValueAsString(date);
        return str;
    }
    @RequestMapping("/JSON3")
    public String json3(){
        return getJson(new Date());
    }
    @RequestMapping("/JSON4")
    public String json4(){
        return getJson(new User("李蒙",25,"男"));
    }

}
