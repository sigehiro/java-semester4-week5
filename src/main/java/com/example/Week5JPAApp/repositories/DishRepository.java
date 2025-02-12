package com.example.Week5JPAApp.repositories;


import com.example.Week5JPAApp.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

    //custom method to find records by category and price
    List<Dish> findByIgnoreCaseCategoryAndPrice(String category, double price);

    //native query (custom method)
//    @Query(value="select * from Dish where lower(category) = lower(?1) and price = ?2", nativeQuery = true)
//    public List<Dish> findByCategoryAndPrice(String searchedCategory, Double searchedPrice);


//    @Query("SELECT d FROM Dish d WHERE LOWER(d.category) = LOWER(:searchedCategory) AND d.price = :searchedPrice")
//    List<Dish> findByCategoryAndPrice(@Param("searchedCategory") String searchedCategory, @Param("searchedPrice") Double searchedPrice);



}