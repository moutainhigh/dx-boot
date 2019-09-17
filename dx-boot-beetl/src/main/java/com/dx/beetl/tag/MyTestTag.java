package com.dx.beetl.tag;

import org.beetl.core.tag.GeneralVarTagBinding;

/**
 * Description: com.dx.beetl.tag
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/12
 */
public class MyTestTag extends GeneralVarTagBinding {

    @Override
    public void render(){
        int limit = Integer.parseInt((String) this.getAttributeValue("limit"));
        for (int i = 0; i < limit; i++){
            this.binds(i);
            this.doBodyRender();
        }
    }
}
