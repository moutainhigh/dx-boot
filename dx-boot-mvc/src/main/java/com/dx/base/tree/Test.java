package com.dx.base.tree;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: com.dx.tree
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/15
 */
public class Test {

    /**
     * 获取树形结构
     * @param list
     * @return
     */
    public static List<DataBean> listToTree(List<DataBean> list) {
        //用递归找子。
        List<DataBean> treeList = new ArrayList<DataBean>();
        for (DataBean tree : list) {
            if (tree.getParentId().equals("0")) {
                treeList.add(findChildren(tree, list));
            }
        }
        return treeList;
    }

    private static DataBean findChildren(DataBean tree, List<DataBean> list) {
        for (DataBean node : list) {
            if (node.getParentId().equals(tree.getId())){
                if (CollectionUtils.isEmpty(tree.getChildList())) {
                    tree.setChildList(new ArrayList<DataBean>());
                }
                tree.getChildList().add(findChildren(node, list));
            }
        }
        return tree;
    }


    public static void main(String[] args) {

        List<DataBean> dataBeans = new ArrayList<>();
        DataBean dataBean1 = new DataBean("1","0","tom",1);
        DataBean dataBean2 = new DataBean("2","0","tom2",1);
        DataBean dataBean3 = new DataBean("3","1","tom3",1);
        dataBeans.add(dataBean1);
        dataBeans.add(dataBean2);
        dataBeans.add(dataBean3);

        List<DataBean> dataBeans1 = listToTree(dataBeans);


        System.out.println(dataBean1);


    }


}
