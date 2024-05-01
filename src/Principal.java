import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        MonedaAConsultar consulta = new MonedaAConsultar();
        System.out.println("\n************************************");
        System.out.println("\nSeleccione la opción de la conversión que desea realizar: ");
        System.out.println("""
                1. USD >> COP Dolar a Peso Colombiano.
                2. COP >> USD Peso Colombiano a Dolar.
                3. EUR >> COP Euro a Peso Colombiano.
                4. COP >> EUR Peso Colombiano a Euro.
                5. CLP >> COP Peso Chileno a Peso Colombiano.
                6. COP >> CLP Peso Colombiano a Peso Chileno.
                7. BRL >> COP Real Brasileño a Peso Colombiano.
                8. COP >> BRL Peso Colombiano a Real Brasileño.
                9. ARS >> COP Peso Argentino a Peso Colombiano.
                10. COP >> ARS Peso Colombiano a Peso Argentino.
               """);

        try {
            var StringDeConversion = (lectura.nextLine());
            Moneda moneda = consulta.buscaMoneda(StringDeConversion);
            System.out.println(moneda);
            GeneradorDeArchivos generador = new GeneradorDeArchivos();
            generador.guardarJson(moneda);
        }catch (NumberFormatException e) {
            System.out.println("Número no encontrado. "+ e.getMessage());
        }catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizado la aplicación...");
        }


    }


}
