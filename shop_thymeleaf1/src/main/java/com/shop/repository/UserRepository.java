package com.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.SiteUser;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {
	
    Optional<SiteUser> findByusername(String username);
	
}
