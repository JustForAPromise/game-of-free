package com.idlewow.admin.model;

import com.idlewow.common.model.BaseModel;
import lombok.Data;

@Data
public class SysAdmin extends BaseModel {
    private String username;
    private String password;
}