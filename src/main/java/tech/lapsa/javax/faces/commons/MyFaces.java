package tech.lapsa.javax.faces.utility;

import java.util.Locale;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import tech.lapsa.java.commons.function.MyOptionals;

public final class Facess {
    private Facess() {
    }

    public static Locale getLocale() {
	Locale locale = MyOptionals.of(FacesContext.getCurrentInstance())
		.map(FacesContext::getViewRoot)
		.map(UIViewRoot::getLocale)
		.orElseThrow(() -> new IllegalStateException("Not in JSF context"));
	return locale;
    }
}
