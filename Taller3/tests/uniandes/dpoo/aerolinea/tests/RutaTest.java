package uniandes.dpoo.aerolinea.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;

public class RutaTest
{
    private Ruta ruta;

    @BeforeEach
    void setUp( ) throws Exception
    {
        Aeropuerto origen = new Aeropuerto( "Origen", "R" + System.nanoTime( ), "Ciudad 1", 0, 0 );
        Aeropuerto destino = new Aeropuerto( "Destino", "D" + System.nanoTime( ), "Ciudad 2", 1, 1 );
        ruta = new Ruta( origen, destino, "0830", "1045", "RUTA-TEST" );
    }

    @Test
    void testGetDuracion( )
    {
        assertEquals( 135, ruta.getDuracion( ) );
    }

    @Test
    void testGetMinutos( )
    {
        assertEquals( 45, Ruta.getMinutos( "1045" ) );
    }

    @Test
    void testGetHoras( )
    {
        assertEquals( 10, Ruta.getHoras( "1045" ) );
    }
}
