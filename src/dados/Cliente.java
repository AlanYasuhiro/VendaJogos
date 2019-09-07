package dados;

public class Cliente {
	private String nome, endereco, num, cep, bairro, cidade, uf, email, telefone, dataNasc, sexo, cpf;
	
	public Cliente(String pnome, String pendereco, String pnum, String pcep, String pbairro, String pcidade, String puf, String pemail, String ptelefone, String pdataNasc, String psexo, String pcpf){
		this.nome = pnome;
		this.endereco = pendereco;
		this.num = pnum;
		this.cep = pcep;
		this.bairro = pbairro;
		this.cidade = pcidade;
		this.uf = puf;
		this.email = pemail;
		this.telefone = ptelefone;
		this.dataNasc = pdataNasc;
		this.sexo = psexo;
		this.cpf = pcpf;
	}
	

	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}


