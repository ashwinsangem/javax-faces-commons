package tech.lapsa.javax.faces.commons.beans.temporal;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import tech.lapsa.java.commons.time.MyTemporals;

@Named("localDateTime")
@ApplicationScoped
public class LocalDateTimeCDIBean extends ATemporalCDIBean<LocalDateTime> {

    public LocalDateTimeCDIBean() {
	super(MyTemporals.localDateTime());
    }
}
