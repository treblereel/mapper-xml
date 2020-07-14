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
package org.treblereel.gwt.jackson.client.tests.beans.iface;

import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElements;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/** @author Dmitrii Tikhomirov Created by treblereel 5/13/20 */
@XMLMapper
public class User implements IUser {

  private String user;

  @XmlElements({
    @XmlElement(name = "_Address1", type = Address.class),
    @XmlElement(name = "_Address2", type = Address2.class),
    @XmlElement(name = "_Address3", type = Address3.class)
  })
  private IAddress iAddress;

  @XmlElements({
    @XmlElement(name = "_Address1", type = Address.class),
    @XmlElement(name = "_Address2", type = Address2.class),
    @XmlElement(name = "_Address3", type = Address3.class)
  })
  private List<IAddress> iAddressList;

  @XmlElementRefs({
    @XmlElementRef(name = "_Address1", type = Address.class),
    @XmlElementRef(name = "_Address2", type = Address2.class),
    @XmlElementRef(name = "_Address3", type = Address3.class)
  })
  private List<IAddress> iAddressListRef;

  @XmlElementRefs({
    @XmlElementRef(name = "_Address1", type = Address.class),
    @XmlElementRef(name = "_Address2", type = Address2.class),
    @XmlElementRef(name = "_Address3", type = Address3.class)
  })
  private IAddress iAddressRef;

  public IAddress getIAddressRef() {
    return iAddressRef;
  }

  public void setIAddressRef(IAddress iAddressRef) {
    this.iAddressRef = iAddressRef;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUser(), iAddress, iAddressRef);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user1 = (User) o;
    return Objects.equals(getUser(), user1.getUser())
        && Objects.equals(iAddress, user1.iAddress)
        && Objects.equals(iAddressRef, user1.iAddressRef);
  }

  @Override
  public String getUser() {
    return user;
  }

  @Override
  public void setUser(String name) {
    this.user = name;
  }

  @Override
  public IAddress getIAddress() {
    return iAddress;
  }

  @Override
  public void setIAddress(IAddress address) {
    this.iAddress = address;
  }

  public List<IAddress> getIAddressList() {
    return iAddressList;
  }

  public void setIAddressList(List<IAddress> iAddressList) {
    this.iAddressList = iAddressList;
  }

  public List<IAddress> getIAddressListRef() {
    return iAddressListRef;
  }

  public void setIAddressListRef(List<IAddress> iAddressListRef) {
    this.iAddressListRef = iAddressListRef;
  }
}
