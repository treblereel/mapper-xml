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
package org.treblereel.gwt.jackson.client.tests.annotations.namespace.ci;

import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;
import org.treblereel.gwt.jackson.client.tests.annotations.namespace.cl.Name;

/** @author Dmitrii Tikhomirov Created by treblereel 4/28/20 */
@XMLMapper
@XmlRootElement(name = "_tutorial", namespace = "http://ns")
public class Tutorial {

  private int id;
  private List<Name> names;

  public Tutorial() {}

  public Tutorial(int id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getNames());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Tutorial)) {
      return false;
    }
    Tutorial tutorial = (Tutorial) o;
    return getId() == tutorial.getId() && Objects.equals(getNames(), tutorial.getNames());
  }

  public int getId() {
    return id;
  }

  public List<Name> getNames() {
    return names;
  }

  public void setNames(List<Name> names) {
    this.names = names;
  }

  public void setId(int id) {
    this.id = id;
  }
}
