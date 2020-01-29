package com.endava.springc7e1.repositories;

import com.endava.springc7e1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
