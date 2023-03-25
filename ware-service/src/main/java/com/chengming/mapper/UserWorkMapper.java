package com.chengming.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chengming.vo.UserWork;

import java.util.List;

/**
 * @Author: yichengming
 * @Date: 2021/11/04/19:22
 * @Description:
 */
public interface UserWorkMapper extends BaseMapper<UserWork> {


    List<UserWork> getUserWorkList();
}
