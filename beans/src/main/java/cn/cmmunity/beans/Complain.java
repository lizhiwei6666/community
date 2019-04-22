package cn.cmmunity.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 投诉信息表
 */
public class Complain implements Serializable {
    private Integer id;
    private Date complainTime;
    private String content;
    private Integer userId;
    private Integer del;
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getComplainTime() {
        return complainTime;
    }

    public void setComplainTime(Date complainTime) {
        this.complainTime = complainTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Complain{" +
                "id=" + id +
                ", complainTime=" + complainTime +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", del=" + del +
                ", status=" + status +
                '}';
    }
}
