package com.dx.base.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Description: com.dx.tree
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/15
 */
@Data
@AllArgsConstructor
public class DataBean {

    private String id;

    /**
     * 上级领域id
     */
    private String parentId;

    /**
     * 领域名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    private List<DataBean> childList;

    public DataBean(String id, String parentId, String name, Integer sort) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.sort = sort;
    }
}
