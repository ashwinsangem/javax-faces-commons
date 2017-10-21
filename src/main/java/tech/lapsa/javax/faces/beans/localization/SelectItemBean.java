package tech.lapsa.javax.faces.beans.localization;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import tech.lapsa.java.commons.function.MyCollectors;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.localization.Localized;
import tech.lapsa.javax.faces.utility.Facess;

@Named("si")
@ApplicationScoped
public class SelectItemBean {

    @Named
    private LocalizedBean localized;

    public SelectItem regular(Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> new SelectItem(x, x.regular(Facess.getLocale()))) //
		.orElse(null);
    }

    public SelectItem full(Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> new SelectItem(x, x.full(Facess.getLocale()))) //
		.orElse(null);
    }

    public SelectItem few(Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> new SelectItem(x, x.few(Facess.getLocale()))) //
		.orElse(null);
    }

    public List<SelectItem> regular(Localized[] entity) {
	return from(entity, this::regular);
    }

    public List<SelectItem> selectItemFull(Localized[] entity) {
	return from(entity, this::full);
    }

    public List<SelectItem> selectItemFew(Localized[] entity) {
	return from(entity, this::few);
    }

    public List<SelectItem> regular(Collection<Localized> entity) {
	return from(entity, this::regular);
    }

    public List<SelectItem> selectItemFull(Collection<Localized> entity) {
	return from(entity, this::full);
    }

    public List<SelectItem> selectItemFew(Collection<Localized> entity) {
	return from(entity, this::few);
    }

    // PRIVATE

    private List<SelectItem> from(Localized[] entities, Function<Localized, SelectItem> funct) {
	return MyOptionals.streamOf(entities) //
		.orElseGet(Stream::empty) //
		.map(funct) //
		.collect(MyCollectors.unmodifiableList());
    }

    private List<SelectItem> from(Collection<Localized> entity, Function<Localized, SelectItem> funct) {
	return MyOptionals.streamOf(entity) //
		.orElseGet(Stream::empty) //
		.map(funct) //
		.collect(MyCollectors.unmodifiableList());
    }

}
