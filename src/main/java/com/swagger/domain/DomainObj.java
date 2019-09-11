package com.swagger.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DomainObj {
    @ApiModelProperty(notes = "파라미터1", required = true)
    private String param1;
    @ApiModelProperty(notes = "파라미터2", required = true)
    private int param2;
    @ApiModelProperty(notes = "파라미터3", required = true)
    private int param3;
}
