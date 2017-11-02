/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstracta;

/**
 *
 * @author Paula
 */
public class Dispositivo {

    //codigo, serie, marca
    private int codigo;
    private String serie;
    private String marca;

    /**
     * Constructor sin parametros
     */
    public Dispositivo() {
    }

    /**
     * Constructor con parametros
     *
     * @param codigo
     * @param serie
     * @param marca
     */
    public Dispositivo(int codigo, String serie, String marca) {
        this.codigo = codigo;
        this.serie = serie;
        this.marca = marca;
    }

    /**
     * Metodo que retorna el codigo del dispositivo
     *
     * @return
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Metodo que modifica el codigo del dispositivo
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo que devuelve la serie del dispositivo
     *
     * @return
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Metodo que modifica la serie del dispositivo
     *
     * @param serie
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * Metodo que devuelve la marca del dispositivo
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Metodo que modifica la marca del dispositivo
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

}
