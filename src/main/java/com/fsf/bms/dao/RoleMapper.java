package com.fsf.bms.dao;

import com.fsf.bms.dao.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @author Administrator
 * @title: RoleMapper
 * @projectName fsf-bms
 * @description: 角色操作dao
 * @date 2019/6/13 001311:36
 */
@Mapper
public interface RoleMapper {

    /**
     * 根据用户id查询角色
     * @param uid
     * @return
     */
    Set<Role> findRolesByUserId(@Param("uid") Integer uid);

}
