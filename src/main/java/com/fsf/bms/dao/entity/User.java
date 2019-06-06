package com.fsf.bms.dao.entity;

import com.fsf.bms.dao.entity.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
/**
*
* 用户信息
* @author brandon
 * @date 2019/6/6 0006 16:37
 * @param
 * @return
 */
@Data
public class User {
        /**
         * 用户id(主键 自增)
         */
        private Integer uid;
        /**
         * 用户名
         */
        private String username;
        /**
         * 登录密码
         */
        private String password;
        /**
         * 用户真实姓名
         */
        private String name;
        /**
         * 身份证号
         */
        private String id_card_num;
        /**
         * 用户状态：0:正常状态,1：用户被锁定
         */
        private String state;
        /**
         * 用户所拥有的所有角色
         */
        private Set<Role> roles = new HashSet<Role>();
}
