package org.example.controledegastosapi.repository;

import org.example.controledegastosapi.entity.Category;
import org.example.controledegastosapi.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    boolean existsByCategoryId(Long id);

    @Query("SELECT e FROM Transaction e WHERE MONTH(e.date) = :month AND YEAR(e.date) = :year")
    List<Transaction> findAllByMonthAndYear(@Param("month") int month, @Param("year") int year);

    List<Transaction> findAllByCategoryId(int category_id);

}

