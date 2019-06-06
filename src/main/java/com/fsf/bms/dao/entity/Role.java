package com.fsf.bms.dao.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
*
* 角色
* @author brandon
 * @date 2019/6/6 0006 16:35
 * @param
 * @return
 */
@Data
public class Role {
        /**
         * 角色id
         */
        private Integer id;
        /**
         * 角色标识程序中判断使用,如"admin"
         */
        private String role;
        /**
         * 角色描述,UI界面显示使用
         */
        private String description;
        /**
         * 是否可用0可用  1不可用
         */
        private String available;
        /**
         * 某个角色对应的所有用户
         */
        private Set<User> users = new HashSet<>();
        /**
         * 某个角色对应的所有权限
         */
        private Set<Permission> permissions = new HashSet<Permission>();
}
