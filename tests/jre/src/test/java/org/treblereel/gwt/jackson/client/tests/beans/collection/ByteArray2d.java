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
package org.treblereel.gwt.jackson.client.tests.beans.collection;

import java.util.Arrays;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/** @author Dmitrii Tikhomirov Created by treblereel 3/29/20 */
@XMLMapper
public class ByteArray2d {

  public static final String XML =
      "<?xml version='1.0' encoding='UTF-8'?><ByteArray2d><array><array>AAsWIQ==</array><array>APXq3w==</array><array>AGScAA==</array><array>AAAAAA==</array></array></ByteArray2d>";

  private byte[][] array;

  public byte[][] getArray() {
    return array;
  }

  public void setArray(byte[][] array) {
    this.array = array;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ByteArray2d)) {
      return false;
    }
    ByteArray2d that = (ByteArray2d) o;
    return Arrays.equals(getArray(), that.getArray());
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(getArray());
  }
}
