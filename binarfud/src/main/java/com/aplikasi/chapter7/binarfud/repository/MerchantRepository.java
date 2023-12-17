package com.aplikasi.chapter7.binarfud.repository;
import com.aplikasi.chapter7.binarfud.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> , JpaSpecificationExecutor<Merchant> {

    List<Merchant> findByOpenIsTrue();

    //Store prosedure
    @Query(value = "select * from getMerchant()",nativeQuery = true)
    public List<Object> getListSP();

    @Procedure("insert")
    void saveMerchantSP(@Param("resid") Long resid, @Param("rqnama") String rqnama);

    @Procedure("update_merchant")
    void updateMerchantSP(@Param("resid") Long resid,@Param("rqnama") String rqnama);

    @Procedure("deleted_merchant")
    void deletedMerchantSP(@Param("resid") Long resid);

    @Procedure("getmerchantbyid")
    Object getemerchantbyid(@Param("resid") Long resid);

    @Procedure("getmerchant")
    List<Object> getMerchant();
}

