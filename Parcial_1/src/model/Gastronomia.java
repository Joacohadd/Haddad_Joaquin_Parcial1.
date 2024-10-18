/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author joaqh
 */
public class Gastronomia extends Servicio {
    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion,
                        String gastronomia, double precio, int diaSemDesc) throws ErrorCodServicio {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        int diaSemana = dia.getDayOfWeek().getValue();
        diaSemana = (diaSemana % 7) + 1;
        if (enPromocion && diaSemana == diaSemDesc) {
            return precio - (precio * porcentajeDescuento / 100);
        }
        return precio;
    }

    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    public void setDiaSemDesc(int diaSemDesc) {
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public String toString() {
        return "Gastronomia{"+ " codServicio " + codServicio + "porcentajeDescuento"+ porcentajeDescuento+ "enPromocion" + enPromocion + "gastronomia=" + gastronomia + ", precio=" + precio + ", diaSemDesc=" + diaSemDesc + '}';
    } 
    
}
