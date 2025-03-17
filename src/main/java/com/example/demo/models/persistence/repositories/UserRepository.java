package com.example.demo.models.persistence.repositories;

import com.example.demo.models.persistence.entities.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {
}
