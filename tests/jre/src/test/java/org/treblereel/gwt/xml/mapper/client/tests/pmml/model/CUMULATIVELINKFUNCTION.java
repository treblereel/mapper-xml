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
 * Java class for CUMULATIVE-LINK-FUNCTION.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;simpleType name="CUMULATIVE-LINK-FUNCTION"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="logit"/&gt;
 *     &lt;enumeration value="probit"/&gt;
 *     &lt;enumeration value="cloglog"/&gt;
 *     &lt;enumeration value="loglog"/&gt;
 *     &lt;enumeration value="cauchit"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "CUMULATIVE-LINK-FUNCTION")
@XmlEnum
@JsType
public enum CUMULATIVELINKFUNCTION {
  @XmlEnumValue("logit")
  LOGIT("logit"),
  @XmlEnumValue("probit")
  PROBIT("probit"),
  @XmlEnumValue("cloglog")
  CLOGLOG("cloglog"),
  @XmlEnumValue("loglog")
  LOGLOG("loglog"),
  @XmlEnumValue("cauchit")
  CAUCHIT("cauchit");
  private final String value;

  CUMULATIVELINKFUNCTION(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static CUMULATIVELINKFUNCTION fromValue(String v) {
    for (CUMULATIVELINKFUNCTION c : CUMULATIVELINKFUNCTION.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }
}
