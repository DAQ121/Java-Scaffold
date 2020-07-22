package com.daq.springboot.demo.service;

import com.daq.springboot.demo.pojo.Account;

/**
 * @author
 * @description
 */
public interface AccountService {

    public Account findByUsername(String username);
}
