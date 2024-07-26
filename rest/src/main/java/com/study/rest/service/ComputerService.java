package com.study.rest.service;

import com.study.rest.dto.*;

import java.util.List;

public interface ComputerService {
    int registerComputer(ReqRegisterComputerDto reqRegisterComputerDto);
    List<RespGetListDto> getComputerList(ReqGetListDto reqGetListDto);
    RespGetComputerDto getComputerById(int computerId);
    int deleteComputer(int computerId);
    int updateComputer(ReqUpdateComputerDto reqUpdateComputerDto);
}
