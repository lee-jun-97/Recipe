package com.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.vo.UserVO;

public interface UserRepository extends JpaRepository<UserVO, Long>{

}
