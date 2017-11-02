/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.Bodega;
import FileLoad.Leer;
import FileSave.Guardar;
import VO.CPUVO;
import VO.MarcaVO;
import java.io.BufferedReader;

/**
 *
 * @author Paula
 */
public class CPUDAO {
    private Bodega BDCpu = new Bodega();
    

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
    public boolean almacenar(String Memoria, String Disco, int codigo, String serie, String marca) {
        CPUVO tmp = new CPUVO(Memoria, Disco, codigo, serie, marca);
        return BDCpu.agregar(tmp);
    }

    /**
     * Metodo que retorna el tamaño de la base de datos
     *
     * @return
     */
    public int Size() {
        return BDCpu.getContador();
    }

    /**
     * Metodo que enlista los registros que esten guardados
     *
     * @return
     */
    public String ListaCPU(MarcaDAO LasMarcas) {
        String Lista = "Lista de CPU Almacenados\n";
        Object tmp[] = BDCpu.GetBD();
        for (int i = 0; i < BDCpu.getContador(); i++) {
            CPUVO Cpu = (CPUVO) tmp[i];
            MarcaVO estaES= LasMarcas.BuscarNombre(Integer.parseInt(Cpu.getMarca()));
            Lista += (i + 1) + " el ID= " + Cpu.getCodigo() + " Marca= " + estaES.getNombre() + " Seria= " + Cpu.getSerie()+ " Capacidad: "+Cpu.getMemoria()+ ";"+Cpu.getDisco() + "\n";
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
        Object tmp[] = BDCpu.GetBD();
        for (int i = 0; i < BDCpu.getContador(); i++) {
            CPUVO Cpu = (CPUVO) tmp[i];
            cadena +=  Cpu.getCodigo()+ ";" + Cpu.getMarca() + ";" + Cpu.getSerie() + ";" + Cpu.getDisco()+ ";" + Cpu.getMemoria() + "\r";
        }
        Guardar send = new Guardar();
        return send.almacenar("LosCpu", cadena);
    }

    /**
     * Metodo que carga datos al archivo respetando certa estructura final si no
     * se encuentra datos a la ejecucion del programa retorna un mensaje con la
     * correspondiente alerta de no bases de datos
     */
    public void CargarFile() {
        try {
            Leer subir = new Leer();
            BufferedReader tmp = subir.cargaBU("LosCpu");
            do {
                String texto[] = tmp.readLine().split(";");
                almacenar(texto[4], texto[3], Integer.parseInt(texto[0]), texto[2], texto[1]);
            } while (tmp.ready());
        } catch (Exception e) {
            System.err.println("No BD");
        }
    }

    public CPUDAO() {
        CargarFile();
    }

    public CPUVO buscarXID(int id){
        return (CPUVO)this.BDCpu.buscarXID(id);
    }
}
