package tech.lapsa.javax.faces.commons.beans;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.FacesEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named("void")
@Dependent
public class VoidCDIBean implements Serializable {
    private static final long serialVersionUID = -1667664768981313908L;

    public String doVoid() {
	return null;
    }

    public void onVoid() {
    }

    public void onVoidFacesEvent(final FacesEvent event) {
    }

    public void onVoidValueChangeEvent(final ValueChangeEvent event) {
    }

    public void onVoidAjaxBehaviorEvent(final AjaxBehaviorEvent event) {
    }
}
