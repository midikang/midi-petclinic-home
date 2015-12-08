package com.midi.samples.petclinic.util;

import java.util.Collection;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.midi.samples.petclinic.model.BaseEntity;

/**
 * 
 * Utility method for handling entities.
 * Separate from the BaseEntity class mainly because of dependency
 * on the ORM-associated ObjectRetrievalFailureException.
 * @author ad
 *
 */
public abstract class EntityUtils {
	
	public static <T extends BaseEntity> T getById(Collection<T> entities, Class<T> entityClass, int entityId) 
		throws ObjectRetrievalFailureException {
		for (T entity : entities) {
			if (entity.getId() == entityId && entityClass.isInstance(entityClass)) {
				return entity;
			}
		}
		throw new ObjectRetrievalFailureException(entityClass,entityId);
	}

}
