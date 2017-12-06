package tech.lapsa.javax.faces.beans.temporal;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import tech.lapsa.java.commons.time.MyTemporals;

@Named("localDate")
@ApplicationScoped
public class LocalDateBean extends ATemporalBean<LocalDate> {

    public LocalDateBean() {
	super(MyTemporals.localDate());
    }
}
