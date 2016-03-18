package org.clicker.domain;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Abstract base class for entities. Allows parameterization of id type, chooses auto-generation and implements
 * {@link #equals(Object)} and {@link #hashCode()} based on that id.
 *
 * @param <PK> the the of the entity
 * @author Oliver Gierke
 * @author Thomas Darimont
 */
@MappedSuperclass
public abstract class AppAbstractPersistable<PK extends Serializable> implements Persistable<PK> {

    private static final long serialVersionUID = -5554308939380869754L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PK id;

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Persistable#getId()
     */
    public PK getId() {
        return id;
    }

    /**
     * Sets the id of the entity.
     *
     * @param id the id to set
     */
    protected void setId(final PK id) {
        this.id = id;
    }


    @PrePersist
    public void updateClientId() {
    }

    public String getType() {
        String clazz = this.getClass().toString();
        return clazz.substring(clazz.lastIndexOf(".") + 1);
    }

    protected void setType(String type) {
    }

    /**
     * Must be {@link Transient} in order to ensure that no JPA provider complains because of a missing setter.
     *
     * @see "DATAJPA-622"
     * @see org.springframework.data.domain.Persistable#isNew()
     */
    @Transient
    public boolean isNew() {
        return null == getId();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        AppAbstractPersistable<?> that = (AppAbstractPersistable<?>) obj;

        return null == this.getId() ? false : this.getId().equals(that.getId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }
}
