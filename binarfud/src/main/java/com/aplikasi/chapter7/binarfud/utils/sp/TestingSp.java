package com.aplikasi.chapter7.binarfud.utils.sp;



import com.aplikasi.chapter7.binarfud.repository.MerchantRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestingSp {
    @Autowired
    private DataSource dataSource;
    @Autowired
    public MerchantRepository merchantRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public  QuerySPMerchant querySPMerchant;
    @Before
    public void init() {
        try {
            jdbcTemplate.execute(querySPMerchant.getData);
            jdbcTemplate.execute(querySPMerchant.getDataMerchantLikeName);
            jdbcTemplate.execute(querySPMerchant.insertMerchant);
            jdbcTemplate.execute(querySPMerchant.updateMerchant);
            jdbcTemplate.execute(querySPMerchant.deletedMerchant);
        } finally {
//            session.close();
        }
    }

    @Test
    public void listSP(){
        List<Object> obj =  merchantRepository.getListSP();
        System.out.println(obj);
    }

    @Test
    public void getIdSp(){
        Object obj =  merchantRepository.getemerchantbyid(6L);
        System.out.println(obj);
    }

    @Test
    public void saveSp(){
        Long resid = null;
        merchantRepository.saveMerchantSP(resid, "spring boot1");
    }

    @Test
    public void updateSP(){
        merchantRepository.updateMerchantSP(6L, "spring boot1");
    }
    @Test
    public void deletedSp(){
        merchantRepository.deletedMerchantSP(8L);
    }

}

