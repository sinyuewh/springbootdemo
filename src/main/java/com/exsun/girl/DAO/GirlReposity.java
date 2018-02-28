package com.exsun.girl.DAO;

import com.exsun.girl.Entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
   Girl：操作对象的类型
   Integer: 主键的类型
 */
public interface GirlReposity extends JpaRepository<Girl,Integer> {

    //根据年龄来进行查询
    public List<Girl> findByAge(Integer age);
}
