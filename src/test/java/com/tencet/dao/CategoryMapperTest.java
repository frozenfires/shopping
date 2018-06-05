package com.tencet.dao;

import com.tencet.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @program: shopping
 * @description: ${description}
 * @author: wangluliang
 * @create: 2018-06-05 18:47
 **/
//通过配置文件+IOC注入bean
//配置spring和junit整合，这样junit在启动时就会加载spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void insert() throws Exception {
        Category category = new Category();
        category.setName("手机");
        categoryMapper.insert(category);
    }

}