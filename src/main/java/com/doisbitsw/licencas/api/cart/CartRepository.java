package com.doisbitsw.licencas.api.cart;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query(value = "SELECT *  FROM cart WHERE escola = :escola order by id desc;", nativeQuery = true)
    List<Cart> findByLocal(Long escola);

    @Query(value = "SELECT count(id) as item FROM cart WHERE escola = :escola ", nativeQuery = true)
    double findSoma(Long escola);

    @Query(value = "SELECT sum(quantidade) as item FROM cart WHERE  produto = :produto", nativeQuery = true)
    double findCart(Long produto);



}
