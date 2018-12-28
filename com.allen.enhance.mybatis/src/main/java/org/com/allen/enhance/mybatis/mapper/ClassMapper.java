package org.com.allen.enhance.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author allen.wu
 * @since 2018-09-03 21:06
 */
public interface ClassMapper {

     int updateClassName(@Param("name") String className,@Param("id") int id);

}
