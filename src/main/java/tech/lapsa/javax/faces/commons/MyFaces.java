package tech.lapsa.javax.faces.commons;

import java.util.Locale;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import tech.lapsa.java.commons.function.MyOptionals;

public final class MyFaces {
    private MyFaces() {
    }

    public static Locale getLocale() {
	final Locale locale = MyOptionals.of(FacesContext.getCurrentInstance())
		.map(FacesContext::getViewRoot)
		.map(UIViewRoot::getLocale)
		.orElseThrow(() -> new IllegalStateException("Not in JSF context"));
	return locale;
    }
}
