package com.example.demo.CompleteOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompleteOrderRepo extends JpaRepository<CompleteOrderModel,Long> {
}
