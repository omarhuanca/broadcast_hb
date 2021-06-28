package io.umss.app.br.broadcast_hb.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.umss.app.br.broadcast_hb.core.BroadcastMessage;
import io.umss.app.br.broadcast_hb.core.Category;
import io.umss.app.br.broadcast_hb.core.Message;

public class BroadcastMessageDTOV {

    private Long uid;

    @NotNull(message = "The category is not valid.")
    private Category category;

    @NotNull(message = "The message is not valid.")
    private Message message;

    @NotNull(message = "The status is not valid.")
    @Min(value = 0, message = "The status cannot be less than 0 o greather than 1.")
    @Max(1)
    private Integer status;

    private Date createDate;

    private Date lastUpdateDate;

    public void copyCoreObject(BroadcastMessage object) {
        object.setCategory(category);
        object.setMessage(message);
        object.setStatus(status);
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
