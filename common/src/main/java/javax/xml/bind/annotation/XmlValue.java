/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2004-2017 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package javax.xml.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Enables mapping a class to a XML Schema complex type with a simpleContent or a XML Schema simple
 * type.
 *
 * <p>Usage:
 *
 * <p>The @XmlValue annotation can be used with the following program elements:
 *
 * <p>a JavaBean property.
 *
 * <p>non static, non transient field.
 *
 * <p>See "Package Specification" in javax.xml.bind.package javadoc for additional common
 * information.
 *
 * <p>The usage is subject to the following usage constraints:
 *
 * <p>At most one field or property can be annotated with the @XmlValue annotation.
 *
 * <p>If the type of the field or property is a collection type, then the collection item type must
 * map to a simple schema type.
 *
 * <p>If the type of the field or property is not a collection type, then the type must map to a XML
 * Schema simple type.
 *
 * <p>If the annotated JavaBean property is the sole class member being mapped to XML Schema
 * construct, then the class is mapped to a simple type.
 *
 * <p>If there are additional JavaBean properties (other than the JavaBean property annotated
 * with @XmlValue annotation) that are mapped to XML attributes, then the class is mapped to a
 * complex type with simpleContent.
 *
 * <p>Example 1: Map a class to XML Schema simpleType
 *
 * <p>// Example 1: Code fragment public class USPrice { @XmlValue public java.math.BigDecimal
 * price; }
 * <!-- Example 1: XML Schema fragment -->
 * <xs:simpleType name="USPrice"> <xs:restriction base="xs:decimal"/> </xs:simpleType>
 *
 * <p>Example 2: Map a class to XML Schema complexType with with simpleContent.
 *
 * <p>// Example 2: Code fragment public class InternationalPrice { @XmlValue public
 * java.math.BigDecimal price; @XmlAttribute public String currency; }
 * <!-- Example 2: XML Schema fragment -->
 * <xs:complexType name="InternationalPrice"> <xs:simpleContent> <xs:extension base="xs:decimal">
 * <xs:attribute name="currency" type="xs:string"/> </xs:extension> </xs:simpleContent>
 * </xs:complexType>
 *
 * @see XmlType
 * @since JAXB2.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface XmlValue {}
