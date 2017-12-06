package tech.lapsa.javax.faces.commons.beans.temporal;

import java.time.LocalDate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import tech.lapsa.java.commons.time.MyTemporals;

@Named("localDate")
@ApplicationScoped
public class LocalDateCDIBean extends ATemporalCDIBean<LocalDate> {

    public LocalDateCDIBean() {
	super(MyTemporals.localDate());
    }
}
