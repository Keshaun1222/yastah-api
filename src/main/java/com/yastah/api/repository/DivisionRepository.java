package com.yastah.api.repository;

//import java.util.List;

import com.yastah.api.entity.Division;
//import com.yastah.api.entity.Side;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

public interface DivisionRepository extends JpaRepository<Division, Long> {
    // @Query(value = "SELECT * FROM divisions WHERE side = :side", nativeQuery = true)
    // public List<Division> findAllByClass(@Param("side") Side side);
}
