package io.umss.app.br.broadcast_hb.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.umss.app.br.broadcast_hb.core.Subscriber;

public class SubscriberDTOV {

    private Long uid;

    @NotNull(message = "The status is not valid.")
    @Min(value = 0, message = "The status cannot be less than 0 o greather than 1.")
    @Max(1)
    private Integer status;

    @NotNull(message = "The firstName is not valid.")
    @Size(max = 80, message = "The firstName no should be greather than 80 characters.")
    @NotBlank(message = "The firstName is empty.")
    private String firstName;

    @NotNull(message = "The lastName is not valid.")
    @Size(max = 80, message = "The lastName no should be greather than 80 characters.")
    @NotBlank(message = "The lastName is empty.")
    private String lastName;

    @NotNull(message = "The email is not valid.")
    @Size(max = 100, message = "The email no should be greather than 100 characters.")
    @NotBlank(message = "The email is empty.")
    private String email;

    @NotNull(message = "The cellphone is not valid.")
    @Size(max = 15, message = "The cellphone no should be greather than 15 characters.")
    @NotBlank(message = "The cellphone is empty.")
    private String cellphone;

    private Date createDate;

    private Date lastUpdateDate;

    public void copyCoreObject(Subscriber object) {
        object.setStatus(status);
        object.setFirstName(firstName);
        object.setLastName(lastName);
        object.setEmail(email);
        object.setCellphone(cellphone);
    }

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
}
