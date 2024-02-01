package netflix;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuscripcionNetflixTest {

    @Test
    void cuotaPagar() {
        SuscripcionNetflix suscripcionNetflix = new SuscripcionNetflix("s.simon.fdez@gmail.com","113313");
        System.out.printf(String.valueOf(suscripcionNetflix.cuotaPagar(1)));
        System.out.printf(String.valueOf(suscripcionNetflix.cuotaPagar(0)));

        double pagoAnual = suscripcionNetflix.cuotaPagar(1);
        double pagoMensual = suscripcionNetflix.cuotaPagar(0);

        assertEquals(212.5,pagoAnual);
        assertEquals(20.83, pagoMensual);
    }

    @Test
    void redondearDoubleDosDecimales() {
        SuscripcionNetflix suscripcionNetflix = new SuscripcionNetflix("s.simon.fdez@gmail.com","113313");
        double precio = suscripcionNetflix.redondearDoubleDosDecimales(5.99999);
        assertEquals(6.0, precio);
        assertNotEquals(5.99, precio);
    }
}