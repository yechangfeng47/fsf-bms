package com.fsf.bms.dao.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
*  
*  权限实体
* @author brandon
 * @date 2019/6/6 0006 16:29
 * @param 
 * @return 
 */
@Data
public class Permission {
        /**
         * 主键
         */
        private Integer id;
        /**
         * 父编号,本权限可能是该父编号权限的子权限
         */
        private Integer parent_id;
        /**
         * 父编号列表
         */
        private String parent_ids;
        /**
         * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
         */
        private String permission;
        /**
         * 资源类型，[menu|button]
         */
        private String resource_type;
        /**
         * 资源路径 如：/userinfo/list
         */
        private String url;
        /**
         * 权限名称
         */
        private String name;

        /**
         * 是否可用0可用  1不可用
         */
        private String available;
        private Set<Role> roles = new HashSet<>();
}
