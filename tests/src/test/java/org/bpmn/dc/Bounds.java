package org.bpmn.dc;

import javax.xml.bind.annotation.JacksonXmlProperty;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
@XMLMapper
public class Bounds {

    @JacksonXmlProperty(isAttribute = true)
    private double height;

    @JacksonXmlProperty(isAttribute = true)
    private double width;

    @JacksonXmlProperty(isAttribute = true)
    private double x;

    @JacksonXmlProperty(isAttribute = true)
    private double y;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
