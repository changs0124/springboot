package com.study.rest.service;

import com.study.rest.dto.CommonResponseDto;
import com.study.rest.dto.ReqRegisterSizeDto;
import com.study.rest.dto.SizeDto;
import com.study.rest.entity.Size;
import com.study.rest.repository.SizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImpl implements SizeService{

    @Autowired
    private SizeMapper sizeMapper;

    @Override
    public CommonResponseDto registerSize(ReqRegisterSizeDto reqRegisterSizeDto) {
        return CommonResponseDto.ofDefault(sizeMapper.save(reqRegisterSizeDto.toEntity()));
    }
}
