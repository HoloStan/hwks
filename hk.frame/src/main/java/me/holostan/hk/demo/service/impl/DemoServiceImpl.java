package me.holostan.hk.demo.service.impl;

import me.holostan.hk.demo.dao.DemoDao;
import me.holostan.hk.demo.entity.Demo;
import me.holostan.hk.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ghu on 4/11/2017.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    protected DemoDao demoDao;

    @Override
    public void insert(Demo demo) {
        demoDao.insert(demo);
    }
}
