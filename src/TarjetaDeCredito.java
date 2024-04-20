import java.util.ArrayList;
import java.util.List;

public class TarjetaDeCredito{
    private double limite;
    private double saldo;
    private List<compra> listaDeCompras;

    public TarjetaDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.listaDeCompras = new ArrayList<>();
    }

   public boolean lanzarCompra(compra Compra){
        if(this.saldo >= Compra.getValor()){
            this.saldo -= Compra.getValor();
            this.listaDeCompras.add(Compra);
            return true;
        }
        return false;
   }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<compra> getListaDeCompras() {
        return listaDeCompras;
    }
}
