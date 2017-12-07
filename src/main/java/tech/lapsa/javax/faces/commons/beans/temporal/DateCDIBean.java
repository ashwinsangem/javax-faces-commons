package tech.lapsa.javax.faces.commons.beans.temporal;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import tech.lapsa.java.commons.time.MyTemporals;

@Named("date")
@ApplicationScoped
public class DateCDIBean extends ATemporalCDIBean<Date> {

    public DateCDIBean() {
	super(MyTemporals.date());
    }
}
