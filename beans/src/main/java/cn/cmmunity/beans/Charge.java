package cn.cmmunity.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 收费信息表
 */
public class Charge implements Serializable {
    private Integer id;
    private Date paymentTime;
    private double money;
    private Integer paymentType;
    private Integer paymentStatus;
    private Integer del;
    private Integer userId;
    private Integer housingId;
    private String housingName;
    private String userName;
    private Date generationTime;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getGenerationTime() {
        return generationTime;
    }

    public void setGenerationTime(Date generationTime) {
        this.generationTime = generationTime;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    private String paymentTypeName;
    public String getHousingName() {
        return housingName;
    }

    public void setHousingName(String housingName) {
        this.housingName = housingName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHousingId() {
        return housingId;
    }

    public void setHousingId(Integer housingId) {
        this.housingId = housingId;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "id=" + id +
                ", paymentTime=" + paymentTime +
                ", money=" + money +
                ", paymentType=" + paymentType +
                ", paymentStatus=" + paymentStatus +
                ", del=" + del +
                ", userId=" + userId +
                ", housingId=" + housingId +
                '}';
    }
}
