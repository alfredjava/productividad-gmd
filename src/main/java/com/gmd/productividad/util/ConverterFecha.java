package com.gmd.productividad.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
@FacesConverter("com.gmd.productividad.util.ConverterFecha")
public class ConverterFecha implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		String fecha = "";
		if(arg2!=null)
			fecha= (new SimpleDateFormat("dd-MM-yyyy")).format((Date)arg2);
		else{
			fecha="";
		}
		return fecha;
	}

}
