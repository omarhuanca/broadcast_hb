package io.umss.app.br.broadcast_hb.core;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "msms_message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "msms_message",
            sequenceName = "msms_seq",
            initialValue = 1000
    )
    @Column(name = "msms_uid")
    private Long uid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "msms_mscm_uid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ClassMessage classMessage;

    @Column(name = "msms_status", nullable = false)
    private Integer status;

    @Column(name = "msms_body", nullable = false, length = 160)
    private String body;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "msms_create_date", nullable = true, updatable = false)
    private Date createDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "msms_last_update_date", insertable = false)
    private Date lastUpdateDate;

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

    @Override
    public boolean equals(Object obj) {
        boolean response = false;

        if (this == obj) {
            response = true;
        }

        if(obj instanceof Message) {
            Message other = (Message) obj;
            response = Objects.equals(this.uid, other.uid);
        }

        return response;
    }

    public int hashCode() {
        return Objects.hash(uid);
    }
}
