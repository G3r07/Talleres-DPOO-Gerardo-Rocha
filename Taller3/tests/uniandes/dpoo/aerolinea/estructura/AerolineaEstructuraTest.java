package uniandes.dpoo.aerolinea.estructura;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class AerolineaEstructuraTest
{
    @Test
    void testEstructuraAerolinea( ) throws Exception
    {
        assertNotNull( getClass( "uniandes.dpoo.aerolinea.modelo.Aerolinea" ) );
        assertNotNull( getClass( "uniandes.dpoo.aerolinea.modelo.Aeropuerto" ) );
        assertNotNull( getClass( "uniandes.dpoo.aerolinea.modelo.Ruta" ) );
        assertNotNull( getClass( "uniandes.dpoo.aerolinea.modelo.Avion" ) );
        assertNotNull( getClass( "uniandes.dpoo.aerolinea.modelo.Vuelo" ) );
    }

    @Test
    void testMetodosAerolinea( ) throws Exception
    {
        Class<?> aerolinea = getClass( "uniandes.dpoo.aerolinea.modelo.Aerolinea" );
        Method cargarAerolinea = aerolinea.getMethod( "cargarAerolinea", String.class, String.class );
        Method cargarTiquetes = aerolinea.getMethod( "cargarTiquetes", String.class, String.class );
        Method programarVuelo = aerolinea.getMethod( "programarVuelo", String.class, String.class, String.class );
        assertNotNull( cargarAerolinea );
        assertNotNull( cargarTiquetes );
        assertNotNull( programarVuelo );
    }

    private Class<?> getClass( String typeName ) throws ClassNotFoundException
    {
        return Class.forName( typeName );
    }
}
