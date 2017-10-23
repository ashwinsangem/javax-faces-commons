package tech.lapsa.javax.faces.beans.temporal;

import java.time.Instant;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import tech.lapsa.java.commons.time.MyTemporals;

@Named("instant")
@ApplicationScoped
public class InstantBean extends ATemporalBean<Instant> {

    public InstantBean() {
	super(MyTemporals.instant());
    }
}
