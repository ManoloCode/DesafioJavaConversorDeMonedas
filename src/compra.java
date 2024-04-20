public class compra implements Comparable<compra> {
    private double valor;
    private String descripcion;

    public compra(double valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public double getValor(){
        return valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "compra: valor=" + valor +
                ", descripcion='" + descripcion;
    }

    @Override
    public int compareTo(compra otraCompra) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(otraCompra.getValor()));
    }
}
