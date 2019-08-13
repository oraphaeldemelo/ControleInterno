package br.com.cadunico.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.cadunico.model.Endereco;
import br.com.cadunico.repository.EnderecoRepository;

@FacesConverter(forClass = Endereco.class, value="enderecoConverter")
public class EnderecoConverter implements Converter {

	@Inject
	private EnderecoRepository repositorio;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Endereco retorno = null;

		if (value != null) {
			retorno = repositorio.porId(new Long(value));

		}
		return retorno;

	} 

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {

			Long codigo = ((Endereco) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}
		return "";
	}

}
