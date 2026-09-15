package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.LinkedList;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente
{
    private List<Tiquete> tiquetesSinUsar;
    private List<Tiquete> tiquetesUsados;

    public Cliente( )
    {
        tiquetesSinUsar = new LinkedList<Tiquete>( );
        tiquetesUsados = new LinkedList<Tiquete>( );
    }

    public abstract String getTipoCliente( );

    public abstract String getIdentificador( );

    public void agregarTiquete( Tiquete tiquete )
    {
        tiquetesSinUsar.add( tiquete );
    }

    public int calcularValorTotalTiquetes( )
    {
        int total = 0;

        for( Tiquete tiquete : tiquetesSinUsar )
        {
            total = total + tiquete.getTarifa( );
        }

        return total;
    }

    public void usarTiquetes( Vuelo vuelo )
    {
        List<Tiquete> tiquetesParaUsar = new LinkedList<Tiquete>( );

        for( Tiquete tiquete : tiquetesSinUsar )
        {
            if( tiquete.getVuelo( ).equals( vuelo ) )
            {
                tiquetesParaUsar.add( tiquete );
            }
        }

        for( Tiquete tiquete : tiquetesParaUsar )
        {
            tiquete.marcarComoUsado( );
            tiquetesSinUsar.remove( tiquete );
            tiquetesUsados.add( tiquete );
        }
    }
}
