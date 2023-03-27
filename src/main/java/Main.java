import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca bib = new Biblioteca();
        Tesserati tess = new Tesserati();

        boolean firststart=true;
        boolean exitprogram=false;
        do{
            int scelta=-1;
            if(firststart==true){
                scelta=0;
                firststart=false;
            }else{
                //do{
                    System.out.println("Cosa vuoi fare?:\n 0) Inserisci libri\n 1) Inserisci Tesserati\n 2) Cerca e eventualmente rimuovi un libro\n 3) Cercare e eventualmente rimuove un tesserato\n 4) Prendere un libro in prestito\n 5) Restituire un libro\n 6) Esci");
                    scelta=scanner.nextInt();
                    scanner.nextLine();
                //}while(scelta<0 || scelta>5);
            }
            switch(scelta){
                case 0: /**inserimento libri*/

                    /** Variabile exit per uscire dall'inserimento dei libri */
                    int exit;
                    do{
                        boolean giausato=false;

                        System.out.println("Inserisci il titolo del libro");
                        String titolo=scanner.nextLine();

                        System.out.println("Inserisci l'autore del libro");
                        String autore=scanner.nextLine();

                        String codice;
                        do{
                            System.out.println("Inserisci il codice del libro");
                            codice=scanner.nextLine();
                            giausato=bib.giausato(codice);
                            if(giausato==true){
                                System.out.println("Codice già usato");
                            }
                            if(giausato==false){
                                bib.addcodici(codice);
                            }
                        }while(giausato==true);

                        Libro libro = new Libro(titolo, autore, codice);
                        bib.add(libro);
                        do{
                            System.out.println("Vuoi inserire un altro libro (0) o vuoi uscire(1)?");
                            exit=scanner.nextInt();
                            scanner.nextLine();
                        }while(exit!=0 && exit!=1);
                    }while(exit==0);
                        System.out.println(bib.lista + "\n");
                    break;

                case 1: /**Inserisci tesserati*/

                    /** Variabile exit per uscire dall'inserimento dei tesserati */
                    //int exit;
                    do{
                        boolean giausato=false;

                        System.out.println("Inserisci il nome");
                        String nome=scanner.nextLine();

                        System.out.println("Inserisci il cognome");
                        String cognome=scanner.nextLine();

                        String matricola;
                        do{
                            System.out.println("Inserisci la matricola");
                            matricola=scanner.nextLine();
                            giausato= tess.giausato(matricola);
                            if(giausato==true){
                                System.out.println("Codice già usato");
                            }
                            if(giausato==false){
                                tess.addmatricole(matricola);
                            }
                        }while(giausato==true);

                        Persona persona = new Persona(nome, cognome, matricola);
                        tess.add(persona);
                        do{
                            System.out.println("Vuoi inserire un altro tesserato (0) o vuoi uscire(1)?");
                            exit=scanner.nextInt();
                            scanner.nextLine();
                        }while(exit!=0 && exit!=1);
                    }while(exit==0);
                    System.out.println(tess.lista + "\n");
                    break;

                case 2: /**Cerca rimuovi libro*/

                    System.out.println("Vuoi cercare per Titolo, Autore o Codice?");
                    String tac=scanner.nextLine();

                    System.out.println("Inserisci la parola da cercare: ");
                    String parola=scanner.nextLine();

                    ArrayList<Integer> indici = new ArrayList<Integer>();
                    indici = bib.cerca(tac, parola);

                    if(indici.size()==0){
                        System.out.println("Nessun libro trovato");
                    }
                    if(indici.size()>0){
                        System.out.println("I libri trovati sono:");
                        for(int i=0; i<indici.size(); i++){
                            System.out.println(i + ") " + bib.get(indici.get(i)));
                        }

                        System.out.println("Vorresti rimuovere uno dei libri trovati Si(1)/No(0)");
                        int scelta2 =scanner.nextInt();
                        if(scelta2==1){
                            int darimuovere = -1;
                            do{
                                System.out.println("Quale vuoi rimuovere della lista qui sopra?");
                                darimuovere = scanner.nextInt();
                            }while(darimuovere<0 || darimuovere>=indici.size());

                            bib.rmcodici(bib.getcodici(indici.get(darimuovere)));
                            bib.rm(indici.get(darimuovere));
                        }
                    }

                    break;

                case 3: /**Cerca rimuovi tesserato*/
                    System.out.println("Vuoi cercare per Nome, Cognome o Matricola?");
                    String tesstac=scanner.nextLine();

                    System.out.println("Inserisci la parola da cercare: ");
                    String tessparola=scanner.nextLine();

                    ArrayList<Integer> tessindici = new ArrayList<Integer>();
                    tessindici = tess.cerca(tesstac, tessparola);

                    if(tessindici.size()==0){
                        System.out.println("Nessun tesserato trovato");
                    }
                    if(tessindici.size()>0){
                        System.out.println("I tesserati trovati sono:");
                        for(int i=0; i<tessindici.size(); i++){
                            System.out.println(i + ") " + tess.get(tessindici.get(i)));
                        }

                        System.out.println("Vorresti rimuovere uno dei tesserati trovati Si(1)/No(0)");
                        int scelta2 =scanner.nextInt();
                        if(scelta2==1){
                            int darimuovere = -1;
                            do{
                                System.out.println("Quale vuoi rimuovere della lista qui sopra?");
                                darimuovere = scanner.nextInt();
                            }while(darimuovere<0 || darimuovere>=tessindici.size());

                            tess.rmmatricole(tess.getmatricole(tessindici.get(darimuovere)));
                            tess.rm(tessindici.get(darimuovere));
                        }
                    }
                    break;

                case 4: /**Prendere in prestito*/
                    System.out.println("Vuoi cercare per Titolo, Autore o Codice?");
                    String presttac=scanner.nextLine();

                    System.out.println("Inserisci la parola da cercare: ");
                    String prestparola=scanner.nextLine();

                    ArrayList<Integer> prestindici = new ArrayList<Integer>();
                    prestindici = bib.cerca(presttac, prestparola);

                    if(prestindici.size()==0){
                        System.out.println("Nessun libro trovato");
                    }
                    if(prestindici.size()>0){
                        System.out.println("I libri trovati sono:");
                        for(int i=0; i<prestindici.size(); i++){
                            System.out.println(i + ") " + bib.get(prestindici.get(i)));
                        }

                        System.out.println("Vorresti prendere in prestito uno dei libri trovati? Si(1)/No(0)");
                        int scelta2 =scanner.nextInt();
                        if(scelta2==1){
                            int daprendere = -1;
                            do{
                                System.out.println("Quale vuoi prendere della lista qui sopra?");
                                daprendere = scanner.nextInt();
                            }while(daprendere<0 || daprendere>=prestindici.size());

                            bib.get(prestindici.get(daprendere)).setPrestito(true);
                        }
                    }
                    break;

                case 5: /**Restituire*/
                    System.out.println("Vuoi cercare per Titolo, Autore o Codice?");
                    String resttac=scanner.nextLine();

                    System.out.println("Inserisci la parola da cercare: ");
                    String restparola=scanner.nextLine();

                    ArrayList<Integer> restindici = new ArrayList<Integer>();
                    restindici = bib.cerca(resttac, restparola);

                    if(restindici.size()==0){
                        System.out.println("Nessun libro trovato");
                    }
                    if(restindici.size()>0){
                        System.out.println("I libri trovati sono:");
                        for(int i=0; i<restindici.size(); i++){
                            System.out.println(i + ") " + bib.get(restindici.get(i)));
                        }

                        System.out.println("Vorresti restituire uno dei libri trovati? Si(1)/No(0)");
                        int scelta2 =scanner.nextInt();
                        if(scelta2==1){
                            int darestituire = -1;
                            do{
                                System.out.println("Quale vuoi prendere della lista qui sopra?");
                                darestituire = scanner.nextInt();
                            }while(darestituire<0 || darestituire>=restindici.size());

                            bib.get(restindici.get(darestituire)).setPrestito(false);
                        }
                    }
                    break;

                case 6: /**Uscita*/
                    System.out.println("Arrivederci");
                    exitprogram=true;
                    break;

                default:
                    System.out.println("Scelta non esistente");
            }
        }while(exitprogram==false);
    }
}
