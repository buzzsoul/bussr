package org.dataport.bussr.data.foundation;

import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dataport.bussr.model.foundation.BaseEntity;
import org.dataport.bussr.model.mapper.foundation.ExtendedParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * Generic DAO that contains crud basic operations. It also exposes the JDBC
 * template and the mapper for writing custom queries.
 * 
 * @author tute
 * 
 * @param <T>
 *            base entity for the dao
 * @param <U>
 *            row mapper
 */
public abstract class GenericDao<T extends BaseEntity, U extends ExtendedParameterizedRowMapper<? extends BaseEntity>> {

    private static Log LOGGER = LogFactory.getLog(GenericDao.class);

    protected SimpleJdbcTemplate jdbcTemplate;
    protected ExtendedParameterizedRowMapper<T> mapper;

    @SuppressWarnings("unchecked")
    public GenericDao(DataSource dataSource, Class<U> mapperClass) throws InstantiationException, IllegalAccessException {
        super();
        this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
        this.mapper = (ExtendedParameterizedRowMapper<T>) mapperClass.newInstance();
    }

    public T load(Long id) {
        StringBuilder query = new StringBuilder("select ").append(mapper.getFieldListAsString()).append(" from ").append(
                mapper.getTableName()).append(" where ").append(mapper.getPrimaryKeyFieldName()).append(" = ?");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Getting object for id " + id + " , using a row mapper of type " + mapper.getClass().getName());
        }
        return (T) jdbcTemplate.queryForObject(query.toString(), mapper, id);
    }

    public void save(T entity) {
        StringBuilder query = new StringBuilder("insert into ").append(mapper.getTableName()).append(" (");
        query.append(mapper.getFieldListAsString()).append(") values (").append(mapper.getParametersListAsString()).append(")");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Saving entity using a row mapper of type " + mapper.getClass().getName());
        }
        jdbcTemplate.update(query.toString(), mapper.getParameters(entity));
    }

    public void update(T entity) {
        Map<String, Object> parameters = mapper.getParameters(entity);
        StringBuilder query = new StringBuilder("update ").append(mapper.getTableName()).append(" set ");
        int i = 0;
        for (Entry<String, Object> currentEntry : parameters.entrySet()) {
            if (i > 0) {
                query.append(",");
            }
            query.append(currentEntry.getKey()).append(" = :").append(currentEntry.getKey());
            i++;
        }
        query.append(" where ").append(mapper.getPrimaryKeyFieldName()).append(" = :id");
        parameters.put("id", entity.getId());

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Updating entity for id " + entity.getId() + ", using a row mapper of type " + mapper.getClass().getName());
        }

        jdbcTemplate.update(query.toString(), parameters);
    }
}
