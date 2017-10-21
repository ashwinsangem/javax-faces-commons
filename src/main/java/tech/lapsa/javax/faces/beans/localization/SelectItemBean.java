package tech.lapsa.javax.faces.beans.localization;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import tech.lapsa.java.commons.function.MyCollectors;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.localization.Localized;
import tech.lapsa.javax.faces.utility.Facess;

@Named("si")
@ApplicationScoped
public class SelectItemBean {

    private static class FromType<T> {
	private final Function<T, Optional<Stream<Localized>>> beginner;

	private FromType(Function<T, Optional<Stream<Localized>>> beginner) {
	    this.beginner = MyObjects.requireNonNull(beginner, "beginner");
	}

	public List<SelectItem> regular(T entities) {
	    return beginner.apply(entities) //
		    .orElseGet(Stream::empty) //
		    .map(SelectItemBean::regular) //
		    .collect(MyCollectors.unmodifiableList());
	}

	public List<SelectItem> full(T entities) {
	    return beginner.apply(entities) //
		    .orElseGet(Stream::empty) //
		    .map(SelectItemBean::full) //
		    .collect(MyCollectors.unmodifiableList());
	}

	public List<SelectItem> few(T entities) {
	    return beginner.apply(entities) //
		    .orElseGet(Stream::empty) //
		    .map(SelectItemBean::few) //
		    .collect(MyCollectors.unmodifiableList());
	}
    }

    public static class FromArray extends FromType<Localized[]> {
	public FromArray() {
	    super(x -> MyOptionals.streamOf(x));
	}
    }

    public static class FromList extends FromType<List<Localized>> {
	public FromList() {
	    super(x -> MyOptionals.streamOf(x));
	}
    }

    private FromArray fromArray = new FromArray();
    private FromList fromList = new FromList();

    public FromArray getArray() {
	return fromArray;
    }

    public FromArray getFromArray() {
	return fromArray;
    }

    public FromList getList() {
	return fromList;
    }

    public FromList getFromList() {
	return fromList;
    }

    // PRIVATE

    private static SelectItem regular(Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> new SelectItem(x, x.regular(Facess.getLocale()))) //
		.orElse(null);
    }

    private static SelectItem full(Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> new SelectItem(x, x.full(Facess.getLocale()))) //
		.orElse(null);
    }

    private static SelectItem few(Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> new SelectItem(x, x.few(Facess.getLocale()))) //
		.orElse(null);
    }
}
