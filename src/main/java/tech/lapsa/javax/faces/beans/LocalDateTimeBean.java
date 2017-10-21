package tech.lapsa.javax.faces.beans;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import tech.lapsa.java.commons.time.MyTemporals;

@Named("localDateTime")
@ApplicationScoped
public class LocalDateTimeBean extends ATemporalBean<LocalDateTime> {

    public LocalDateTimeBean() {
	super(MyTemporals.getInstance().forLocalDateTime());
    }
}
