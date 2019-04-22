package cn.cmmunity.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 缴费类型表
 */
public class PaymentType implements Serializable {
    private Integer id;
    private String paymentTypeName;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "id=" + id +
                ", paymentTypeName='" + paymentTypeName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
