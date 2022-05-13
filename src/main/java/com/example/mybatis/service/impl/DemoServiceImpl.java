package com.example.mybatis.service.impl;

import com.example.mybatis.entity.Demo;
import com.example.mybatis.mapper.DemoMapper;
import com.example.mybatis.service.IDemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kylin
 * @since 2022-05-12
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements IDemoService {

}
