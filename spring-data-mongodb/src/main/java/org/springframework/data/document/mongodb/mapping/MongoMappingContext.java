/*
 * Copyright (c) 2011 by the original author(s).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.document.mongodb.mapping;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Collection;
import org.springframework.data.mapping.BasicMappingContext;
import org.springframework.data.mapping.model.MappingConfigurationException;
import org.springframework.data.mapping.model.MappingContext;
import org.springframework.data.mapping.model.PersistentEntity;
import org.springframework.data.mapping.model.PersistentProperty;
import org.springframework.data.util.TypeInformation;

/**
 * @author Jon Brisbin <jbrisbin@vmware.com>
 * @author Oliver Gierke
 */
public class MongoMappingContext extends BasicMappingContext {

  /* (non-Javadoc)
   * @see org.springframework.data.mapping.BasicMappingContext#getPersistentEntities()
   */
  @Override
  public Collection<MongoPersistentEntity<?>> getPersistentEntities() {
    return (Collection<MongoPersistentEntity<?>>) super.getPersistentEntities();
  }

  @Override
  public PersistentProperty createPersistentProperty(Field field, PropertyDescriptor descriptor,
      TypeInformation information) throws MappingConfigurationException {
    return new MongoPersistentProperty(field, descriptor, information);
  }

  @Override
  public <T> PersistentEntity<T> createPersistentEntity(TypeInformation typeInformation, MappingContext mappingContext)
      throws MappingConfigurationException {
    return new MongoPersistentEntity<T>(mappingContext, typeInformation);
  }
}
