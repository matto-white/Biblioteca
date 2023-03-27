import java.util.ArrayList;
public class Biblioteca {
    /** ArrayList Contenetnte la lista dei libri */
    public ArrayList<Libro> lista;

    /** ArrayList Contenente la lista dei codici dei libri già usati*/
    public ArrayList<String> codiciusati;

    /**Costruttore di biblioteca*/
    public Biblioteca() {
         lista = new ArrayList<Libro>();
         codiciusati = new ArrayList<String>();
    }


    /** Metodo add della lista di libri */
    public void add (Libro obj){
        lista.add(obj);
    }

    /** Metodo rm per oggetto della lista di libri */
    public void rm (Libro obj){
        lista.remove(obj);
    }

    /** Metodo rm per indice della lista di libri */
    public void rm (int indice){
        lista.remove(indice);
    }

    /** Metodo size della lista di libri */
    public int size(){
        return lista.size();
    }

    /** Metodo get della lista di libri */
    public Libro get(int indice){
        return lista.get(indice);
    }


    /** Metodo add della lista di codici già usati */
    public void addcodici(String cod){
        codiciusati.add(cod);
    }

    /** Metodo rm per stringa della lista di codici già usati */
    public void rmcodici(String cod){
        codiciusati.remove(cod);
    }

    /** Metodo rm per indice della lista di codici già usati */
    public void rmcodici(int indice){
        codiciusati.remove(indice);
    }

    /** Metodo size della lista di codici già usati */
    public int sizecodici(){
        return codiciusati.size();
    }

    /** Metodo get della lista di codici già usati */
    public String getcodici(int indice){
        return codiciusati.get(indice);
    }


    /** Metodo unico per cercare per titolo, autore o codice. Restituisce un arraylist di interi contenente gli indici della posizione dei vari libri trovati */
    public ArrayList<Integer> cerca(String cosacercare, String paroladacercare){
        boolean error=false;
        ArrayList<Integer> indici = new ArrayList<Integer>();
        switch(cosacercare){
            case "titolo":
                for(int i=0; i<size(); i++) {
                    if (get(i).getTitolo().equals(paroladacercare)) {
                        indici.add(i);
                    }
                }
                break;
            case "autore":
                for(int i=0; i<size(); i++){
                    if(get(i).getAutore().equals(paroladacercare)){
                        indici.add(i);
                    }
                }
                break;
            case "codice":
                for(int i=0; i<size(); i++){
                    if(get(i).getCodice().equals(paroladacercare)){
                        indici.add(i);
                        i=size();
                    }
                }
                break;
            default:
                System.out.println("Errore nella selezione del tipo di ricerca");
                error=true;
        }
        return indici;
    }

    /** Metodo per cercare se un codice di un libro è già stato usato */
    public boolean giausato(String codice){
        boolean used=false;
        for(int i=0; i<sizecodici(); i++){
            if(getcodici(i).equals(codice)){
                used=true;
                i=sizecodici();
            }
        }
        return used;
    }
}
