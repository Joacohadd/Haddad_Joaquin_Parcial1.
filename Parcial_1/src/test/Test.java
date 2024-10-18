/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Gastronomia;
import model.Hospedaje;
import model.Servicio;
import model.Sistema;

/**
 *
 * @author joaqh
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("1-1");
        try {
            Gastronomia gastronomia = new Gastronomia("4892", 15.0, true, "Hambuerguesa", 180.0, 4);

        } catch (Exception e) {
            System.out.println("Error con el código de servicio: " + e.getMessage());
        }

        System.out.println("");
        System.out.println("1-2");

        try {
            Gastronomia gastronomia = new Gastronomia("489235", 15, true, "Hambuerguesa Criolla", 180.0, 4);

            System.out.println("Codigo: " + gastronomia.getCodServicio());
            System.out.println("Nombre: " + gastronomia.getGastronomia());
            System.out.println("Precio: " + gastronomia.getPrecio());
            System.out.println("Dia de descuento: " + gastronomia.getDiaSemDesc());
            System.out.println("Porcentaje de descuento: " + gastronomia.getPorcentajeDescuento());
            System.out.println("En promocion: " + gastronomia.isEnPromocion());

            System.out.println("");
            System.out.println("2-1");

            LocalDate fecha = LocalDate.of(2020, 10, 28);

            //precio final para esa fecha
            double precioFinal = gastronomia.calcularPrecioFinal(fecha);
            System.out.println("Precio final de Gastronomia para el dia " + fecha + ": " + precioFinal);
            System.out.println("");

        } catch (Exception e) {
            System.out.println("Error con el código de servicio: " + e.getMessage());
        }

        System.out.println("");
        System.out.println("1-3");

        try {
            Hospedaje hospedaje = new Hospedaje("2872", 10.0, true, "Cabaña 3 presonas", 1500.0);
        } catch (Exception e) {
            System.out.println("Error con el código de servicio: " + e.getMessage());
        }

        System.out.println("");
        System.out.println("1-4");

        try {
            Hospedaje hospedaje = new Hospedaje("287282", 10.0, true, "Cabaña 3 presonas", 1500.0);

            System.out.println("Servicio de hospedaje creado:");
            System.out.println("Codigo: " + hospedaje.getCodServicio());
            System.out.println("Nombre: " + hospedaje.getHospedaje());
            System.out.println("Precio por noche: " + hospedaje.getPrecioPorNoche());
            System.out.println("Porcentaje de descuento: " + hospedaje.getPorcentajeDescuento());
            System.out.println("En promocion: " + hospedaje.isEnPromocion());

            System.out.println("");
            System.out.println("2-2");

            LocalDate fecha = LocalDate.of(2020, 10, 27);

            double precioFinal = hospedaje.calcularPrecioFinal(fecha);
            System.out.println("Precio final del hospedaje para el dia " + fecha + ": " + precioFinal);
            System.out.println("");
        } catch (Exception e) {
            System.out.println("Error con el código de servicio: " + e.getMessage());
        }

        System.out.println("");
        System.out.println("3-1");

        List<Servicio> servicios = new ArrayList<>();

        //la lista de  vacía
        Sistema sistema = new Sistema(servicios);

        try {
            boolean agregar = sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
            if (agregar) {
                System.out.println("Servicio de gastronomia agregado.");
            }

        } catch (Exception e) {
            System.out.println("Error con el código de servicio: " + e.getMessage());
        }

        try {
            boolean agregar = sistema.agregarHospedaje("489259", 10.0, true, "Habitacion triple", 2200.0);
            if (agregar) {
                System.out.println("Servicio de hospedaje agregado.");
            }
        } catch (Exception e) {
            System.out.println("Error con el codigo de servicio: " + e.getMessage());
        }

        try {
            boolean agregar = sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            if (agregar) {
                System.out.println("Servicio de gastronomia agregado.");
            }
        } catch (Exception e) {
            System.out.println("Error con el codigo de servicio: " + e.getMessage());
        }

        try {
            boolean agregar = sistema.agregarHospedaje("758972", 15.0, false, "Habitacion simple", 1000.0);
            if (agregar) {
                System.out.println("Servicio de hospedaje agregado.");
            }
        } catch (Exception e) {
            System.out.println("Error con el codigo de servicio: " + e.getMessage());
        }

        System.out.println("");
        System.out.println("Cantidad de servicios en la lista: " + sistema.getLstServicio().size());
        System.out.println("Lista de servicios en el sistema:");
        System.out.println("");
        for (Servicio servicio : sistema.getLstServicio()) {
            if (servicio instanceof Gastronomia) {
                Gastronomia gastro = (Gastronomia) servicio;
                System.out.println("Gastronomia [codServicio=" + gastro.getCodServicio()
                        + ", porcentajeDescuento=" + gastro.getPorcentajeDescuento()
                        + ", enPromocion=" + gastro.isEnPromocion()
                        + ", gastronomia=" + gastro.getGastronomia()
                        + ", precio=" + gastro.getPrecio()
                        + ", diaSemDesc=" + gastro.getDiaSemDesc() + "]");
            } else if (servicio instanceof Hospedaje) {
                Hospedaje hospe = (Hospedaje) servicio;
                System.out.println("Hospedaje [codServicio=" + hospe.getCodServicio()
                        + ", porcentajeDescuento=" + hospe.getPorcentajeDescuento()
                        + ", enPromocion=" + hospe.isEnPromocion()
                        + ", hospedaje=" + hospe.getHospedaje()
                        + ", precioPorNoche=" + hospe.getPrecioPorNoche() + "]");
            }
        }

        System.out.println("");
        System.out.println("4-1");
        System.out.println("Servicios en promocion:");
        System.out.println("");
        List<Servicio> serviciosEnPromocion = sistema.traerServicio(true);

        for (Servicio servicio : serviciosEnPromocion) {
            if (servicio instanceof Gastronomia) {
                Gastronomia gastro = (Gastronomia) servicio;
                System.out.println("Gastronomia [codServicio=" + gastro.getCodServicio()
                        + ", porcentajeDescuento=" + gastro.getPorcentajeDescuento()
                        + ", enPromocion=" + gastro.isEnPromocion()
                        + ", gastronomia=" + gastro.getGastronomia()
                        + ", precio=" + gastro.getPrecio()
                        + ", diaSemDesc=" + gastro.getDiaSemDesc() + "]");
            } else if (servicio instanceof Hospedaje) {
                Hospedaje hospe = (Hospedaje) servicio;
                System.out.println("Hospedaje [codServicio=" + hospe.getCodServicio()
                        + ", porcentajeDescuento=" + hospe.getPorcentajeDescuento()
                        + ", enPromocion=" + hospe.isEnPromocion()
                        + ", hospedaje=" + hospe.getHospedaje()
                        + ", precioPorNoche=" + hospe.getPrecioPorNoche() + "]");
            }
        }
    }
}
