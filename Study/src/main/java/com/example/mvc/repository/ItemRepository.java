package com.example.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.vo.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}