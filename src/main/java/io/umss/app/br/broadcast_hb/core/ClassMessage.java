package io.umss.app.br.broadcast_hb.core;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "mscm_class_message")
public class ClassMessage implements Serializable {

    @Id
    @GeneratedValue(generator = "mscm_class_message")
    @SequenceGenerator(
            name = "mscm_class_message",
            sequenceName = "mscm_seq",
            initialValue = 1000
    )
    @Column(name = "mscm_uid")
    private Long uid;

    @Column(name = "mscm_status")
    private Integer status;

    @Column(name = "mscm_name")
    private String name;

    @Column(name = "mscm_create_date")
    private Timestamp createDate;

    @Column(name = "mscm_last_update_date")
    private Timestamp lastUpdateDate;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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

        if(obj instanceof ClassMessage) {
            ClassMessage other = (ClassMessage) obj;
            response = Objects.equals(this.uid, other.uid);
        }

        return response;
    }

    public int hashCode() {
        return Objects.hash(uid);
    }
}
