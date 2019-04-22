package cn.cmmunity.beans;

import java.io.Serializable;

/**
 * 小区管理员
 */
public class HousingAdmin implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer housingId;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "HousingAdmin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", housingId=" + housingId +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getHousingId() {
        return housingId;
    }

    public void setHousingId(Integer housingId) {
        this.housingId = housingId;
    }
}
