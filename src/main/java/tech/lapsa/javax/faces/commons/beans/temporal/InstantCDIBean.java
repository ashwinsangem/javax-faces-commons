package tech.lapsa.javax.faces.commons.beans.temporal;

import java.time.Instant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import tech.lapsa.java.commons.time.MyTemporals;

@Named("instant")
@ApplicationScoped
public class InstantCDIBean extends ATemporalCDIBean<Instant> {

    public InstantCDIBean() {
	super(MyTemporals.instant());
    }
}
