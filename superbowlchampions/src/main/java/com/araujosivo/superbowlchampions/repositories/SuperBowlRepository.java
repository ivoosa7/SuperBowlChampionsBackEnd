package com.araujosivo.superbowlchampions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.araujosivo.superbowlchampions.entities.SBChampions;

public interface SuperBowlRepository extends JpaRepository<SBChampions, Long>{
    
}
