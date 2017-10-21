package tech.lapsa.javax.faces.conerters;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import tech.lapsa.java.commons.function.MyObjects;

@FacesConverter(value = "localDateConverter", forClass = LocalDate.class)
public class LocalDateConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	if (MyObjects.isNull(value))
	    return null;
	try {
	    return LocalDate.parse(value);
	} catch (DateTimeParseException e) {
	    throw new ConverterException(e);
	}
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
	if (MyObjects.isNull(value))
	    return null;
	try {
	    return MyObjects.requireA(value, LocalDate.class, "value") //
		    .toString();
	} catch (IllegalArgumentException e) {
	    throw new ConverterException(e);
	}
    }
}
