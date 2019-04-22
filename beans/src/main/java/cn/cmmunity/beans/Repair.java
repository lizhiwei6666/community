package cn.cmmunity.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 报修信息表
 */
public class Repair implements Serializable {
    private Integer id;
    private Date repairDate;
    private String repairInfo;
    private Integer userId;
    private Integer del;
    private Integer status;
    private List<Comment> commentList;

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public String getRepairInfo() {
        return repairInfo;
    }

    public void setRepairInfo(String repairInfo) {
        this.repairInfo = repairInfo;
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
        return "Repair{" +
                "id=" + id +
                ", repairDate=" + repairDate +
                ", repairInfo='" + repairInfo + '\'' +
                ", userId=" + userId +
                ", del=" + del +
                ", status=" + status +
                '}';
    }
}
