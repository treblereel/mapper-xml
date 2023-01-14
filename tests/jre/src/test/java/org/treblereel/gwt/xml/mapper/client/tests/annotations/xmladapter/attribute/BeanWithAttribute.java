/*
 * Copyright © 2021
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

package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmladapter.attribute;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Objects;
import org.treblereel.gwt.xml.mapper.api.annotation.XMLMapper;

@XMLMapper
public class BeanWithAttribute {

  @XmlAttribute
  @XmlJavaTypeAdapter(BeanWithAttributeAdapter.class)
  private AttributeObject value;

  public BeanWithAttribute() {}

  public BeanWithAttribute(AttributeObject value) {
    this.value = value;
  }

  public AttributeObject getValue() {
    return value;
  }

  public void setValue(AttributeObject value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BeanWithAttribute)) {
      return false;
    }
    BeanWithAttribute that = (BeanWithAttribute) o;
    return Objects.equals(getValue(), that.getValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValue());
  }
}
