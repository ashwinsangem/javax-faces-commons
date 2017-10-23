package tech.lapsa.javax.faces.beans.temporal;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import tech.lapsa.java.commons.time.MyTemporals;

@Named("date")
@ApplicationScoped
public class DateBean extends ATemporalBean<Date> {

    public DateBean() {
	super(MyTemporals.date());
    }
}
