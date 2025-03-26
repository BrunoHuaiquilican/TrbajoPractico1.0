package org.segundo.punto;

public class Viedma extends Tarjeta{

    @Override
    public double calcularDescuento(double totalPlatos, double totalBebidas) {
        double siDescuento = totalPlatos + totalBebidas;
        return siDescuento;
    }
}
