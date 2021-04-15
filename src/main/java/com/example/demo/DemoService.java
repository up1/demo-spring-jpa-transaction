package com.example.demo;

import com.example.demo.repository.Repository1;
import com.example.demo.repository.Repository2;
import com.example.demo.repository.Repository3;
import com.example.demo.repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DemoService {

    @Autowired
    private Repository1 repository1;
    @Autowired
    private Repository2 repository2;
    @Autowired
    private Repository3 repository3;


    @Transactional
    public String defaultTx() {
        repository1.save(new User("user 01"));
        repository2.save(new User("user 02"));
        repository3.save(new User("user 03"));
        long count = repository1.count();
        System.out.println(count);
//        return "down with " + count;
        throw new RuntimeException();


    }

}
