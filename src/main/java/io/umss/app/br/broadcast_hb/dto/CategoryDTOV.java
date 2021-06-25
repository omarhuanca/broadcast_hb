package io.umss.app.br.broadcast_hb.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.umss.app.br.broadcast_hb.core.Category;

public class CategoryDTOV {

    private Long uid;

    @NotNull(message = "The status is not valid.")
    @Min(value = 0, message = "The status cannot be less than 0 o greather than 1.")
    @Max(1)
    private Integer status;

    @NotNull(message = "The name is not valid.")
    @Size(max = 80, message = "The name no should be greather than 80 characters.")
    @NotBlank(message = "The name is empty.")
    private String name;

    private Date createDate;

    private Date lastUpdateDate;

    public void copyCoreObject(Category object) {
        object.setStatus(status);
        object.setName(name);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
