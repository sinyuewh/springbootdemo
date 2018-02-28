package com.exsun.girl.Study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController
{
    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private int age;

    @Autowired
    private GirlProperty girlProperty;

    @RequestMapping(value = {"/hello","/hi"}, method = RequestMethod.GET)
    public String Say()
    {
        return "Hello,Spring"+cupSize+age+"gir="+girlProperty.getCupSize()+"girl.age="+girlProperty.getAge();
    }

    //获取参数1
    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public String Say1(@PathVariable("id") int id)
    {
        return "Hello id="+id;
    }

    //获取参数2
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String Say2(@RequestParam("id") int id)
    {
        return "Hello id="+id;
    }

    //获取参数2.1
    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    public String Say4(@RequestParam(value="id",required = true,defaultValue = "0") int id)
    {
        return "Hello id="+id;
    }


    //获取参数3
    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String Say3(int id)
    {
        return "Hello id="+id;
    }
}
