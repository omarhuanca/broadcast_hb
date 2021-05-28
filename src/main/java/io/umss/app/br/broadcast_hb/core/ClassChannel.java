package io.umss.app.br.broadcast_hb.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "mscc_class_channel")
public class ClassChannel implements Serializable {

    @Id
    @GeneratedValue(generator = "class_channel_generator")
    @SequenceGenerator(
            name = "class_channel_generator",
            sequenceName = "mscc_seq",
            initialValue = 1000
    )
    @Column(name = "mscc_uid")
    private Long uid;

    @Column(name = "mscc_status")
    private Integer status;

    @Column(name = "mscc_name")
    private String name;

    @Column(name = "mscc_create_date")
    private Timestamp createDate;

    @Column(name = "mscc_last_update_date")
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

        if(obj instanceof ClassChannel) {
            ClassChannel other = (ClassChannel) obj;
            response = Objects.equals(this.uid, other.uid);
        }

        return response;
    }

    public int hashCode() {
        return Objects.hash(uid);
    }
}
