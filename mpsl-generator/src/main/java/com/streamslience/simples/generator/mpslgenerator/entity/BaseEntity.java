package com.streamslience.simples.generator.mpslgenerator.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author StreamSlience
 * @description 实体类超类
 * @creatdate 2019-12-10 19:30
 */
@Data
public class BaseEntity<T> {
    private String tenantid;
    private String lastupdateduserid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastupdatedstamp;
    private String createduserid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createdstamp;
    @TableLogic(value = "A", delval = "D")
    private String deleted = "A";
}
