package tech.lapsa.javax.faces.commons.conerters;

import java.util.Currency;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "currencyConverter", forClass = Currency.class)
public class CurrencyConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
	return string == null ? null : Currency.getInstance(string);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object currency) {
	try {
	    return currency != null ? ((Currency)currency).getCurrencyCode() : null;
	} catch (ClassCastException e) {
	    throw new ConverterException(Currency.class.getName() + " expected");
	}
    }

}
