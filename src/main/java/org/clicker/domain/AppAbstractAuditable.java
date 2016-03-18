package org.clicker.domain;

import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Abstract base class for auditable entities. Stores the audition values in persistent fields.
 *
 * @param <U>  the auditing type. Typically some kind of user.
 * @param <PK> the type of the auditing type's idenifier
 * @author Oliver Gierke
 */
@MappedSuperclass
public abstract class AppAbstractAuditable<U, PK extends Serializable> extends AppAbstractPersistable<PK> implements
        Auditable<U, PK> {

    private static final long serialVersionUID = 141481953116476081L;

    @ManyToOne
    private U createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne
    private U lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Version
    private Long version;

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Auditable#getCreatedBy()
     */
    public U getCreatedBy() {

        return createdBy;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.data.domain.Auditable#setCreatedBy(java.lang.Object)
     */
    public void setCreatedBy(final U createdBy) {

        this.createdBy = createdBy;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Auditable#getCreatedDate()
     */
    public DateTime getCreatedDate() {

        return null == createdDate ? null : new DateTime(createdDate);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.data.domain.Auditable#setCreatedDate(org.joda.time
     * .DateTime)
     */
    public void setCreatedDate(final DateTime createdDate) {

        this.createdDate = null == createdDate ? null : createdDate.toDate();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Auditable#getLastModifiedBy()
     */
    public U getLastModifiedBy() {

        return lastModifiedBy;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.data.domain.Auditable#setLastModifiedBy(java.lang
     * .Object)
     */
    public void setLastModifiedBy(final U lastModifiedBy) {

        this.lastModifiedBy = lastModifiedBy;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Auditable#getLastModifiedDate()
     */
    public DateTime getLastModifiedDate() {

        return null == lastModifiedDate ? null : new DateTime(lastModifiedDate);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.data.domain.Auditable#setLastModifiedDate(org.joda
     * .time.DateTime)
     */
    public void setLastModifiedDate(final DateTime lastModifiedDate) {

        this.lastModifiedDate = null == lastModifiedDate ? null : lastModifiedDate.toDate();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


}
