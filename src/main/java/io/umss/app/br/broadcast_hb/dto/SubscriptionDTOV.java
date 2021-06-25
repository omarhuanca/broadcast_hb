package io.umss.app.br.broadcast_hb.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.umss.app.br.broadcast_hb.core.Category;
import io.umss.app.br.broadcast_hb.core.ClassChannel;
import io.umss.app.br.broadcast_hb.core.Subscriber;
import io.umss.app.br.broadcast_hb.core.Subscription;

public class SubscriptionDTOV {

    private Long uid;

    @NotNull(message = "The class channel is not valid.")
    private ClassChannel classChannel;

    @NotNull(message = "The subscriber is not valid.")
    private Subscriber subscriber;

    private Category category;

    @NotNull(message = "The status is not valid.")
    @Min(value = 0, message = "The status cannot be less than 0 o greather than 1.")
    @Max(1)
    private Integer status;

    private Date createDate;

    private Date lastUpdateDate;

    public void copyCoreObject(Subscription object) {
        object.setClassChannel(classChannel);
        object.setSubscriber(subscriber);
        object.setStatus(status);
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public ClassChannel getClassChannel() {
        return classChannel;
    }

    public void setClassChannel(ClassChannel classChannel) {
        this.classChannel = classChannel;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
