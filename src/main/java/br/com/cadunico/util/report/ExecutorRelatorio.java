package br.com.cadunico.util.report;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.jdbc.Work;

public class ExecutorRelatorio implements Work {

	private String caminhoRelatorio;
	private HttpServletResponse response;
	private Map<String, Object> parametros;
	private String nomeArquivoSaida;

	public ExecutorRelatorio(String caminhoRelatorio, HttpServletResponse response, Map<String, Object> parametros,
			String nomeArquivoSaida) {

			this.caminhoRelatorio = caminhoRelatorio;
			this.response = response;
			this.parametros = parametros;
			this.nomeArquivoSaida = nomeArquivoSaida;
	}

	@Override
	public void execute(Connection conexao) throws SQLException {

	}

}
