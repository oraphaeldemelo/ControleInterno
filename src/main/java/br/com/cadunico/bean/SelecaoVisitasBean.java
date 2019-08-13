package br.com.cadunico.bean;

public class SelecaoVisitasBean{
	
	//CLASSE NÃO CONCLUÍDA, FALTA FINALIZAR
/*
	private static final long serialVersionUID = 1L;

	@Inject
	private AgendamentoRepository repositorio;

	
	private FacesContext facesContext;

	
	private HttpServletResponse response;

	@Inject
	private EntityManager em;

	private List<AgendamentoVisitas> visitasEscolhidas;

	private List<AgendamentoVisitas> visitasSede;
	private List<AgendamentoVisitas> visitasRural;

	@PostConstruct
	public void init() {
		visitasSede = repositorio.listarSede();
		visitasRural = repositorio.listarRural();

	}

	public void imprimir() throws SQLException {
		/*
		 * Map<String, Object> parametros = new HashMap<String, Object>();
		 * parametros.put("visitasEscolhidas", this.visitasEscolhidas);
		 * 
		 * ExecutorRelatorio executor = new
		 * ExecutorRelatorio("/relatorios/Lista_Visitas.jasper", this.response,
		 * parametros, "Lista de Visitas.pdf"); Session sessao =
		 * em.unwrap(Session.class); sessao.doWork(executor);
		 
		boolean relatorioGerado;

		this.facesContext = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

		InputStream stream = this.getClass().getResourceAsStream("/relatorios/Lista_Visitas.jasper");
		Map<String, Object> params = new HashMap<String, Object>();

		try {
			JasperPrint print = JasperFillManager.fillReport(stream, params,
					new JRBeanCollectionDataSource(visitasEscolhidas));
			relatorioGerado = print.getPages().size() > 0;

			if (relatorioGerado) {
				Exporter<ExporterInput, PdfReportConfiguration, PdfExporterConfiguration, OutputStreamExporterOutput> exportador = new JRPdfExporter();
				exportador.setExporterInput(new SimpleExporterInput(print));
				exportador.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
				
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline; filename=ListaAgendamento.pdf" );
				
				exportador.exportReport();
				
				facesContext.responseComplete();
			}

		} catch (Exception e) {
			throw new SQLException("Erro ao executar relatório, erro: " + e);
		}

	}

	public List<AgendamentoVisitas> getVisitasEscolhidas() {
		return visitasEscolhidas;
	}

	public void setVisitasEscolhidas(List<AgendamentoVisitas> visitasEscolhidas) {
		this.visitasEscolhidas = visitasEscolhidas;
	}

	public List<AgendamentoVisitas> getVisitasSede() {
		return visitasSede;
	}

	public List<AgendamentoVisitas> getVisitasRural() {
		return visitasRural;
	}*/

}
