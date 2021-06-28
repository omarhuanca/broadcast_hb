package io.umss.app.br.broadcast_hb.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.umss.app.br.broadcast_hb.core.ClassMessage;
import io.umss.app.br.broadcast_hb.core.Message;

public class MessageDTOV {

    private Long uid;

    private ClassMessage classMessage;

    @NotNull(message = "The status is not valid.")
    @Min(value = 0, message = "The status cannot be less than 0 o greather than 1.")
    @Max(1)
    private Integer status;

    @NotNull(message = "The body is not valid.")
    @Size(max = 160, message = "The body no should be greather than 160 characters.")
    @NotBlank(message = "The body is empty.")
    private String body;

    private Date createDate;

    private Date lastUpdateDate;

    public void copyCoreObject(Message object) {
        object.setClassMessage(classMessage);
        object.setStatus(status);
        object.setBody(body);
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public ClassMessage getClassMessage() {
        return classMessage;
    }

    public void setClassMessage(ClassMessage classMessage) {
        this.classMessage = classMessage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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
