package com.chengming.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chengming.vo.User;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author: yichengming
 * @Date: 2021/10/28/22:56
 * @Description:
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * @return
     */
    List<User> getUserList();
}
