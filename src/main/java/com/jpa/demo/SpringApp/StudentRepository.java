package com.jpa.demo.SpringApp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>
{
//   public List<Student> findByCourse(String course);
}
