package io.com.movie.model.common;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDate;

public class AbstractEntityListener {

    @PrePersist
    public void prePersist(AbstractEntity entity) {
        entity.setCreatedAt(LocalDate.now());
        entity.setUpdatedAt(LocalDate.now());
        entity.setCreatedBy(1L);
        entity.setUpdatedBy(1L);
        entity.setDeleted(false);
    }

    @PreUpdate
    public void preUpdate(AbstractEntity entity) {
        entity.setUpdatedAt(LocalDate.now());
        entity.setUpdatedBy(1L);
    }

}
