import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    Biblioteca biblioteca;
    Libro libro;
    Tesserati tesserati;
    Persona persona;
    ArrayList<Integer> indiciCercaTitoloCrypto;
    ArrayList<Integer> indiciCercaTitoloGhiaccio;
    ArrayList<Integer> indiciCercaTitoloNull;
    ArrayList<Integer> indiciCercaAutoreDanBrown;
    ArrayList<Integer> indiciCercaAutoreNull;
    ArrayList<Integer> indiciCercaCodice1234;
    ArrayList<Integer> indiciCercaCodice1235;
    ArrayList<Integer> indiciCercaCodiceNull;
    ArrayList<Integer> indiciCercaNomeMattia;
    ArrayList<Integer> indiciCercaNomeDavide;
    ArrayList<Integer> indiciCercaNomeNull;
    ArrayList<Integer> indiciCercaCognomeBianco;
    ArrayList<Integer> indiciCercaCognomeGiuliani;
    ArrayList<Integer> indiciCercaCognomeNull;
    ArrayList<Integer> indiciCercaMatricola0987AB;
    ArrayList<Integer> indiciCercaMatricola1234AB;
    ArrayList<Integer> indiciCercaMatricolaNull;



    @BeforeEach
    void setUp(){
        biblioteca = new Biblioteca();
        biblioteca.add(libro = new Libro("Crypto", "Dan Brown", "1234"));
        biblioteca.addcodici("1234");
        biblioteca.add(libro = new Libro("I segreti del ghiaccio", "Dan Brown", "1235"));
        biblioteca.addcodici("1235");

        indiciCercaTitoloCrypto = new ArrayList<Integer>();
        indiciCercaTitoloCrypto.add(0);
        indiciCercaTitoloGhiaccio = new ArrayList<Integer>();
        indiciCercaTitoloGhiaccio.add(1);
        indiciCercaTitoloNull = new ArrayList<Integer>();

        indiciCercaAutoreDanBrown = new ArrayList<Integer>();
        indiciCercaAutoreDanBrown.add(0);
        indiciCercaAutoreDanBrown.add(1);
        indiciCercaAutoreNull = new ArrayList<Integer>();

        indiciCercaCodice1234 = new ArrayList<Integer>();
        indiciCercaCodice1234.add(0);
        indiciCercaCodice1235 = new ArrayList<Integer>();
        indiciCercaCodice1235.add(1);
        indiciCercaCodiceNull = new ArrayList<Integer>();


        tesserati = new Tesserati();
        tesserati.add(persona = new Persona("Mattia", "Bianco", "0987AB"));
        tesserati.addmatricole("0987AB");
        tesserati.add(persona = new Persona("Davide", "Giuliani", "1234AB"));
        tesserati.addmatricole("1234AB");

        indiciCercaNomeMattia = new ArrayList<Integer>();
        indiciCercaNomeMattia.add(0);
        indiciCercaNomeDavide = new ArrayList<Integer>();
        indiciCercaNomeDavide.add(1);
        indiciCercaNomeNull = new ArrayList<Integer>();

        indiciCercaCognomeBianco = new ArrayList<Integer>();
        indiciCercaCognomeBianco.add(0);
        indiciCercaCognomeGiuliani = new ArrayList<Integer>();
        indiciCercaCognomeGiuliani.add(1);
        indiciCercaCognomeNull = new ArrayList<Integer>();

        indiciCercaMatricola0987AB = new ArrayList<Integer>();
        indiciCercaMatricola0987AB.add(0);
        indiciCercaMatricola1234AB = new ArrayList<Integer>();
        indiciCercaMatricola1234AB.add(1);
        indiciCercaMatricolaNull = new ArrayList<Integer>();
    }
    @Test
    void testCercaTitolo() {
        assertEquals(indiciCercaTitoloCrypto, biblioteca.cerca("titolo", "Crypto"));
        assertEquals(indiciCercaTitoloCrypto.size(), biblioteca.cerca("titolo", "Crypto").size());

        assertEquals(indiciCercaTitoloGhiaccio, biblioteca.cerca("titolo", "I segreti del ghiaccio"));
        assertEquals(indiciCercaTitoloGhiaccio.size(), biblioteca.cerca("titolo", "I segreti del ghiaccio").size());

        assertEquals(indiciCercaTitoloNull, biblioteca.cerca("titolo", "a"));
        assertEquals(indiciCercaTitoloNull.size(), biblioteca.cerca("titolo", "a").size());
    }

    @Test
    void testCercaAutore() {
        assertEquals(indiciCercaAutoreDanBrown, biblioteca.cerca("autore", "Dan Brown"));
        assertEquals(indiciCercaAutoreDanBrown.size(), biblioteca.cerca("autore", "Dan Brown").size());

        assertEquals(indiciCercaAutoreNull, biblioteca.cerca("autore", "a"));
        assertEquals(indiciCercaAutoreNull.size(), biblioteca.cerca("autore", "a").size());
    }

    @Test
    void testCercaCodice() {
        assertEquals(indiciCercaCodice1234, biblioteca.cerca("codice", "1234"));
        assertEquals(indiciCercaCodice1234.size(), biblioteca.cerca("codice", "1234").size());

        assertEquals(indiciCercaCodice1235, biblioteca.cerca("codice", "1235"));
        assertEquals(indiciCercaCodice1235.size(), biblioteca.cerca("codice", "1235").size());

        assertEquals(indiciCercaCodiceNull, biblioteca.cerca("codice", "a"));
        assertEquals(indiciCercaCodiceNull.size(), biblioteca.cerca("codice", "a").size());
    }

    @Test
    void testGiausatoCodice() {
        assertTrue(biblioteca.giausato("1234"));
        assertTrue(biblioteca.giausato("1235"));
        assertFalse(biblioteca.giausato("1236"));
    }

    @Test
    void testCercaNome(){
        assertEquals(indiciCercaNomeMattia, tesserati.cerca("nome", "Mattia"));
        assertEquals(indiciCercaNomeMattia.size(), tesserati.cerca("nome", "Mattia").size());

        assertEquals(indiciCercaNomeDavide, tesserati.cerca("nome", "Davide"));
        assertEquals(indiciCercaNomeDavide.size(), tesserati.cerca("nome", "Davide").size());

        assertEquals(indiciCercaNomeNull, tesserati.cerca("nome", "a"));
        assertEquals(indiciCercaNomeNull.size(), tesserati.cerca("nome", "a").size());
    }

    @Test
    void testCercaCognome(){
        assertEquals(indiciCercaCognomeBianco, tesserati.cerca("cognome", "Bianco"));
        assertEquals(indiciCercaCognomeBianco.size(), tesserati.cerca("cognome", "Bianco").size());

        assertEquals(indiciCercaCognomeGiuliani, tesserati.cerca("cognome", "Giuliani"));
        assertEquals(indiciCercaCognomeGiuliani.size(), tesserati.cerca("cognome", "Giuliani").size());

        assertEquals(indiciCercaCognomeNull, tesserati.cerca("cognome", "a"));
        assertEquals(indiciCercaCognomeNull.size(), tesserati.cerca("cognome", "a").size());
    }

    @Test
    void testCercaMatricola(){
        assertEquals(indiciCercaMatricola0987AB, tesserati.cerca("matricola", "0987AB"));
        assertEquals(indiciCercaMatricola0987AB.size(), tesserati.cerca("matricola", "0987AB").size());

        assertEquals(indiciCercaMatricola1234AB, tesserati.cerca("matricola", "1234AB"));
        assertEquals(indiciCercaMatricola1234AB.size(), tesserati.cerca("matricola", "1234AB").size());

        assertEquals(indiciCercaMatricolaNull, tesserati.cerca("matricola", "a"));
        assertEquals(indiciCercaMatricolaNull.size(), tesserati.cerca("matricola", "a").size());
    }

    @Test
    void testGiausatoMatricola() {
        assertTrue(tesserati.giausato("0987AB"));
        assertTrue(tesserati.giausato("1234AB"));
        assertFalse(tesserati.giausato("1236AB"));
    }
}