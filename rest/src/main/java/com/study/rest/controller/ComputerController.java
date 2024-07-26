package com.study.rest.controller;

import com.study.rest.dto.ReqGetListDto;
import com.study.rest.dto.ReqRegisterComputerDto;
import com.study.rest.dto.ReqUpdateComputerDto;
import com.study.rest.service.ComputerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @PostMapping("/computer")
    public ResponseEntity<?> registerApi(@RequestBody ReqRegisterComputerDto reqRegisterComputerDto) {
        log.info("{}", reqRegisterComputerDto);
        return ResponseEntity.ok().body(computerService.registerComputer(reqRegisterComputerDto));
    }

    @PutMapping("/computer/{computerId}")
    public ResponseEntity<?> modifyApi(@PathVariable int computerId, @RequestBody ReqUpdateComputerDto reqUpdateComputerDto) {
        return ResponseEntity.ok().body(computerService.updateComputer(reqUpdateComputerDto));
    }

    @GetMapping("/computers")
    public ResponseEntity<?> getListApi(ReqGetListDto reqGetListDto) {
        log.info("{}", reqGetListDto);
        return ResponseEntity.ok().body(computerService.getComputerList(reqGetListDto));
    }

    @GetMapping("/computer/{computerId}")
    public ResponseEntity<?> getApi(@PathVariable int computerId) {
        log.info("{}", computerId);
        return ResponseEntity.ok().body(computerService.getComputerById(computerId));
    }

    @DeleteMapping("/computer/{computerId}")
    public ResponseEntity<?> removeApi(@PathVariable int computerId) {
        log.info("{}", computerId);
        return ResponseEntity.ok().body(computerService.deleteComputer(computerId));
    }

}
