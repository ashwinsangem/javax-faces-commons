package tech.lapsa.javax.faces.commons.beans.localization;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.localization.Localized;
import tech.lapsa.javax.faces.commons.MyFaces;

@Named("localized")
@ApplicationScoped
public class LocalizedCDIBean {

    public String regular(final Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> x.regular(MyFaces.getLocale())) //
		.orElse(null);
    }

    public String few(final Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> x.few(MyFaces.getLocale())) //
		.orElse(null);
    }

    public String full(final Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> x.full(MyFaces.getLocale())) //
		.orElse(null);
    }

}
