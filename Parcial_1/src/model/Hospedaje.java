/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author joaqh
 */
public class Hospedaje extends Servicio {
    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion,
                      String hospedaje, double precioPorNoche) throws ErrorCodServicio {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        DayOfWeek diaSemanal =dia.getDayOfWeek();
        if (enPromocion && (diaSemanal != DayOfWeek.SATURDAY && diaSemanal != DayOfWeek.SUNDAY)) {
            return precioPorNoche - (precioPorNoche * porcentajeDescuento / 100);
        }
        return precioPorNoche;
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public String toString() {
        return "Hospedaje{"+" codServicio " + codServicio + "porcentajeDescuento"+ porcentajeDescuento+ "enPromocion" + enPromocion + "hospedaje=" + hospedaje + ", precioPorNoche=" + precioPorNoche + '}';
    }
    
    
    

}
