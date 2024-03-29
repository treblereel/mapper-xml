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
package org.treblereel.gwt.xml.mapper.client.tests.annotations.seealso;

import jakarta.xml.bind.annotation.XmlSeeAlso;
import java.util.Objects;

/** @author Dmitrii Tikhomirov Created by treblereel 7/2/20 */
@XmlSeeAlso({Cat.class, Dog.class})
public class Animal {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Animal)) {
      return false;
    }
    Animal animal = (Animal) o;
    return Objects.equals(getName(), animal.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
