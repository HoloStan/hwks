package me.holostan.hk.demo.dao;

import me.holostan.hk.demo.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Created by ghu on 4/10/2017.
 */
@ContextConfiguration(locations={"classpath:config/spring/applicationContext.xml"})
public class TestDemo {

    @Autowired
    DemoDao dao;

    @Test
    public void testDemoService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("config/spring/applicationContext.xml");
        dao = context.getBean(DemoDao.class);
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("demo");
        demo.setUuid(UUID.randomUUID().toString().substring(0,15));
        dao.insert(demo);
    }

}
