package com.study.rest.controller;

import com.study.rest.dto.*;
import com.study.rest.service.ProductService;
import com.study.rest.service.SizeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class BasicController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SizeService sizeService;

    /**
    * REST API
    * 데이터 통신을 위한 HTTP 요청 방식
    * HTTP(프로토콜)을 조금 더 잘 쓰기 위해서 정의된 개념
    * 1. 요청에 대한 동작은 무조건 메소드에 따라 정의하자.
    *   - 데이터 추가(등록)은 POST 요청, POST 요청은 JSON 요청.
    *   - 데이터 조회는 GET 요청,
    *       GET 요청은 QueryString(params) 요청.
    *       ex) 주소?key1=value1&key2=value2
    *   - 데이터 수정은 PUT, Patch 요청, JSON 요청.
    *       PUT 요청과 Patch 요청의 차이점
    *           PUT 요청: 공백 또는 NULL 데이터도 수정 함.
    *           Patch 요청: 공백 또는 NULL 데이터는 수정을 하지 않음(공백, NULL > 업데이트 X)
    *   - 데이터 삭제는 DELETE 요청, params 요청.
    *
    * 2. 주소(URL) 요청 메시지(Resource) 자원 작성법
    *   - URL 가능한 동사를 사용하지 않는다.
    *   - 계층 구조로 작성한다.
     *      ex) /집/주방/가스레인지, /식당/주방/가스레인지
     *  - 요청 메소드마다 작성하는 방법이 다르다.
     *      상품 등록(POST) /product
     *      상품 하나(단건) 조회(GET) /product/1(id, key)
     *      상품 여러개(다건) 조회(GET) /products(전체), /products?page=1&count=30(한페이지에 30개씩)
     *      상품 수정(PUT) /product/1(id, key)
     *      상품 삭제(DELETE) /product/1(id, key)
     * 3. 주소는 가능한 대문자를 사용하지 않는다.
     *
    */

    // 제네릭: 다양한 타입으로 받기위해서
    // 하나의 프로그램
    @CrossOrigin
    @PostMapping("/basic/student")
    public ResponseEntity<?> basicPost(@RequestBody ReqStudentDto reqStudentDto) {
        log.info("reqStu: {}", reqStudentDto);
        // log.info: 서버를 사용하는 동안 생긴 모든 log를 기록(저장), 나중에 확인 가능
        // System.out.println: 모든 요청에 대해 콘솔에 출력, 저장 X
        return ResponseEntity.badRequest().body(null); // ok -> 상태코드 200;
    }
    @CrossOrigin
    @PostMapping("/basic/teacher")
    public ResponseEntity<?> basicPost(@RequestBody ReqTeacherDto reqTeacherDto) {
        log.info("reqTea: {}", reqTeacherDto);
        return ResponseEntity.ok().body(reqTeacherDto);
    }

    @CrossOrigin
    @PostMapping("/api/v1/product")
    public ResponseEntity<?> registerProduct(@RequestBody ProductDto.Register register) {
        return ResponseEntity.ok().body(productService.registerProduct(register));
    }

    @CrossOrigin
    @GetMapping("/api/v1/sizes")
    public ResponseEntity<?> sizeListApi() {
        return ResponseEntity.ok().body(productService.getSizeListAll());
    }

    @CrossOrigin
    @GetMapping("/api/v1/colors")
    public ResponseEntity<?> colorListApi() {
        return ResponseEntity.ok().body(productService.getColorListAll());
    }

    @CrossOrigin
    @PostMapping("api/v1/size")
    public ResponseEntity<?> registerSize(@RequestBody ReqRegisterSizeDto reqRegisterSizeDto) {
        return ResponseEntity.ok().body(sizeService.registerSize(reqRegisterSizeDto));
    }

    @CrossOrigin
    @PostMapping("api/v1/color")
    public ResponseEntity<?> registerColor(@RequestBody ReqRegisterColorDto reqRegisterColorDto) {
        return ResponseEntity.ok().body(productService.registerColor(reqRegisterColorDto));
    }
}
