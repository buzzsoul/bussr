package org.dataport.bussr.model.foundation;

/**
 * Abstract base class for all the entities to store in database.
 * 
 * @author tute
 * 
 */
public abstract class BaseEntity {

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
