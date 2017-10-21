package tech.lapsa.javax.faces.beans.localization;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.localization.Localized;
import tech.lapsa.javax.faces.utility.Facess;

@Named("localized")
@ApplicationScoped
public class LocalizedBean {

    public String regular(Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> x.regular(Facess.getLocale())) //
		.orElse(null);
    }

    public String few(Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> x.few(Facess.getLocale())) //
		.orElse(null);
    }

    public String full(Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> x.full(Facess.getLocale())) //
		.orElse(null);
    }

}
