package com.example.heo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 어노테이션 : 스프링에 컨트롤러라고 기능명시
@ResponseBody // 아래 데이터를 Body라는 틀에 담아서 전달해야 함 -> REST API 라고 인식하도록
public class ProductController {
    // Controller : 사용자가 요청을 하면
    // 그에 맞는 로직을 수행 할 수 있도록 서비스에게 시키기 -> 어떤 서비스 어떤 메소드한테 시킬지 관제

    // 핸들러 ? : 요청이 날아오면 요청에맞는 메서드를 호출해주는것
    // 컨트롤러는 요청이오면 요청에 맞는 메서드를 실행시킨다, 그 안에서 그에맞는 로짓을 수행하도록
    // 서비스한테 시킨다

    @Autowired // 2. 스프링컨테이너에 들어있는 빈을 연결해달라고 스프링에게 명시하기
    private ProductService productService;

    // 상품 조회
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET )
    // 괄호에 맞는 요청이 날아오면 아래 메서드를 실행시킨다.
    // 속성으로  value = "http://localhost:8080" 이 날아오고 목적이 GET = 조회일경우
    // * 밸류 "http://localhost:8080"는 디폴트라 생략가능
    public String findProduct(@PathVariable("id") int id) { // PathVariable : id에 해당하는 데이터를 조회
        System.out.println(id); // 테스트시엔 원래 로그를 찍어보는게 맞다

//        ProductService productService = new ProductService();
        // 1. 서비스 객체를 직접 생성함 = 객체에대한 제어권을 직접들고있음
        // 필드로 준비하면 모든 메서드에서 쓸수있다

        return productService.findProduct(id);

//        return "NoteBook";
        // 데이터를 직접 전달함
    }

    //  상품 등록
    @RequestMapping(value = "/products", method = RequestMethod.POST) // Url과 메소드가 날라오면 아래 메소드를 호출할게
    public void saveProduct(@RequestParam(value = "name") String productName) {
        // localhost:8080/products?name=_____  -> name에 들어오는 값을 String productName에 담아줌
        System.out.println("POST");
        productService.saveProduct(productName); // Service의 saveProduct 메서드 호출
    }

    // * 조회랑 등록이 같은 api 를 쓰고있지만 요청할때의 목적 (method) 로 구분됨
}
