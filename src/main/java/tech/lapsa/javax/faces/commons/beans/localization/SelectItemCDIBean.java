package tech.lapsa.javax.faces.commons.beans.localization;

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
import tech.lapsa.javax.faces.commons.MyFaces;

@Named("si")
@ApplicationScoped
public class SelectItemCDIBean {

    public static abstract class FromType<T> {
	private final Function<T, Optional<Stream<Localized>>> starter;

	private FromType(final Function<T, Optional<Stream<Localized>>> starter) {
	    this.starter = MyObjects.requireNonNull(starter, "starter");
	}

	public List<SelectItem> regular(final T entities) {
	    return starter.apply(entities) //
		    .orElseGet(Stream::empty) //
		    .map(SelectItemCDIBean::regular) //
		    .collect(MyCollectors.unmodifiableList());
	}

	public List<SelectItem> full(final T entities) {
	    return starter.apply(entities) //
		    .orElseGet(Stream::empty) //
		    .map(SelectItemCDIBean::full) //
		    .collect(MyCollectors.unmodifiableList());
	}

	public List<SelectItem> few(final T entities) {
	    return starter.apply(entities) //
		    .orElseGet(Stream::empty) //
		    .map(SelectItemCDIBean::few) //
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

    public static class FromSingle extends FromType<Localized> {
	public FromSingle() {
	    super(x -> MyOptionals.of(x).map(Stream::of));
	}
    }

    private final FromArray fromArray = new FromArray();
    private final FromList fromList = new FromList();
    private final FromSingle fromSingle = new FromSingle();

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

    public FromSingle getSingle() {
	return fromSingle;
    }

    public FromSingle getFromSingle() {
	return fromSingle;
    }

    // PRIVATE

    private static SelectItem regular(final Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> new SelectItem(x, x.regular(MyFaces.getLocale()))) //
		.orElse(null);
    }

    private static SelectItem full(final Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> new SelectItem(x, x.full(MyFaces.getLocale()))) //
		.orElse(null);
    }

    private static SelectItem few(final Localized entity) {
	return MyOptionals.of(entity) //
		.map(x -> new SelectItem(x, x.few(MyFaces.getLocale()))) //
		.orElse(null);
    }
}
