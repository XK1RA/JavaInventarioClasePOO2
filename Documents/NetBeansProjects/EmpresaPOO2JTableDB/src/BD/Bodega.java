/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Abstracta.Dispositivo;

/**
 *
 * @author Paula
 */
public class Bodega {
    private Object BD[]=new Object[10];//solo para 10 registros
    private int contador=0;
    public int getContador(){
        return contador;
    }
    public boolean agregar(Object tmp){
        if(contador<10){
            BD[contador]=tmp;
            contador++;
            return true;
        }else{
            return false;
        }
    }
    public Object[] GetBD(){
        return BD;
    }
    public Dispositivo buscarXID(int id){
        Object canasta[]=GetBD();
        for (int i = 0; i < getContador(); i++) {
            Dispositivo ElDispo=(Dispositivo)canasta[i];
            if(ElDispo.getCodigo()==id){
                return ElDispo;
            }
        }
        return null;
    }
}
