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
@Table(name = "mssb_subscriber")
public class Subscriber implements Serializable {

    @Id
    @GeneratedValue(generator = "mssb_subscriber")
    @SequenceGenerator(
            name = "mssb_subscriber",
            sequenceName = "mssb_seq",
            initialValue = 1000
    )
    @Column(name = "mssb_uid")
    private Long uid;

    @Column(name = "mssb_status")
    private Integer status;

    @Column(name = "mssb_first_name")
    private String firstName;

    @Column(name = "mssb_last_name")
    private String lastName;

    @Column(name = "mssb_email")
    private String email;

    @Column(name = "mssb_cellphone")
    private String cellphone;

    @Column(name = "mssb_create_date")
    private Timestamp createDate;

    @Column(name = "mssb_last_update_date")
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
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

        if(obj instanceof Subscriber) {
            Subscriber other = (Subscriber) obj;
            response = Objects.equals(this.uid, other.uid);
        }

        return response;
    }

    public int hashCode() {
        return Objects.hash(uid);
    }
}
