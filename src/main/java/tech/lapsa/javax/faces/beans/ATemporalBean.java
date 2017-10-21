package tech.lapsa.javax.faces.beans;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import tech.lapsa.java.commons.time.MyTemporals.TemporalUtil;

public abstract class ATemporalBean<T> {

    private final TemporalUtil<T> util;

    protected ATemporalBean(TemporalUtil<T> util) {
	this.util = util;
    }

    public LocalDate toLocalDate(T value) {
	return util.toLocalDate(value);
    }

    public Instant toInstant(T value) {
	return util.toInstant(value);
    }

    public LocalDateTime toLocalDateTime(T value) {
	return util.toLocalDateTime(value);
    }

    public T getNow() {
	return util.now();
    }

    public Date toDate(T value) {
	return util.toDate(value);
    }

    public boolean isToday(T value) {
	return util.isToday(value);
    }

    public boolean isYesterday(T value) {
	return util.isYesterday(value);
    }

    public boolean isTommorow(T value) {
	return util.isTommorow(value);
    }
}
