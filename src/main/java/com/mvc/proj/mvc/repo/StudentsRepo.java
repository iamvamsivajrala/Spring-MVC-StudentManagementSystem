package com.mvc.proj.mvc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.proj.mvc.entity.Students;

public interface StudentsRepo extends JpaRepository<Students, Long> {

}
