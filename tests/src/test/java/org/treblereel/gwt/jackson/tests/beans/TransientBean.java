package org.treblereel.gwt.jackson.tests.beans;

import org.treblereel.gwt.jackson.api.annotation.XMLMapper;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 3/29/20
 */
@XMLMapper
public class TransientBean {

    public static final String XML = "<?xml version='1.0' encoding='UTF-8'?><TransientBean><saveMe>YEAP</saveMe></TransientBean>";

    private transient String dontSaveMe;
    private String saveMe;

    public String getSaveMe() {
        return saveMe;
    }

    public void setSaveMe(String saveMe) {
        this.saveMe = saveMe;
    }

    public String getDontSaveMe() {
        return dontSaveMe;
    }

    public void setDontSaveMe(String dontSaveMe) {
        this.dontSaveMe = dontSaveMe;
    }

}
