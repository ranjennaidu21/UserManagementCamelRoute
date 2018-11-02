package com.candela.iam.usermanagement.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.candela.iam.usermanagement.db.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
