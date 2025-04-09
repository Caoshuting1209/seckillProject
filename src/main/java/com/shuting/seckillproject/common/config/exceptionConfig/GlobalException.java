package com.shuting.seckillproject.common.config.exceptionConfig;

import com.shuting.seckillproject.common.http.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException {
    private Constants constants;
}
