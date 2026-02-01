package beans;

public class Area {

    private int id;
    private String nomeArea;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeArea() {
        return nomeArea;
    }

    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    @Override
    public String toString() {
        return this.nomeArea; // ou nomeProcesso / nomeUsuario
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Area other = (Area) obj;
        return this.id == other.getId();
    }

}
