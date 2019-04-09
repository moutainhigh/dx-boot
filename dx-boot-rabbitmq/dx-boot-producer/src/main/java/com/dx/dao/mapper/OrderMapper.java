package com.dx.dao.mapper;

import com.dx.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * <br>
 * 标题: 表 t_order Mapper<br>
 * 描述: 表 t_order Mapper<br>
 * 时间: 2018/09/06<br>
 *
 * @author zc
 */
@Mapper
public interface OrderMapper {

    /**
     * 新增
     *
     * @param order 订单
     */
    void insert(Order order);

}
