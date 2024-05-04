import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        System.out.println("\n************************************");
        System.out.println("\n Bienvenido a nuestro conversor de monedas.. Por favor seleccione la moneda Base: ");
        System.out.println("\n Ejemplo: USD, EUR, COP, Etc...\n");
        String menu = ("""
                1. Dolar -> USD
                2. Euro -> EUR
                3. Peso Colombiano -> COP
                4. Peso Chileno -> CLP
                5. Real Brasileño -> BRL
                6. Peso Argentino -> ARS
                7. Dólar canadiense -> CAD
                8. Nuevo Sol (Perú) -> PEN
               """);
        System.out.println(menu);

        try {

            var monedaBase = (lectura.nextLine());
            System.out.println("\n Seleccione la moneda a la cual desea realizar la conversion:\n");

            System.out.println(menu);
            Scanner segundaLectura = new Scanner(System.in);
            var monedaConversion = (segundaLectura.nextLine());

            System.out.println("\nIngrese el monto que deseas convertir.\n");
            Scanner monto = new Scanner(System.in);
            var montoAConvertir = (monto.nextLine());

            Moneda moneda = consulta.conversionMoneda(monedaBase, monedaConversion, Double.valueOf(montoAConvertir));
            System.out.println("**************************************\n");
            System.out.println("El total de " + monedaBase + " en " + monedaConversion + " es equivalente a " + moneda.conversion_result());
            System.out.println("\nFinalizando el conversor...");
            GeneradorDeArchivos generador = new GeneradorDeArchivos();
            generador.guardarJson(moneda);
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}

