package uniandes.dpoo.aerolinea.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.aerolinea.persistencia.CentralPersistencia;
import uniandes.dpoo.aerolinea.persistencia.PersistenciaAerolineaJson;
import uniandes.dpoo.aerolinea.persistencia.PersistenciaAerolineaPlaintext;
import uniandes.dpoo.aerolinea.persistencia.PersistenciaTiquetesJson;
import uniandes.dpoo.aerolinea.persistencia.TipoInvalidoException;

public class CentralPersistenciaTest
{
    @BeforeEach
    void setUp( ) throws Exception
    {
    }

    @Test
    void testGetPersistenciaAerolinea( ) throws Exception
    {
        assertTrue( CentralPersistencia.getPersistenciaAerolinea( CentralPersistencia.JSON ) instanceof PersistenciaAerolineaJson );
        assertTrue( CentralPersistencia.getPersistenciaAerolinea( CentralPersistencia.PLAIN ) instanceof PersistenciaAerolineaPlaintext );
    }

    @Test
    void testGetPersistenciaAerolineaIncorrecto( )
    {
        assertThrows( TipoInvalidoException.class,
                ( ) -> CentralPersistencia.getPersistenciaAerolinea( "Otro" ) );
    }

    @Test
    void testGetPersistenciaTiquetes( ) throws Exception
    {
        assertTrue( CentralPersistencia.getPersistenciaTiquetes( CentralPersistencia.JSON ) instanceof PersistenciaTiquetesJson );
    }

    @Test
    void testGetPersistenciaTiquetesIncorrecto( )
    {
        assertThrows( TipoInvalidoException.class,
                ( ) -> CentralPersistencia.getPersistenciaTiquetes( CentralPersistencia.PLAIN ) );
    }
}
