package me.holostan.hk.demo.dao;

import me.holostan.hk.demo.entity.Demo;
import me.holostan.hk.framework.mvc.Dao;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoDao extends Dao<Demo,Integer> {

}
