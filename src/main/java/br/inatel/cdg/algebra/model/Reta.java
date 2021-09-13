package br.inatel.cdg.algebra.model;

public class Reta {
    private double coeficienteAngular;
    private double coeficienteLinear;

    public Reta(Ponto p1, Ponto p2) {
        coeficienteAngular = calcularCoeficienteAngular(p1, p2);
        coeficienteLinear = calcularCoeficienteLinear(p1, p2);
    }

    public double calcularCoeficienteAngular(Ponto p1, Ponto p2) {
        return (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
    }

    public double calcularCoeficienteLinear(Ponto p1, Ponto p2) {
        return (p1.getY() - calcularCoeficienteAngular(p1, p2) * p1.getX());
    }

    public double getCoeficienteAngular() {
        return coeficienteAngular;
    }

    public double getCoeficienteLinear() {
        return coeficienteLinear;
    }
}
