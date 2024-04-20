import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el límite de la tarjeta: ");
        double limite = lectura.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        int salir = 1;
        while(salir != 0) {
            System.out.println("Escriba la descripción de la compra:");
            String descripcion = lectura.next();

            System.out.println("Escriba el valor de la compra:");
            double valor = Double.valueOf(lectura.next());

            compra Compra = new compra(valor, descripcion);
            boolean compraRealizada = tarjeta.lanzarCompra(Compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Escriba 0 para salir o 1 para continuar");
                salir = lectura.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                salir = 0;
            }
        }
        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        Collections.sort(tarjeta.getListaDeCompras());

        for (compra Compra : tarjeta.getListaDeCompras()) {
            System.out.println(Compra.getDescripcion() + " - " +Compra.getValor());
        }
        System.out.println("\n***********************");
        System.out.println("\nSaldo de la tarjeta: " +tarjeta.getSaldo());

    }
}
