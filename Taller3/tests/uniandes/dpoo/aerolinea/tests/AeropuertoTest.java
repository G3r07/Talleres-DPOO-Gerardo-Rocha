package uniandes.dpoo.aerolinea.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.aerolinea.exceptions.AeropuertoDuplicadoException;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;

public class AeropuertoTest
{
    private static Aeropuerto centro;
    private static Aeropuerto norte;
    private static Aeropuerto sur;
    private static Aeropuerto este;
    private static Aeropuerto oeste;

    @BeforeAll
    static void setUp( ) throws Exception
    {
        centro = new Aeropuerto( "Centro", "T00", "Centro", 0, 0 );
        norte = new Aeropuerto( "Norte", "T01", "Norte", 1, 0 );
        sur = new Aeropuerto( "Sur", "T02", "Sur", -1, 0 );
        este = new Aeropuerto( "Este", "T03", "Este", 0, 1 );
        oeste = new Aeropuerto( "Oeste", "T04", "Oeste", 0, -1 );
    }

    @Test
    void testCodigoUnico( )
    {
        assertThrows( AeropuertoDuplicadoException.class,
                ( ) -> new Aeropuerto( "Duplicado", "T00", "Otra", 5, 5 ) );
    }

    @Test
    void testCalcularDistanciaAlCentro( )
    {
        assertEquals( 111, Aeropuerto.calcularDistancia( centro, norte ), 1 );
    }

    @Test
    void testCalcularDistanciaEntreParejasOpuestas( )
    {
        assertEquals( 222, Aeropuerto.calcularDistancia( norte, sur ), 2 );
    }

    @Test
    void testCalcularDistanciaEntreParejas( )
    {
        assertEquals( 157, Aeropuerto.calcularDistancia( norte, este ), 2 );
    }

    @Test
    void testCalcularDistanciaMismoAeropuerto( )
    {
        assertEquals( 0, Aeropuerto.calcularDistancia( oeste, oeste ) );
    }
}
