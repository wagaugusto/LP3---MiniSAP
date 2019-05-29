package model;

public class Ordem {
    private int id, especialidadeId, notaId, equipamentoId;  
    private String titulo, descricao, especialidadeNome, notaTitulo, equipamentoNome; 

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
     * @return the especialidadeId
     */
    public int getEspecialidadeId() {
        return especialidadeId;
    }

    /**
     * @param especialidadeId the especialidadeId to set
     */
    public void setEspecialidadeId(int especialidadeId) {
        this.especialidadeId = especialidadeId;
    }

    /**
     * @return the notaId
     */
    public int getNotaId() {
        return notaId;
    }

    /**
     * @param notaId the notaId to set
     */
    public void setNotaId(int notaId) {
        this.notaId = notaId;
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
     * @return the especialidadeNome
     */
    public String getEspecialidadeNome() {
        return especialidadeNome;
    }

    /**
     * @param especialidadeNome the especialidadeNome to set
     */
    public void setEspecialidadeNome(String especialidadeNome) {
        this.especialidadeNome = especialidadeNome;
    }

    /**
     * @return the notaTitulo
     */
    public String getNotaTitulo() {
        return notaTitulo;
    }

    /**
     * @param notaTitulo the notaTitulo to set
     */
    public void setNotaTitulo(String notaTitulo) {
        this.notaTitulo = notaTitulo;
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
