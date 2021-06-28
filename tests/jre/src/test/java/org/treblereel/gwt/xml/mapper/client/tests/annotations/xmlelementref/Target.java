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

package org.treblereel.gwt.xml.mapper.client.tests.annotations.xmlelementref;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import org.treblereel.gwt.xml.mapper.api.annotation.XMLMapper;

/** @author Dmitrii Tikhomirov Created by treblereel 6/21/21 */
@XMLMapper
@XmlRootElement(name = "target")
public class Target {

  @XmlElementRefs({
    @XmlElementRef(
        name = "JarTask",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = JarTask.class,
        required = false),
    @XmlElementRef(
        name = "JavacTask",
        namespace = "http://www.dmg.org/PMML-4_4",
        type = JavacTask.class,
        required = false),
  })
  private List<Task> tasks = new ArrayList<>();

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }
}
