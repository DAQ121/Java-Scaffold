package com.daq.springboot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daq.springboot.demo.pojo.Account;
import org.springframework.stereotype.Repository;

/**
 * @author
 * @description
 */
@Repository
public interface AccountMapper extends BaseMapper<Account> {
}
