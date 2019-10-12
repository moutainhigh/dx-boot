package com.dx.security.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/23
 */
@Mapper
public interface BusinessSupplierDao extends BaseMapper {


    List<Map<String, Object>> listMap(@Param("sql") String sql);


    List<Map<String, Object>> getTable();


}
