package netflix;

public class SuscripcionNetflix {

    String email;
    String numTarjeta;
    int numPerfiles;

    /*
     * Clase que contiene los métodos necesarios para cacular cuanto debe pagar cada usuario segun el plan contratado
     * Máximo se admitiran 3 usuarios de manera predeterminda
     * @param email Email del usuario
     * @param numTarjeta Tarjeta del usuario
     * @author Sergio Simon Fernández
     */

    public SuscripcionNetflix(String email, String numTarjeta) {
        super();
        this.email = email;
        this.numTarjeta = numTarjeta;
        this.numPerfiles = 3; //por defecto te ofrece 3 perfiles
    }

    /*
     * Método que calcula el precio de la subscripción dependiendo del modo de pago elegido. Si es anual se le calculará
     * un descuento, si no lo es se calculara el precio mensual
     * @param modoPago tipo de subscripcion elegida (Anual o Mensual)
     * @returns precio de la subscripcion
     * @author Sergio Simon Fernández
     */

    public double cuotaPagar(int modoPago) {
        double cuota = 0;
        //Si pago es Anual, se hace un descuento al total
        if(modoPago == Constantes.PAGO_ANUAL) {
            cuota = (Constantes.PRECIO_NETFLIX_TOTAL - (Constantes.PRECIO_NETFLIX_TOTAL * Constantes.DESCUENTO_PAGO_ANUAL));
        }else if(modoPago == Constantes.PAGO_MENSUAL) {
            //si el pago es mensual, se divide el precio entre 12 meses
            cuota = (Constantes.PRECIO_NETFLIX_TOTAL / 12);
        }else {
            throw new IllegalArgumentException("El modo de pago es incorrecto.");
        }

        return redondearDoubleDosDecimales(cuota);
    }

    /*
     * Método que calcula el precio a pagar por cada uno de los usuarios
     * @param modoPago tipo de subscripcion elegida (Anual o Mensual)
     * @returns Precio a pagar por cada uno de los perfiles
     * @author Sergio Simon Fernández
     */
    public double cuotaPorPerfil(int modoPago) {
        double cuotaPagarTotal = cuotaPagar(modoPago);
        return redondearDoubleDosDecimales(cuotaPagarTotal / this.numPerfiles);
    }

    /*
     * Método que calcula el precio a pagar por cada uno de los usuarios actualmente en desuso
     * @param modoPago tipo de subscripcion elegida (Anual o Mensual)
     * @returns Precio a pagar por cada uno de los perfiles
     * @author Sergio Simon Fernández
     */
    @Deprecated
    public double cuotaPerfiles(int modoPago) {
        return redondearDoubleDosDecimales(Constantes.PRECIO_NETFLIX_TOTAL / this.numPerfiles);
    }

    /*
     * Método que redondea el precio de la subcripcion a dos decimales
     * @param numero Precio que va a ser redondeado
     * @returns Precio redondeado
     * @author Sergio Simon Fernández
     */
    public static double redondearDoubleDosDecimales(double numero) {
        return (double) Math.round(numero * 100) / 100;
    }
}
