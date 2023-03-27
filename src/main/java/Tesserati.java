import java.util.ArrayList;
public class Tesserati {

    /**Arraylist contenente la lista dei tesserati*/
    public ArrayList<Persona> lista;

    /**Arraylist contenente la lista delle matricole già usate*/
    public ArrayList<String> matricoleusate;

    public Tesserati() {
        lista = new ArrayList<Persona>();
        matricoleusate = new ArrayList<String>();
    }
    public void add (Persona obj){
        lista.add(obj);
    }
    public void addmatricole (String mat){
        matricoleusate.add(mat);
    }
    public void rm (Persona obj){
        lista.remove(obj);
    }
    public void rmmatricole (String mat){
        matricoleusate.remove(mat);
    }
    public void rm (int indice){
        lista.remove(indice);
    }
    public void rmmatricole (int indice){
        matricoleusate.remove(indice);
    }
    public int size(){
        return lista.size();
    }
    public int sizematricole(){
        return matricoleusate.size();
    }
    public Persona get(int indice){
        return lista.get(indice);
    }
    public String getmatricole(int indice){
        return matricoleusate.get(indice);
    }

    /** Metodo per cercare se la matricola di un tesserato è già stata usata */
    public boolean giausato(String matricola){
        boolean used=false;
        for(int i=0; i<sizematricole(); i++){
            if(getmatricole(i).equals(matricola)){
                used=true;
                i=sizematricole();
            }
        }
        return used;
    }

    /** Metodo unico per cercare per nome, cognome o matricola. Restituisce un arraylist di interi contenente gli indici della posizione dei vari tesserati trovati */
    public ArrayList<Integer> cerca(String cosacercare, String paroladacercare){
        boolean error=false;
        ArrayList<Integer> indici = new ArrayList<Integer>();
        switch(cosacercare){
            case "nome":
                for(int i=0; i<size(); i++) {
                    if (get(i).getNome().equals(paroladacercare)) {
                        indici.add(i);
                    }
                }
                break;
            case "cognome":
                for(int i=0; i<size(); i++){
                    if(get(i).getCognome().equals(paroladacercare)){
                        indici.add(i);
                    }
                }
                break;
            case "matricola":
                for(int i=0; i<size(); i++){
                    if(get(i).getMatricola().equals(paroladacercare)){
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
}
