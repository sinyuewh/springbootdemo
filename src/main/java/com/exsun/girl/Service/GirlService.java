package com.exsun.girl.Service;

import com.exsun.girl.DAO.GirlReposity;
import com.exsun.girl.Entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlReposity girlReposity;

    /**
     * 插入两个女生的数据
     */
    //@Transactional
    public void InsertTwo()
    {
        Girl g1=new Girl();
        g1.setCupSize("F");
        g1.setAge(44);
        this.girlReposity.save(g1);

        Girl g2=new Girl();
        g2.setCupSize("GG");
        g2.setAge(44);
        this.girlReposity.save(g2);
    }
}
