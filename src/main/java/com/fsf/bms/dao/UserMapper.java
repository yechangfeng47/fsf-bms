package com.fsf.bms.dao;

import com.fsf.bms.dao.entity.Permission;
import com.fsf.bms.dao.entity.Role;
import com.fsf.bms.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @author Administrator
 * @title: UserMapper
 * @projectName fsf-bms
 * @description: 用户操作dao层
 * @date 2019/6/13 001311:39
 */
@Mapper
public interface UserMapper {

    /**
     * 通过用户名查询用户信息
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 根据用户名删除用户
     * @param userName
     * @return
     */
    int del(@Param("userName")String userName);

    /**
     * @author Administrator
     * @title: PermissionMapper
     * @projectName fsf-bms
     * @description: 权限操作dao层
     * @date 2019/6/13 001311:25
     */
    @Mapper
    interface PermissionMapper {

        /**
         * 根据角色查询用户权限
         * @param roles
         * @return
         */
        Set<Permission> findPermissionsByRoleId(@Param("roles") Set<Role> roles);
    }
}
