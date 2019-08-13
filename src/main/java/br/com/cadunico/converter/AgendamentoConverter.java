package br.com.cadunico.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.cadunico.model.AgendamentoVisitas;
import br.com.cadunico.repository.AgendamentoRepository;

@FacesConverter(forClass = AgendamentoVisitas.class)
public class AgendamentoConverter implements Converter {

	@Inject
	private AgendamentoRepository repositorio;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		AgendamentoVisitas retorno = null;
		
		if (value != null && !value.equals("")) {

			retorno = repositorio.porId(new Long(value));

		}
		return retorno;

	} 

	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null && !value.equals("")) {
			
			Long codigo = ((AgendamentoVisitas) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}
		return "";
	}

}
