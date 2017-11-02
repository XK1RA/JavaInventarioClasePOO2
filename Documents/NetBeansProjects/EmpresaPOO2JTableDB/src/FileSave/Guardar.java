/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSave;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author servermini
 */
public class Guardar {

    public boolean almacenar(String NombreFile, String data) {
        try {
//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File(NombreFile + ".CSV");
//Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo);
//Escribimos en el archivo con el metodo write 
            escribir.write(data);
//Cerramos la conexion
            escribir.close();
            return true;
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            return false;
        }
    }
}
