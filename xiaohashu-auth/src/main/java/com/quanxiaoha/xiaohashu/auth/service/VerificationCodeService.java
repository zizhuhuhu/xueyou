package com.quanxiaoha.xiaohashu.auth.service;

import com.quanxiaoha.framework.common.response.Response;
import com.quanxiaoha.xiaohashu.auth.model.vo.veriticationcode.SendVerificationCodeReqVO;

public interface VerificationCodeService {
    Response<?> send(SendVerificationCodeReqVO sendVerificationCodeReqVO);
}
