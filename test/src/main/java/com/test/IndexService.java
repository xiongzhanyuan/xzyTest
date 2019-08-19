package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("indexService")
public class IndexService {
    @Autowired
    private Test1Service test1Service;
}
