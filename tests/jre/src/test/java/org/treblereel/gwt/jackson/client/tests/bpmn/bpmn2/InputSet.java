/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
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

package org.treblereel.gwt.jackson.client.tests.bpmn.bpmn2;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dataInput", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL")
public class InputSet implements Data {

  @XmlElement(name = "dataInputRefs", namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL")
  private List<String> set;

  public List<String> getSet() {
    return set;
  }

  public void setSet(List<String> set) {
    this.set = set;
  }
}
