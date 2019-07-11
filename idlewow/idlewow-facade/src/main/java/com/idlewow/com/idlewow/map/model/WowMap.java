package com.idlewow.com.idlewow.map.model;

import com.idlewow.common.model.BaseModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class WowMap extends BaseModel implements Serializable {
    private String name;
    private Integer occupy;
    private String description;
}