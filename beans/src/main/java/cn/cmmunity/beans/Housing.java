package cn.cmmunity.beans;

import java.io.Serializable;

/**
 * 小区表
 */
public class Housing implements Serializable {
    private Integer id;
    private String housingName;
    private String housingAddress;
    private Integer status;
    private String propertyCompany;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHousingName() {
        return housingName;
    }

    public void setHousingName(String housingName) {
        this.housingName = housingName;
    }

    public String getHousingAddress() {
        return housingAddress;
    }

    public void setHousingAddress(String housingAddress) {
        this.housingAddress = housingAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPropertyCompany() {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany;
    }

    @Override
    public String toString() {
        return "Housing{" +
                "id=" + id +
                ", housingName='" + housingName + '\'' +
                ", housingAddress='" + housingAddress + '\'' +
                ", status=" + status +
                ", propertyCompany='" + propertyCompany + '\'' +
                '}';
    }
}
