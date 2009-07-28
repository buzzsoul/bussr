package org.dataport.bussr.model.mapper.foundation;

import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 * Interface that contains all the logic for map a row into a Java class. It has
 * the method inherited from ParameterizedRowMapper for mapping a row and adds
 * new methods for building the query.
 * 
 * @author tute
 * 
 */
public interface ExtendedParameterizedRowMapper<T> extends ParameterizedRowMapper<T> {

    String getTableName();

    String getPrimaryKeyFieldName();
    
    String getFieldListAsString();

    String getParametersListAsString();

    Map<String, Object> getParameters(T entity);
}
