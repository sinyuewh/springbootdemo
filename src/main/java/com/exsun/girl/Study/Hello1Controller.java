package com.exsun.girl.Study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hello1")
public class Hello1Controller
{
    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    public int age;

    @Autowired
    private GirlProperty girlProperty;

    @RequestMapping(value = {"/hello","/hi"}, method = RequestMethod.GET)
    public String Say()
    {
        return "Hello1,Spring"+cupSize+age+"gir="+girlProperty.getCupSize()+"girl.age="+girlProperty.getAge();
    }
}
