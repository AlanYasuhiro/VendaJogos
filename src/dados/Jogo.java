package dados;

public class Jogo {
	private String cod, nomeJogo, plataforma, classificacao, desenvolvedor, idioma, legenda, genero, fornecedor, garantia, preco, quantidade, obs, caminho;
	
	public Jogo(String pcod, String pnomeJogo, String pplataforma, String pclassificacao, String pdesenvolvedor, String pidioma, String plegenda, String pgenero, String pfornecedor, String pgarantia, String ppreco, String pquantidade, String pobs, String pcaminho){
		this.cod = pcod;
		this.nomeJogo = pnomeJogo;
		this.plataforma = pplataforma;
		this.classificacao = pclassificacao;
		this.desenvolvedor = pdesenvolvedor;
		this.idioma = pidioma;
		this.legenda = plegenda;
		this.genero = pgenero;
		this.fornecedor = pfornecedor;
		this.garantia = pgarantia;
		this.preco = ppreco;
		this.quantidade = pquantidade;
		this.obs = pobs;
		this.caminho = pcaminho;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNomeJogo() {
		return nomeJogo;
	}

	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	

}
