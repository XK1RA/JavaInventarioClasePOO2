/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.Bodega;
import VO.MarcaVO;

/**
 *
 * @author Paula
 */
public class MarcaDAO {
    private Bodega BDMarca=new Bodega();
    
    public Object[] getBDMarca(){
        return this.BDMarca.GetBD();
    }
    public MarcaDAO(){
        MarcaVO tmp0= new MarcaVO(0, "Seleccione");
        BDMarca.agregar(tmp0);
        MarcaVO tmp1= new MarcaVO(1, "HP");
        BDMarca.agregar(tmp1);
        MarcaVO tmp2= new MarcaVO(2, "Sony");
        BDMarca.agregar(tmp2);
        MarcaVO tmp3= new MarcaVO(3, "Lenovo");
        BDMarca.agregar(tmp3);
        MarcaVO tmp4= new MarcaVO(4, "Toshiba");
        BDMarca.agregar(tmp4);
        MarcaVO tmp5= new MarcaVO(5, "Epson");
        BDMarca.agregar(tmp5);
        MarcaVO tmp6= new MarcaVO(6, "Canon");
        BDMarca.agregar(tmp6);
    }
    public int getSize(){
        return BDMarca.getContador();
    }
    public MarcaVO BuscarNombre(int id){
        Object tmp[] = getBDMarca();
        for(int i=0;i<BDMarca.getContador();i++){
            MarcaVO Marca=(MarcaVO) tmp[i];
            if(Marca.getID()==id){
                return Marca;
            }
        }
        return null;
    }
}
