package com.quanxiaoha.framework.common.exception;

import lombok.Data;

public interface BaseExceptionInterface {
    // 获取异常码
    String getErrorCode();

    // 获取异常信息
    String getErrorMessage();
}
