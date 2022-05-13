package com.example.mybatis.mapper;

import com.example.mybatis.entity.Demo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kylin
 * @since 2022-05-12
 */
@Mapper
public interface DemoMapper extends BaseMapper<Demo> {

}
