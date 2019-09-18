package com.dx.dao;

import com.dx.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Description: com.dx.dao
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/18
 */
public interface StudentRepository extends JpaRepository<Student,String> {

    /**
     * 根据年纪和姓名查询
     * @param name
     * @return
     */
    Student findByStuName(String name);

    /**
     * 对于复杂查询可以使用@Query 编写sql
     * @param name
     * @return
     */
    @Query("from User u where u.name=:name")
    Student findStudent(@Param("name") String name);




}
