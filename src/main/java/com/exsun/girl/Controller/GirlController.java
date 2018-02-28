package com.exsun.girl.Controller;

import com.exsun.girl.DAO.GirlReposity;
import com.exsun.girl.Entity.Girl;
import com.exsun.girl.Handle.MyException;
import com.exsun.girl.Service.GirlService;
import com.exsun.girl.Utils.Result;
import com.exsun.girl.Utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/girls")
public class GirlController {

    //使用Spring 的日志类
    private static final Logger logger= LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlReposity girlRep;    //自动注入

    @Autowired
    private GirlService girlService;
    /**
     * 查询所有女生列表
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List getGirlList(){
        logger.info("girl_List");
        return girlRep.findAll();
    }

    /**
     * 添加一个女生1
     * @param cupSize
     * @param age
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Girl addGirl(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRep.save(girl);
    }


    /**
     * 添加一个女生2
     * 按实体的来添加
     */
    @RequestMapping(value = "/add2",method = RequestMethod.POST)
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult) throws Exception{
       if(bindingResult.hasErrors())
       {
           throw new MyException(200,bindingResult.getFieldError().getDefaultMessage());
          // return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
       }
        return  ResultUtil.success(girlRep.save(girl));
    }

    /**
     * 根据id查询一个女人
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Girl Search(@PathVariable("id") Integer id)
    {
        return girlRep.findOne(id);
    }

    /**
     * 更新一个资料
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/{id}")
   public Girl Update(@PathVariable("id") Integer id,
                      @RequestParam("cupSize") String cupSize,
                      @RequestParam("age") Integer age)
   {
        Girl girl1=new Girl();
        girl1.setId(id);
        girl1.setAge(age);
        girl1.setCupSize(cupSize);

        return this.girlRep.save(girl1);
   }


    /**
     * 删除一条数据
     * @param id
     */
   @DeleteMapping(value = "/{id}")
   public void Delete(@PathVariable("id") Integer id)
   {
       this.girlRep.delete(id);
   }

    /**
     * 根据女生的年龄进行查询
     * @param age
     * @return
     */
   @GetMapping(value="/age/{age}")
   public List<Girl> GetGirlListByAge(@PathVariable("age") Integer age)
   {
       return this.girlRep.findByAge(age);
   }

    /**
     * 增加两个女生的资料
     */
   @GetMapping(value = "/addtwo")
   public void InsertTwo()
   {
       this.girlService.InsertTwo();
   }
}