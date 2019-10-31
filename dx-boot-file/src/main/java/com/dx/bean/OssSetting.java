package com.dx.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Description: com.dx.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/28
 */
@Data
public class OssSetting implements Serializable {
    private String serviceName;
    private String accessKey;
    private String secretKey;
    private String endpoint;
    private String bucket;
    private String http;
    private Integer zone;
    private String bucketRegion;
    private String filePath;
    private Boolean changed;
}
