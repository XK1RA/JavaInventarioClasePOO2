/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.Bodega;
import FileLoad.Leer;
import FileSave.Guardar;
import VO.ImpresoraVO;
import VO.MarcaVO;
import java.io.BufferedReader;

/**
 *
 * @author Paula
 */
public class ImpresoraDAO {
    //String Tipo, int codigo, String serie, String marca
    private Bodega BDImpresora = new Bodega();
    

    /**
     * Metodo que almacena la informacion temporalmente
     *
     * @param pulgada
     * @param tipo
     * @param codigo
     * @param serie
     * @param marca
     * @return
     */
    public boolean almacenar(String Tipo, int codigo, String serie, String marca) {
        ImpresoraVO tmp = new ImpresoraVO(Tipo, codigo, serie, marca);
        return BDImpresora.agregar(tmp);
    }

    /**
     * Metodo que retorna el tamaño de la base de datos
     *
     * @return
     */
    public int Size() {
        return BDImpresora.getContador();
    }

    /**
     * Metodo que enlista los registros que esten guardados
     *
     * @return
     */
    public String ListaImpresora(MarcaDAO LasMarcas) {
        String Lista = "Lista de Impresoras Almacenadas\n";
        Object tmp[] = BDImpresora.GetBD();
        for (int i = 0; i < BDImpresora.getContador(); i++) {
            ImpresoraVO impr = (ImpresoraVO) tmp[i];
            MarcaVO estaES= LasMarcas.BuscarNombre(Integer.parseInt(impr.getMarca()));
            Lista += (i + 1) + " el ID= " + impr.getCodigo() + " Marca= " + estaES.getNombre() + " Seria= " + impr.getSerie()+" Tipo: "+impr.getTipo() + "\n";
        }
        return Lista;
    }

    /**
     * Metodo que guarda los registros almacenados temporalmente en una base de
     * datos con nombre LosMonitores
     *
     * @return
     */
    public boolean Guardar() {
        String cadena = "";
        Object tmp[] = BDImpresora.GetBD();
        for (int i = 0; i < BDImpresora.getContador(); i++) {
            ImpresoraVO impr = (ImpresoraVO) tmp[i];
            cadena +=  impr.getCodigo()+ ";" + impr.getMarca() + ";" + impr.getSerie() + ";" + impr.getTipo() + "\r";
        }
        Guardar send = new Guardar();
        return send.almacenar("LasImpresoras", cadena);
    }

    /**
     * Metodo que carga datos al archivo respetando certa estructura final si no
     * se encuentra datos a la ejecucion del programa retorna un mensaje con la
     * correspondiente alerta de no bases de datos
     */
    public void CargarFile() {
        try {
            Leer subir = new Leer();
            BufferedReader tmp = subir.cargaBU("LasImpresoras");
            do {
                String texto[] = tmp.readLine().split(";");
                almacenar(texto[3], Integer.parseInt(texto[0]), texto[2], texto[1]);
            } while (tmp.ready());
        } catch (Exception e) {
            System.err.println("No BD");
        }
    }

    public ImpresoraDAO() {
        CargarFile();
    }
    public ImpresoraVO buscarXID(int id){
        return (ImpresoraVO)this.BDImpresora.buscarXID(id);
    }
}
