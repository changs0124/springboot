package com.study.rest.service;

import com.study.rest.dto.CommonResponseDto;
import com.study.rest.dto.ReqRegisterSizeDto;

public interface SizeService {
    CommonResponseDto registerSize(ReqRegisterSizeDto reqRegisterSizeDto);
}
