package org.bpmn.dc;

import javax.xml.bind.annotation.JacksonXmlProperty;

import com.google.common.base.Objects;
import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/6/20
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bounds)) {
            return false;
        }
        Bounds bounds = (Bounds) o;
        return Double.compare(bounds.getHeight(), getHeight()) == 0 &&
                Double.compare(bounds.getWidth(), getWidth()) == 0 &&
                Double.compare(bounds.getX(), getX()) == 0 &&
                Double.compare(bounds.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getHeight(), getWidth(), getX(), getY());
    }

    @Override
    public String toString() {
        return "Bounds{" +
                "height=" + height +
                ", width=" + width +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
