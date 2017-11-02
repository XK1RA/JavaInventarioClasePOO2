/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BD.Bodega;
import FileLoad.Leer;
import FileSave.Guardar;
import VO.PersonasVO;
import java.io.BufferedReader;

/**
 *
 * @author Paula
 */
public class PersonasDAO {
    private Bodega BDPersona = new Bodega();    
    public boolean almacenar(int cedula, String nombre, String apellido) {
        PersonasVO tmp = new PersonasVO(cedula, nombre, apellido);
        return BDPersona.agregar(tmp);
    }

    /**
     * Metodo que retorna el tamaño de la base de datos
     *
     * @return
     */
    public int Size() {
        return BDPersona.getContador();
    }

    /**
     * Metodo que enlista los registros que esten guardados
     *
     * @return
     */
    public String ListaPersonas() {
        String Lista = "Lista de Personas  Almacenadas\n";
        Object tmp[] = BDPersona.GetBD();
        for (int i = 0; i < BDPersona.getContador(); i++) {
            PersonasVO Pers = (PersonasVO) tmp[i];
            Lista += (i + 1) + " Cedula N° " + Pers.getCedula() + " Nombre " + Pers.getNombre() + " Apellido " + Pers.getApellido() + "\n";
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
        Object tmp[] = BDPersona.GetBD();
        for (int i = 0; i < BDPersona.getContador(); i++) {
            PersonasVO Pers = (PersonasVO) tmp[i];
            cadena += Pers.getCedula() + ";" + Pers.getNombre() + ";" + Pers.getApellido() + "\r";
        }
        Guardar send = new Guardar();
        return send.almacenar("LasPersonas", cadena);
    }

    /**
     * Metodo que carga datos al archivo respetando certa estructura final si no
     * se encuentra datos a la ejecucion del programa retorna un mensaje con la
     * correspondiente alerta de no bases de datos
     */
    public void CargarFile() {
        try {
            Leer subir = new Leer();
            BufferedReader tmp = subir.cargaBU("LasPersonas");
            do {
                String texto[] = tmp.readLine().split(";");
                almacenar(Integer.parseInt(texto[0]), texto[1], texto[2]);
            } while (tmp.ready());
        } catch (Exception e) {
            System.err.println("No BD");
        }
    }

    public PersonasDAO() {
        CargarFile();
    }

    public PersonasVO buscarXCedula(int Cedula) {
        Object tmp[] = BDPersona.GetBD();
        for (int i = 0; i < BDPersona.getContador(); i++) {
            PersonasVO Pers = (PersonasVO) tmp[i];
            if (Pers.getCedula() == Cedula) {
                return Pers;
            }
        }
        return null;
    }
}
