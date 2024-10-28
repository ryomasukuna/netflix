package io.com.movie.model.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AbstractEntityListener.class)
public abstract class AbstractEntity implements Serializable {

    @CreatedBy
    @Column(name = "created_by", length = 50)
    protected Long createdBy;

    @CreatedDate
    @Column(name = "created_at", length = 50)
    protected LocalDate createdAt;

    @LastModifiedBy
    @Column(name = "updated_by", length = 50)
    protected Long updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at", length = 50)
    protected LocalDate updatedAt;

    @Column(name = "deleted")
    protected Boolean deleted;

}
