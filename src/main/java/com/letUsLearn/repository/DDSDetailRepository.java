package com.letUsLearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letUsLearn.entity.DDSdetail;

@Repository
public interface DDSDetailRepository extends JpaRepository<DDSdetail, Long> {

}
