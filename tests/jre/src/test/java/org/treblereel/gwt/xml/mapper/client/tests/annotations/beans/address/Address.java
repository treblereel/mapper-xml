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
package org.treblereel.gwt.xml.mapper.client.tests.annotations.beans.address;

import jakarta.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

/** @author Dmitrii Tikhomirov Created by treblereel 4/2/20 */
public class Address {

  @XmlAttribute private String street;

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Address)) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(getStreet(), address.getStreet());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getStreet());
  }

  @Override
  public String toString() {
    return "Address{" + "street='" + street + '\'' + '}';
  }
}
