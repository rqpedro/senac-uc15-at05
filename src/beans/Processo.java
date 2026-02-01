package beans;

public class Processo {

    private int id;
    private String nomeProcesso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProcesso() {
        return nomeProcesso;
    }

    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    @Override
    public String toString() {
        return this.nomeProcesso; // ou nomeProcesso / nomeUsuario
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;                  // mesma referência
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // checa tipo
        }
        Processo other = (Processo) obj;
        return this.id == other.getId();
    }

}
