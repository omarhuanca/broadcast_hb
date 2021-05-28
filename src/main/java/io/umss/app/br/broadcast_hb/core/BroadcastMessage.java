package io.umss.app.br.broadcast_hb.core;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "msbm_broadcast_message")
public class BroadcastMessage implements Serializable {

    @Id
    @GeneratedValue(generator = "msbm_broadcast_message")
    @SequenceGenerator(
            name = "msbm_broadcast_message",
            sequenceName = "msbm_seq",
            initialValue = 1000
    )
    @Column(name = "msbm_uid")
    private Long uid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "msbm_msct_uid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "msbm_msms_uid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Message message;

    @Column(name = "msbm_status")
    private Integer status;

    @Column(name = "msbm_name")
    private String name;

    @Column(name = "msbm_create_date")
    private Timestamp createDate;

    @Column(name = "msbm_last_update_date")
    private Timestamp lastUpdateDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object obj) {
        boolean response = false;

        if (this == obj) {
            response = true;
        }

        if(obj instanceof BroadcastMessage) {
            BroadcastMessage other = (BroadcastMessage) obj;
            response = Objects.equals(this.uid, other.uid);
        }

        return response;
    }

    public int hashCode() {
        return Objects.hash(uid);
    }
}
