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

package org.treblereel.gwt.xml.mapper.client.tests.annotations.namespace.test2;

import jakarta.xml.bind.annotation.XmlRootElement;

/** @author Dmitrii Tikhomirov Created by treblereel 10/4/20 */
@XmlRootElement(namespace = "http://www.ci")
public class NSTest2 {

  private String value2;

  public String getValue2() {
    return value2;
  }

  public void setValue2(String value2) {
    this.value2 = value2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof NSTest2)) return false;

    NSTest2 nsTest2 = (NSTest2) o;

    return getValue2() != null
        ? getValue2().equals(nsTest2.getValue2())
        : nsTest2.getValue2() == null;
  }

  @Override
  public int hashCode() {
    return getValue2() != null ? getValue2().hashCode() : 0;
  }
}
