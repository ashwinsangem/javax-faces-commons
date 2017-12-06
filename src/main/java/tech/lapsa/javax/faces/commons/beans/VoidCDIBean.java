package tech.lapsa.javax.faces.beans.localization;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.FacesEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named("void")
@Dependent
public class VoidBean implements Serializable {
    private static final long serialVersionUID = -1667664768981313908L;

    public String doVoid() {
	return null;
    }

    public void onVoid() {
    }

    public void onVoidFacesEvent(FacesEvent event) {
    }

    public void onVoidValueChangeEvent(ValueChangeEvent event) {
    }

    public void onVoidAjaxBehaviorEvent(AjaxBehaviorEvent event) {
    }
}
