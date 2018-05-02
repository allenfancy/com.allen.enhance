package org.com.allen.enhance.basic.test;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorInfo {

    private Integer mid;
    
    private String message;
}
