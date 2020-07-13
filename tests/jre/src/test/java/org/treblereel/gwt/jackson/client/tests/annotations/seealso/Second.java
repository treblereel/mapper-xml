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
package org.treblereel.gwt.jackson.client.tests.annotations.seealso;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/** @author Dmitrii Tikhomirov Created by treblereel 7/1/20 */
@XmlRootElement
public class Second extends Foo {

  private String test2;

  public String getTest2() {
    return test2;
  }

  public void setTest2(String test2) {
    this.test2 = test2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Second)) {
      return false;
    }
    Second second = (Second) o;
    return Objects.equals(getTest2(), second.getTest2());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTest2());
  }
}
