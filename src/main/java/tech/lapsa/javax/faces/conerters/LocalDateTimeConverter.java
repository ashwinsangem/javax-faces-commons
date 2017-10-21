package tech.lapsa.javax.faces.conerters;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import tech.lapsa.java.commons.function.MyObjects;

@FacesConverter(value = "localDateTimeConverter", forClass = LocalDateTime.class)
public class LocalDateTimeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	if (MyObjects.isNull(value))
	    return null;
	try {
	    return LocalDateTime.parse(value);
	} catch (DateTimeParseException e) {
	    throw new ConverterException(e);
	}
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
	if (MyObjects.isNull(value))
	    return null;
	try {
	    return MyObjects.requireA(value, LocalDateTime.class, "value") //
		    .toString();
	} catch (IllegalArgumentException e) {
	    throw new ConverterException(e);
	}
    }
}
