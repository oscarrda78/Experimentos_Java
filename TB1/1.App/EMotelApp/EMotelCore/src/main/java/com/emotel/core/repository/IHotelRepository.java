package com.emotel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emotel.core.entities.Hotel;


@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Integer>{

}
