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
public class CPUVO extends Dispositivo{
    private String Memoria;
    private String Disco;

    public String getMemoria() {
        return Memoria;
    }

    public void setMemoria(String Memoria) {
        this.Memoria = Memoria;
    }

    public String getDisco() {
        return Disco;
    }

    public void setDisco(String Disco) {
        this.Disco = Disco;
    }

    public CPUVO(String Memoria, String Disco, int codigo, String serie, String marca) {
        super(codigo, serie, marca);
        this.Memoria = Memoria;
        this.Disco = Disco;
    }

    public CPUVO() {
    }

    
}
