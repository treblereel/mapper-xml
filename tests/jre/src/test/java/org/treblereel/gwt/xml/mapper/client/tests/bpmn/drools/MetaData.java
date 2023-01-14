/*
 * Copyright © 2020 Treblereel
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
package org.treblereel.gwt.xml.mapper.client.tests.bpmn.drools;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlCData;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/** @author Dmitrii Tikhomirov Created by treblereel 4/6/20 */
@XmlRootElement(name = "metaData", namespace = "http://www.jboss.org/drools")
public class MetaData {

  @XmlAttribute private String name;

  @XmlCData
  @XmlElement(name = "metaValue", namespace = "http://www.jboss.org/drools")
  private String metaValue;

  public MetaData() {}

  public MetaData(String name, String metaValue) {
    this.name = name;
    this.metaValue = metaValue;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMetaValue() {
    return metaValue;
  }

  public void setMetaValue(String metaValue) {
    this.metaValue = metaValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MetaData)) {
      return false;
    }
    MetaData metaData = (MetaData) o;
    return Objects.equals(getName(), metaData.getName())
        && Objects.equals(getMetaValue(), metaData.getMetaValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getMetaValue());
  }
}
