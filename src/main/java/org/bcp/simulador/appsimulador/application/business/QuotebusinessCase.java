package org.bcp.simulador.appsimulador.application.business;

public class QuotebusinessCase {

    private double QuoteTEMCalculate(double TEA, double diasMes){
        double TEM=0;
        TEM = (Math.pow(1+(TEA/100),diasMes/360) - 1) * 100;
        return TEM;
    }
    public double QuoteCFMCalculate(double TEA, double MontoPrestamo, int NumeroCuotas){
        double CuotaMensual = 0;
        double TEM = QuoteTEMCalculate(TEA,30);
        double numerador = 0;
        numerador = TEM * (Math.pow((1+TEM/100),NumeroCuotas));
        double denominador = 0;
        denominador = (Math.pow((1+TEM/100),NumeroCuotas)) - 1;
        CuotaMensual = Math.round((MontoPrestamo * numerador) / (denominador))/100;
        return CuotaMensual;
    }
}
