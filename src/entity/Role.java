package entity;

/**
 * Author: nyq
 * Date：2022/5/19
 * Description: 角色
 * Version： 1.0
 */
public class Role {
    private String RoleId;//角色id
    private String RoleName;//角色名称
    private String Introduce;//角色介绍

    public String getRoleId() {
        return RoleId;
    }

    public void setRoleId(String roleId) {
        RoleId = roleId;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getIntroduce() {
        return Introduce;
    }

    public void setIntroduce(String introduce) {
        Introduce = introduce;
    }

    public Role(String roleId, String roleName, String introduce) {
        RoleId = roleId;
        RoleName = roleName;
        Introduce = introduce;
    }

    public Role() {
    }
}
