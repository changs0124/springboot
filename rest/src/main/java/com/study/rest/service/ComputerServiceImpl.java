package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Computer;
import com.study.rest.repository.ComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService{

    @Autowired
    private ComputerMapper computerMapper;

    @Override
    public int registerComputer(ReqRegisterComputerDto reqRegisterComputerDto) {
        Computer computer = Computer.builder()
                .company(reqRegisterComputerDto.getCompany())
                .cpu(reqRegisterComputerDto.getCpu())
                .ram(reqRegisterComputerDto.getRam())
                .ssd(reqRegisterComputerDto.getSsd())
                .build();
        return computerMapper.save(computer);
    }

    @Override
    public List<RespGetListDto> getComputerList(ReqGetListDto reqGetListDto) {
        List<RespGetListDto> respDtos = new ArrayList<>();
        Computer computer = Computer.builder()
                .company(reqGetListDto.getCompany())
                .cpu(reqGetListDto.getCpu())
                .build();
        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(computer);
        for(Computer com : computers) {
            RespGetListDto dto = RespGetListDto.builder()
                    .computerId(com.getComputerId())
                    .company(com.getCompany())
                    .build();

            respDtos.add(dto);
        }
        return respDtos;
    }

    @Override
    public RespGetComputerDto getComputerById(int computerId) {
        Computer computer = computerMapper.findComputerById(computerId);
        return RespGetComputerDto.builder()
                .computerId(computer.getComputerId())
                .company(computer.getCompany())
                .cpu(computer.getCpu())
                .ram(computer.getRam())
                .ssd(computer.getSsd())
                .build();
    }

    @Override
    public int deleteComputer(int computerId) {
        return computerMapper.delete(computerId);
    }

    @Override
    public int updateComputer(ReqUpdateComputerDto reqUpdateComputerDto) {
        Computer computer = Computer.builder()
                .computerId(reqUpdateComputerDto.getComputerId())
                .company(reqUpdateComputerDto.getCompany())
                .cpu(reqUpdateComputerDto.getCpu())
                .ram(reqUpdateComputerDto.getRam())
                .ssd(reqUpdateComputerDto.getSsd())
                .build();
        return computerMapper.update(computer);
    }

    //    @Override
//    public List<RespGetListDto> getComputerList(ReqGetListDto reqGetListDto) {
//        Computer computer = Computer.builder()
//                .company(reqGetListDto.getCompany())
//                .cpu(reqGetListDto.getCpu())
//                .build();
//        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(computer);
//        return computers.stream().map(com -> RespGetListDto.builder()
//                .computerId(com.getComputerId())
//                .company(com.getCompany())
//                .build()
//                ).collect(Collectors.toList());
//    }
}
