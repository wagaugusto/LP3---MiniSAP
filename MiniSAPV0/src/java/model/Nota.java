package model;

public class Nota {
    private int id, equipamentoId;  
    private String titulo, descricao, equipamentoNome; 

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the equipamentoId
     */
    public int getEquipamentoId() {
        return equipamentoId;
    }

    /**
     * @param equipamentoId the equipamentoId to set
     */
    public void setEquipamentoId(int equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the equipamentoNome
     */
    public String getEquipamentoNome() {
        return equipamentoNome;
    }

    /**
     * @param equipamentoNome the equipamentoNome to set
     */
    public void setEquipamentoNome(String equipamentoNome) {
        this.equipamentoNome = equipamentoNome;
    }
    
}
