package br.edu.ifnmg.gestaoprocessos.domain.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    protected Long id;
    
    @Column(nullable = false, unique = true)
    protected UUID uuid;
    
    @Column(nullable = false)
    protected Boolean trash;
    
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    protected LocalDateTime createdAt;
    
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    protected LocalDateTime updatedAt;
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Boolean getTrash() {
        return trash;
    }

    public void setTrash(Boolean trash) {
        this.trash = trash;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    //</editor-fold>
    
    public BaseEntity() {
        uuid = UUID.randomUUID();
        trash = false;
        createdAt = LocalDateTime.now(ZoneOffset.UTC);
        updatedAt = LocalDateTime.from(createdAt);
    }
    
    public void refreshUpdatedAt() {
        updatedAt = LocalDateTime.now(ZoneOffset.UTC);
    }
    
}
