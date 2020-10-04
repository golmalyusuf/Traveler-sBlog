package com.yusuf.travel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yusuf.travel.model.Locations;

@Repository
public interface LocationsRepository extends JpaRepository<Locations, Long>{

	@Query(value = "select location_name from locations",nativeQuery = true)
	List<String> findAllLocationNames();
	
	Optional<Locations> findById(Long id);
}
