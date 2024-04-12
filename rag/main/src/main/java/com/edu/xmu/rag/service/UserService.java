package com.edu.xmu.rag.service;

import com.edu.xmu.rag.core.exception.BusinessException;
import com.edu.xmu.rag.core.model.ReturnNo;
import com.edu.xmu.rag.core.model.ReturnObject;
import com.edu.xmu.rag.dao.UserDao;
import com.edu.xmu.rag.dao.bo.User;
import com.edu.xmu.rag.service.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    private UserDao userDao;

    @Autowired
    UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public ReturnObject createUser(String name, String password) {
        try {
            userDao.findByName(name);
        } catch (BusinessException e) {
            User user = User.builder().name(name).password(password).build();
            userDao.insert(user);
            return new ReturnObject(ReturnNo.CREATED);
        }
        return new ReturnObject(ReturnNo.USER_NAMEEXIST);

    }

    public ReturnObject login(String name, String password) throws RuntimeException {
        User user = userDao.findByName(name).orElse(null);
        if (user != null && user.getPassword().equals(password)) {
//            UUID uuid = UUID.randomUUID();
//            String s = uuid.toString();
//            user.setToken(s);
//            userDao.save(user);
            return new ReturnObject(ReturnNo.OK);
        } else {
            throw new BusinessException(ReturnNo.USER_INVALID_ACCOUNT, ReturnNo.USER_INVALID_ACCOUNT.getMessage());
        }

    }


}
