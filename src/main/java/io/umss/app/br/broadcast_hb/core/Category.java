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
@Table(name = "msct_category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(generator = "msct_category")
    @SequenceGenerator(
            name = "msct_category",
            sequenceName = "msct_seq",
            initialValue = 1000
    )
    @Column(name = "msct_uid")
    private Long uid;

    @Column(name = "msct_status")
    private Integer status;

    @Column(name = "msct_name")
    private String name;

    @Column(name = "msct_create_date")
    private Timestamp createDate;

    @Column(name = "msct_last_update_date")
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

        if(obj instanceof Category) {
            Category other = (Category) obj;
            response = Objects.equals(this.uid, other.uid);
        }

        return response;
    }

    public int hashCode() {
        return Objects.hash(uid);
    }
}
