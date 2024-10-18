/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaqh
 */
public class Sistema {

    private List<Servicio> lstServicio;

    public Sistema(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    public void agregarServicio(Servicio servicio) {
        lstServicio.add(servicio);
    }

    // TRAER SERVICIOS
    public Servicio traerServicio(String codServicio) throws ErrorServicioNoEncontrado {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                return servicio;
            }
        }
        throw new ErrorServicioNoEncontrado("Servicio de cod " + codServicio + " no fue encontrado.");
    }

    // SERVICIOS EN PROMO
    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosEnPromocion.add(servicio);
            }
        }
        return serviciosEnPromocion;
    }

    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> serviciosEnPromocion = new ArrayList<>();

        for (Servicio servicio : lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                double precioFinal = servicio.calcularPrecioFinal(dia);

                // Solo agregamos el servicio si el precio final es mayor que 0
                if (precioFinal > 0) {
                    serviciosEnPromocion.add(servicio);
                }
            }
        }
        return serviciosEnPromocion;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion,
            String gastronomia, double precio, int diaSemDesc) throws ErrorServicioYaExiste {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                // Lanza una excepción si el servicio con el mismo código ya existe
                throw new ErrorServicioYaExiste("El servicio con cod " + codServicio + " ya existe.");
            }
        }
        try {
            // Crear el nuevo servicio de tipo Gastronomia y agregarlo a la lista
            Gastronomia nuevoGastronomia = new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc);
            lstServicio.add(nuevoGastronomia);  // Agregar a la lista
        } catch (ErrorCodServicio e) {
            System.out.println("Error con el código de servicio: " + e.getMessage());
            return false;  // Si hay un error, devolvemos false
        }

        return true;
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion,
            String hospedaje, double precioPorNoche) throws ErrorServicioYaExiste {
        // Verificar si el servicio ya existe por su código
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                // Si ya existe un servicio con ese código, lanzar la excepción personalizada
                throw new ErrorServicioYaExiste("El servicio con código " + codServicio + " ya existe.");
            }
        }
        try {
            Hospedaje nuevoHospedaje = new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche);
            lstServicio.add(nuevoHospedaje);  
        } catch (ErrorCodServicio e) {
            System.out.println("Error con el código de servicio: " + e.getMessage());
            return false;  // Si hay un error, devolvemos false
        }
        return true;
    }

    public List<Servicio> getLstServicio() {
        return lstServicio;
    }

    public void setLstServicio(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

}
