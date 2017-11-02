/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import Abstracta.Dispositivo;

/**
 *
 * @author Paula
 */
public class MonitorVO extends Dispositivo {

    //pulgadas, tipo, resolucion
    private double pulgada;
    private String tipo;
    private String Resolucion;

    /**
     * Constructor sin parametros
     */
    
    public MonitorVO() {
    }
/**
     * Constructor con parametros
     *
     * @param pulgada
     * @param tipo
     */
    public MonitorVO(double pulgada, String tipo, String Resolucion, int codigo, String serie, String marca) {
        super(codigo, serie, marca);
        this.pulgada = pulgada;
        this.tipo = tipo;
        this.Resolucion = Resolucion;
    }

    public double getPulgada() {
        return pulgada;
    }

    public void setPulgada(double pulgada) {
        this.pulgada = pulgada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getResolucion() {
        return Resolucion;
    }

    public void setResolucion(String Resolucion) {
        this.Resolucion = Resolucion;
    }


    /**
     * Metodo que retorna las pulgadas del Monitor
     *
     * @return
     */
    

    /**
     * Metodo que modifica las pulgadas del Monitor
     *
     * @param pulgada
     */
   

    /**
     * Metodo que retorna el tipo de monitor
     *
     * @return
     */
    

    /**
     * Metodo que modifica el tipo de monitor
     *
     * @param tipo
     */
    

}
