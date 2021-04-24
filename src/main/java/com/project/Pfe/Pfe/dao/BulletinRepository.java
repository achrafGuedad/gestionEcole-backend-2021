package com.project.Pfe.Pfe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Pfe.Pfe.entities.Bulletin;

@Repository
public interface BulletinRepository  extends JpaRepository<Bulletin,Integer>{

}
