package uniandes.dpoo.aerolinea.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class ClienteTest
{
    @BeforeEach
    void setUp( ) throws Exception
    {
    }

    @Test
    void test( )
    {
        ClienteNatural clienteNatural = new ClienteNatural( "Alice" );
        ClienteCorporativo clienteCorporativo = new ClienteCorporativo( "Empresa", ClienteCorporativo.MEDIANA );

        assertEquals( "Alice", clienteNatural.getIdentificador( ) );
        assertEquals( ClienteNatural.NATURAL, clienteNatural.getTipoCliente( ) );
        assertEquals( "Empresa", clienteCorporativo.getIdentificador( ) );
        assertEquals( ClienteCorporativo.CORPORATIVO, clienteCorporativo.getTipoCliente( ) );
        assertEquals( ClienteCorporativo.MEDIANA, clienteCorporativo.getTamanoEmpresa( ) );
    }
}
