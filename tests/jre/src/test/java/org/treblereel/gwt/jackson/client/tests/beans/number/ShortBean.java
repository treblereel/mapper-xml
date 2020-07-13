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
package org.treblereel.gwt.jackson.client.tests.beans.number;

import java.util.Objects;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/** @author Dmitrii Tikhomirov Created by treblereel 3/27/20 */
@XMLMapper
public class ShortBean {

  private Short val;

  public Short getVal() {
    return val;
  }

  public void setVal(Short val) {
    this.val = val;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ShortBean)) {
      return false;
    }
    ShortBean shortBean = (ShortBean) o;
    return Objects.equals(getVal(), shortBean.getVal());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getVal());
  }
}
