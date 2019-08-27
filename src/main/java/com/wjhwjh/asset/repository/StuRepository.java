package com.wjhwjh.asset.repository;

import com.wjhwjh.asset.entity.Stu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StuRepository extends JpaRepository<Stu, Long> {
}
