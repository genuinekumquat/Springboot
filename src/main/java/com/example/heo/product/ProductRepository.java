package com.example.heo.product;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    // * 원래 DB에 연결되는것을 Map으로 간이 처리 (키 - 밸류)

    private Map<Integer, String> db = new HashMap<>();
    private int id = 1;

    public String findProduct(int idx) {
        return db.get(idx); // db에서 id가 id에 맞는 상품 조회
    }

    public void save(String productName) {
        db.put(id++, productName); // id값은 하나씩 증가하게, productName -> RequestParam 전달받은 값 저장시키게
    }
}
