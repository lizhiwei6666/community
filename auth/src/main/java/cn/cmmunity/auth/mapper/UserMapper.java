package cn.cmmunity.auth.mapper;

import cn.cmmunity.beans.Role;
import cn.cmmunity.beans.User;

import java.util.List;

public interface UserMapper {
    User loadUserByUsername(String username);
    List<Role> getUserRolesByUid(Integer id);
}
