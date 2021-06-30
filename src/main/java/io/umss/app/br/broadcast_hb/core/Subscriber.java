package io.umss.app.br.broadcast_hb.core;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mssb_subscriber")
public class Subscriber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "mssb_subscriber",
            sequenceName = "mssb_seq",
            initialValue = 1000
    )
    @Column(name = "mssb_uid")
    private Long uid;

    @Column(name = "mssb_status", nullable = false)
    private Integer status;

    @Column(name = "mssb_first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name = "mssb_last_name", nullable = false, length = 80)
    private String lastName;

    @Column(name = "mssb_email", nullable = false, length = 100)
    private String email;

    @Column(name = "mssb_cellphone", nullable = false, length = 15)
    private String cellphone;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "mssb_create_date", nullable = true, updatable = false)
    private Date createDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "mssb_last_update_date", insertable = false)
    private Date lastUpdateDate;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriber", cascade = CascadeType.ALL)
    private Set<Subscription> listSubscription;

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

    public Set<Subscription> getListSubscription() {
        return listSubscription;
    }

    public void setListSubscription(Set<Subscription> listSubscription) {
        this.listSubscription = listSubscription;
    }

    public Boolean compareStatus(Integer status) {
        return this.status.equals(status);
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
