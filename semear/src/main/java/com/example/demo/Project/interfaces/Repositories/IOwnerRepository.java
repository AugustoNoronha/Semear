package com.example.demo.Project.interfaces.Repositories;

import com.example.demo.Project.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long> {
}
