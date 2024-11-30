package com.saikumar.CRUD.repository;

import com.saikumar.CRUD.model.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarksRepo extends JpaRepository<Marks, Integer> {

}
