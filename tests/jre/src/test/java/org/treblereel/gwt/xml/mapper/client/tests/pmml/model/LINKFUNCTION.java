/*
 * Copyright © 2021 Treblereel
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

package org.treblereel.gwt.xml.mapper.client.tests.pmml.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import jsinterop.annotations.JsType;

/**
 * Java class for LINK-FUNCTION.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="LINK-FUNCTION"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="cloglog"/&gt;
 *     &lt;enumeration value="identity"/&gt;
 *     &lt;enumeration value="log"/&gt;
 *     &lt;enumeration value="logc"/&gt;
 *     &lt;enumeration value="logit"/&gt;
 *     &lt;enumeration value="loglog"/&gt;
 *     &lt;enumeration value="negbin"/&gt;
 *     &lt;enumeration value="oddspower"/&gt;
 *     &lt;enumeration value="power"/&gt;
 *     &lt;enumeration value="probit"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "LINK-FUNCTION")
@XmlEnum
@JsType
public enum LINKFUNCTION {
  @XmlEnumValue("cloglog")
  CLOGLOG("cloglog"),
  @XmlEnumValue("identity")
  IDENTITY("identity"),
  @XmlEnumValue("log")
  LOG("log"),
  @XmlEnumValue("logc")
  LOGC("logc"),
  @XmlEnumValue("logit")
  LOGIT("logit"),
  @XmlEnumValue("loglog")
  LOGLOG("loglog"),
  @XmlEnumValue("negbin")
  NEGBIN("negbin"),
  @XmlEnumValue("oddspower")
  ODDSPOWER("oddspower"),
  @XmlEnumValue("power")
  POWER("power"),
  @XmlEnumValue("probit")
  PROBIT("probit");
  private final String value;

  LINKFUNCTION(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static LINKFUNCTION fromValue(String v) {
    for (LINKFUNCTION c : LINKFUNCTION.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
