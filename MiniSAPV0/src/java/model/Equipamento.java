package model;

public class Equipamento {
    private int id, localId;  
    private String nome, localNome; 

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
     * @return the localId
     */
    public int getLocalId() {
        return localId;
    }

    /**
     * @param localId the localId to set
     */
    public void setLocalId(int localId) {
        this.localId = localId;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the localNome
     */
    public String getLocalNome() {
        return localNome;
    }

    /**
     * @param localNome the localNome to set
     */
    public void setLocalNome(String localNome) {
        this.localNome = localNome;
    }

   
}
