package com.example.mybatis.service.impl;

import com.example.mybatis.entity.UserInfo;
import com.example.mybatis.mapper.UserInfoMapper;
import com.example.mybatis.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Inkylin
 * @since 2022-05-29
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
