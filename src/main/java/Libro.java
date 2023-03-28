public class Libro {
    private String titolo, autore, codice;
    Boolean prestito = false;

    public Libro() {
    }

    public Libro(String titolo, String autore, String codice) {
        this.titolo = titolo;
        this.autore = autore;
        this.codice = codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Boolean getPrestito() {
        return prestito;
    }

    public void setPrestito(Boolean prestito) {
        this.prestito = prestito;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", codice='" + codice + '\'' +
                ", prestito='" + prestito + '\'' +
                '}' + "\n";
    }
}
