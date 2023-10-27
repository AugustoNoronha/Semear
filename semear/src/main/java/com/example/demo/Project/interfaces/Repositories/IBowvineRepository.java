package com.example.demo.Project.interfaces.Repositories;

import com.example.demo.Project.models.Bowvine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBowvineRepository extends JpaRepository<Bowvine, Long> {

    List<Bowvine> findByOwner_id(Long id);

}
