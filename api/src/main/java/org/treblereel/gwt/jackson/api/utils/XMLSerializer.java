package org.treblereel.gwt.jackson.api.utils;

import elemental2.dom.Node;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/18/20
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class XMLSerializer {

    public native String serializeToString(Node node);
}
