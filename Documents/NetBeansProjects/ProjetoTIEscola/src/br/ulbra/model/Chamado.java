package br.ulbra.model;

public class Chamado {

    private int id;
    private Usuario usuario;
    private Equipamento equipamento;
    private String problemaRelatado;
    private String diagnosticoTecnico;
    private String prioridade;
    private String status;
    private String dataAbertura;

    public Chamado() {
    }

    public Chamado(int id,String problemaRelatado, String diagnosticoTecnico,
            String prioridade, String status, String dataAbertura) {

        this.id = id;
        this.problemaRelatado = problemaRelatado;
        this.diagnosticoTecnico = diagnosticoTecnico;
        this.prioridade = prioridade;
        this.status = status;
        this.dataAbertura = dataAbertura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProblemaRelatado() {
        return problemaRelatado;
    }

    public void setProblemaRelatado(String problemaRelatado) {
        this.problemaRelatado = problemaRelatado;
    }

    public String getDiagnosticoTecnico() {
        return diagnosticoTecnico;
    }

    public void setDiagnosticoTecnico(String diagnosticoTecnico) {
        this.diagnosticoTecnico = diagnosticoTecnico;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
public Usuario getUsuario() {
    return usuario;
}

public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
}

public Equipamento getEquipamento() {
    return equipamento;
}

public void setEquipamento(Equipamento equipamento) {
    this.equipamento = equipamento;
}

}
