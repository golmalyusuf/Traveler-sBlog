package com.yusuf.travel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusuf.travel.model.Privacy;

@Repository
public interface PrivacyRepository extends JpaRepository<Privacy, Long>{
	Optional<Privacy> findById(Long id);
}
