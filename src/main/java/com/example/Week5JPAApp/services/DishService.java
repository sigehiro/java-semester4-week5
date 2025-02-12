package com.example.Week5JPAApp.services;

import com.example.Week5JPAApp.models.Dish;
import com.example.Week5JPAApp.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    //injecting the repository
    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAllDishes() {
        //business logic should have been here
        return dishRepository.findAll();
    }

    public int saveDish(Dish dish) {
        //business logic should have been here
        //if price is greater than 20, do not save
        if(dish.getPrice() > 20){
            return 0;
        }
        //save the dish. saveDish() returns the number of rows affected
        dishRepository.save(dish);
        return 1;
//        return dishRepository.saveDish(dish);
    }


    //delete a dish from the db
    //0=> dish not deleted
    //1=> dish deleted
    public int deleteDishById(int id) {
        //business logic should have been here
        if(dishRepository.existsById(id)){
            dishRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    //update a dish
    public void updateDish(Dish dish) {
        //business logic should have been here
        dishRepository.save(dish);
    }

    //get a dish by id
    public Optional<Dish> getDishById(int id) {
        //business logic should have been here
        return dishRepository.findById(id);
    }

    public List<Dish> getDishByCategoryAndPrice(String category, double price) {
        //business logic should have been here
        return dishRepository.findByIgnoreCaseCategoryAndPrice(category, price);
    }

}
