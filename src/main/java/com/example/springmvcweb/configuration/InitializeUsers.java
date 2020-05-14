package com.example.springmvcweb.configuration;

import com.example.springmvcweb.dao.UserDao;
import com.example.springmvcweb.model.User;
import com.example.springmvcweb.util.common.EncryptionUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitializeUsers implements InitializingBean {
    @Autowired
    private UserDao userDao;

    @Override
    public void afterPropertiesSet() {
        Long count = this.userDao.getCount();
        if(count == 0) {
            this.userDao.save(new User("admin@gmail.com", EncryptionUtil.encrypt("123456")));
        }
    }
}
