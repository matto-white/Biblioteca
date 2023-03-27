import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    Biblioteca biblioteca;
    Libro libro;
    ArrayList<Integer> indiciCercaTitoloCrypto;
    ArrayList<Integer> indiciCercaTitoloGhiaccio;
    ArrayList<Integer> indiciCercaTitoloNull;
    ArrayList<Integer> indiciCercaAutoreDanBrown;
    ArrayList<Integer> indiciCercaAutoreNull;
    ArrayList<Integer> indiciCercaCodice1234;
    ArrayList<Integer> indiciCercaCodice1235;
    ArrayList<Integer> indiciCercaCodiceNull;

    @BeforeEach
    void setUp(){
        biblioteca = new Biblioteca();
        biblioteca.add(libro = new Libro("Crypto", "Dan Brown", "1234"));
        biblioteca.add(libro = new Libro("I segreti del ghiaccio", "Dan Brown", "1235"));

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
    void testGiausato() {
    }
}