package com.example.demo.admin.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.servicecenterquestion;

public interface servicecenterQuestionRepository extends JpaRepository<servicecenterquestion, Integer> {

	Page<servicecenterquestion> findAll(Pageable pageable);
	Page<servicecenterquestion> findByTitleContaining(String keyword, Pageable pageable);
	
	@Query("select distinct s "
            + "from servicecenterquestion s " 
            + "inner join buyuser b on s.buyuser = b " 
            + "where "
            + "   s.title like %:kw% "
            + "   or b.id like %:kw%")
	Page<servicecenterquestion> findAllByTitleOrId(@Param("kw") String kw, Pageable pageable);
	
	@Query("select distinct s "
            + "from servicecenterquestion s " 
            + "where "
            + "   s.title like %:kw%")
	Page<servicecenterquestion> findAllByTitle(@Param("kw") String kw, Pageable pageable);
	
	@Query("select distinct s "
            + "from servicecenterquestion s " 
            + "inner join buyuser b on s.buyuser = b " 
            + "where "
            + "   b.id like %:kw%")
	Page<servicecenterquestion> findAllById(@Param("kw") String kw, Pageable pageable);
}
