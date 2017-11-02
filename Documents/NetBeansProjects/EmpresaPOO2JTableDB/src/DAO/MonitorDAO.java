/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.Bodega;
import FileLoad.Leer;
import FileSave.Guardar;
import Tabla.TablaSimple;
import VO.MarcaVO;
import VO.MonitorVO;
import java.io.BufferedReader;

/**
 *
 * @author Paula
 */
public class MonitorDAO {

    private Bodega BDMonitor = new Bodega();

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
    public boolean almacenar(double pulgada, String tipo, String Resolucion, int codigo, String serie, String marca) {
        MonitorVO tmp = new MonitorVO(pulgada, tipo, Resolucion, codigo, serie, marca);
        return BDMonitor.agregar(tmp);
    }

    /**
     * Metodo que retorna el tamaño de la base de datos
     *
     * @return
     */
    public int Size() {
        return BDMonitor.getContador();
    }

    /**
     * Metodo que enlista los registros que esten guardados
     *
     * @return
     */
    public String ListaMonitor(MarcaDAO LasMarcas) {
        String Lista = "Lista de Monitores Almacenados\n";
        Object tmp[] = BDMonitor.GetBD();

        for (int i = 0; i < BDMonitor.getContador(); i++) {
            MonitorVO Moni = (MonitorVO) tmp[i];
            MarcaVO estaES = LasMarcas.BuscarNombre(Integer.parseInt(Moni.getMarca()));
            Lista += (i + 1) + "El monitor con ID: " + Moni.getCodigo() + " Resolucion: " + Moni.getResolucion() + " La serie es: " + Moni.getSerie() + " tipo: " + Moni.getTipo() + " La marca es: " + estaES.getNombre() + "\n";
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
        Object tmp[] = BDMonitor.GetBD();
        for (int i = 0; i < BDMonitor.getContador(); i++) {
            MonitorVO Moni = (MonitorVO) tmp[i];
            cadena += Moni.getMarca() + ";" + Moni.getSerie() + ";" + Moni.getTipo() + ";" + Moni.getCodigo() + ";" + Moni.getPulgada() + ";" + Moni.getResolucion() + "\r\n";

        }
        Guardar send = new Guardar();
        return send.almacenar("LosMonitoresParc", cadena);
    }

    /**
     * Metodo que carga datos al archivo respetando certa estructura final si no
     * se encuentra datos a la ejecucion del programa retorna un mensaje con la
     * correspondiente alerta de no bases de datos
     */
    public void CargarFile() {
        try {
            Leer subir = new Leer();
            BufferedReader tmp = subir.cargaBU("LosMonitoresParc");
            do {
                String texto[] = tmp.readLine().split(";");
                almacenar(Double.parseDouble(texto[4]), texto[2], texto[5], Integer.parseInt(texto[3]), texto[1], texto[0]);
            } while (tmp.ready());
        } catch (Exception e) {
            System.err.println("No BD");
        }
    }

    public MonitorDAO() {
        CargarFile();
    }

    public MonitorVO buscarXID(int id) {
        return (MonitorVO) this.BDMonitor.buscarXID(id);
    }

    /**
     * metodo que genera una tabla y la llena con los datos que se encuentran en
     * la base de datos
     *
     * @param LasMarcas
     * @return
     */
    public TablaSimple crearTabla(MarcaDAO LasMarcas, MarcaVO filtro) {
        String titulos[] = {"ID", "MARCA", "SERIE", "TIPO", "PULGADA", "RESOLUCIÓN"};
        int limite = Size();
        String datos[][] = new String[limite][titulos.length];
        Object canasta[] = BDMonitor.GetBD();
        int encontro = 0;
        for (int i = 0; i < BDMonitor.getContador(); i++) {
            MonitorVO Moni = (MonitorVO) canasta[i];//"ID","MARCA","SERIE","TIPO","PULGADA","RESOLUCIÓN"
            if (Integer.parseInt(Moni.getMarca()) == filtro.getID() || filtro.getID() == 0) {
                datos[encontro][0] = "" + Moni.getCodigo();
                MarcaVO estaEs = LasMarcas.BuscarNombre(Integer.parseInt(Moni.getMarca()));
                datos[encontro][1] = estaEs.getNombre();
                datos[encontro][2] = Moni.getSerie();
                datos[encontro][3] = Moni.getTipo();
                datos[encontro][4] = "" + Moni.getPulgada();
                datos[encontro][5] = Moni.getResolucion();
                encontro++;
            }
        }
        TablaSimple tmp = new TablaSimple(titulos, datos);
        return tmp;
    }
}
