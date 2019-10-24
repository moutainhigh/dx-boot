package com.dx.bean;

import com.dx.validata.ViliGroupOne;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * Description: com.dx.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/8
 */
@Data
public class CacheBean {

    @Range(min = 150, max = 250, message = "range需要在[150,250]之间",groups={ViliGroupOne.class})
    private int num;

}
