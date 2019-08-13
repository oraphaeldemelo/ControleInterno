package br.com.cadunico.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cadunico.model.Usuario;
import br.com.cadunico.repository.CadastroUsuarioRepository;
import br.com.cadunico.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	@Inject
	private CadastroUsuarioRepository repositorio;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;
		
		if (value != null && !value.equals("")) {
			System.out.println("VALOR DO VALUE É: " + value);
		//	Long id = new Long(value);

			retorno = repositorio.porId(new Long(value));

		}
		return retorno;

	} //problema com esse converter

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			
			Long codigo = ((Usuario) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}
		return "";
	}

}
