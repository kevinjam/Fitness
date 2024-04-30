package com.thinkdevs.userProfile.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditing {

    @CreatedBy
    @Column(name = "created_by",updatable = false)
    @JsonIgnore
    protected String createdBy;

    @CreatedDate
    @Column(name = "date_created", updatable = false)
    protected LocalDateTime dateCreated;

    @LastModifiedBy
    @JsonIgnore
    @Column(name = "last_modified_by", updatable = false)
    protected String lastModifiedBy;

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "last_modified_date", updatable = false)
    protected LocalDateTime lastModifiedDate;
}
