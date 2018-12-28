package org.com.allen.enhance.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.com.allen.enhance.mybatis.entity.Student;

/**
 * @author allen.wu
 * @since 2018-09-03 21:07
 */
public interface StudentMapper {

    Student getStudentById(int id);

    int addStudent(Student student);

    int updateStudentName(@Param("name") String name, @Param("id") int id);

    Student getStudentByIdWithClassInfo(int id);

}
