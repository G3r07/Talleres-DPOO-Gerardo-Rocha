package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas
{
    protected final int COSTO_POR_KM_NATURAL = 600;
    protected final int COSTO_POR_KM_CORPORATIVO = 900;
    protected final double DESCUENTO_PEQ = 0.02;
    protected final double DESCUENTO_MEDIANAS = 0.1;
    protected final double DESCUENTO_GRANDES = 0.2;

    @Override
    public int calcularCostoBase( Vuelo vuelo, Cliente cliente )
    {
        int costoPorKm;

        if( cliente.getTipoCliente( ).equals( ClienteCorporativo.CORPORATIVO ) )
        {
            costoPorKm = COSTO_POR_KM_CORPORATIVO;
        }
        else
        {
            costoPorKm = COSTO_POR_KM_NATURAL;
        }

        int distancia = calcularDistanciaVuelo( vuelo.getRuta( ) );
        return costoPorKm * distancia;
    }

    @Override
    public double calcularPorcentajeDescuento( Cliente cliente )
    {
        double descuento = 0;

        if( cliente.getTipoCliente( ).equals( ClienteCorporativo.CORPORATIVO ) )
        {
            ClienteCorporativo clienteCorporativo = ( ClienteCorporativo )cliente;

            if( clienteCorporativo.getTamanoEmpresa( ) == ClienteCorporativo.GRANDE )
            {
                descuento = DESCUENTO_GRANDES;
            }
            else if( clienteCorporativo.getTamanoEmpresa( ) == ClienteCorporativo.MEDIANA )
            {
                descuento = DESCUENTO_MEDIANAS;
            }
            else if( clienteCorporativo.getTamanoEmpresa( ) == ClienteCorporativo.PEQUENA )
            {
                descuento = DESCUENTO_PEQ;
            }
        }

        return descuento;
    }
}
