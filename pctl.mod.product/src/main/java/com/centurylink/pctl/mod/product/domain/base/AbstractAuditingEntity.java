package com.centurylink.pctl.mod.product.domain.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;

/**
 * AbstractAuditingEntity class <br>
 * Base abstract class for entities which will hold definitions for created, last modified by and created,
 * last modified by date.
 */
public abstract class AbstractAuditingEntity {

    /**
     * createdBy is configured with field created_by
     */
    @CreatedBy
    @Field("created_by")
    @JsonIgnore
    private String createdBy;


    /**
     * createdDate is configured with field created_date
     */
    @CreatedDate
    @Field("created_date")
    @JsonIgnore
    private ZonedDateTime createdDate = ZonedDateTime.now();

    /**
     * lastModifiedBy is configured with field last_modified_by
     */
    @LastModifiedBy
    @Field("last_modified_by")
    @JsonIgnore
    private String lastModifiedBy;

    /**
     * lastModifiedDate is configured with field last_modified_date
     */
    @LastModifiedDate
    @Field("last_modified_date  ")
    @JsonIgnore
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

    /**
     * getCreatedBy() getmethod for createdBy
     * @return createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * set method for createdBy
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    /**
     * getCreatedDate() getmethod for createdDate
     * @return createdDate
     */
    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }
    /**
     * set method for createdDate
     * @param createdDate
     */
    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }
    /**
     * getLastModifiedBy() getmethod for lastModifiedBy
     * @return lastModifiedBy
     */
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    /**
     * set method for lastModifiedBy
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    /**
     * getLastModifiedDate() getmethod for lastModifiedDate
     * @return lastModifiedDate
     */
    public ZonedDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }
    /**
     * set method for lastModifiedDate
     * @param lastModifiedDate
     */
    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
