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
public class ImpresoraVO extends Dispositivo{
    private String Tipo;

    public ImpresoraVO(String Tipo, int codigo, String serie, String marca) {
        super(codigo, serie, marca);
        this.Tipo = Tipo;
    }

    public ImpresoraVO() {
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
}
