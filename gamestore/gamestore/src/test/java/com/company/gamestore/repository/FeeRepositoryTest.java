package com.company.gamestore.repository;

import com.company.gamestore.model.Fee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FeeRepositoryTest {
    @Autowired
    FeeRepository feeRepository;

    @BeforeEach
    void setUp(){
        feeRepository.deleteAll();
    }

    @Test
    public void getFeeByProductTypeTest(){
        Fee fee = new Fee();
        fee.setProductType("console");
        fee.setFee(new BigDecimal(10.00));

        fee = feeRepository.save(fee);

        

    }
}