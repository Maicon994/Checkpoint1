package br.ulbra.model;

public class Chamado {

    private int id;
    private String solicitante;
    private String sala;
    private String equipamento_tag;
    private String problemaRelatado;
    private String dianosticoRelatado;
    private String prioridade;
    private String status;
    private String dataAbertura;

    public Chamado() {
    }

    public Chamado(int id, String solicitante, String sala, String equipamento_tag, String problemaRelatado, String dianosticoRelatado, String prioridade, String status, String dataAbertura) {
        this.id = id;
        this.solicitante = solicitante;
        this.sala = sala;
        this.equipamento_tag = equipamento_tag;
        this.problemaRelatado = problemaRelatado;
        this.dianosticoRelatado = dianosticoRelatado;
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

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getEquipamento_tag() {
        return equipamento_tag;
    }

    public void setEquipamento_tag(String equipamento_tag) {
        this.equipamento_tag = equipamento_tag;
    }

    public String getProblemaRelatado() {
        return problemaRelatado;
    }

    public void setProblemaRelatado(String problemaRelatado) {
        this.problemaRelatado = problemaRelatado;
    }

    public String getDianosticoRelatado() {
        return dianosticoRelatado;
    }

    public void setDianosticoRelatado(String dianosticoRelatado) {
        this.dianosticoRelatado = dianosticoRelatado;
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
    

}
