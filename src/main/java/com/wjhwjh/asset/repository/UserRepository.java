package com.wjhwjh.asset.repository;

import com.wjhwjh.asset.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wjhwjh
 * @description a
 * Created in 17:09 2019/8/27
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
