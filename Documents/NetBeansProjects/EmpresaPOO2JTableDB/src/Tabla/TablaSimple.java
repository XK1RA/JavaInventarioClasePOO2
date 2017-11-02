/*
 * TablaSimple.java
 *
 * Created on 14 de junio de 2007, 09:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package Tabla;

/**
 * Demostraci�n del uso y presencia de una JTable Swing. Se puede observar que
 * resulta muy sencillo el manejo y la implementaci�n de hojas de c�lculo o de
 * tablas en el sentido literal de la palabra
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.Vector;

// El Modelo de la Tabla es el que controla todos los
// datos que se colocan en ella
public class TablaSimple extends AbstractTableModel {

    String[] attributeNames;

    String[][] datos;

    /* = {
    {1,2,3,"cuatro"},
    {"cinco","seis","siete","ocho"},
    {"nueve","diez","once","doce"},
    };*/

    // Esta clase imprime los datos en la consola cada vez
    // que se produce un cambio en cualquiera de las
    // casillas de la tabla
    class TablaListener implements TableModelListener {

        public void tableChanged(TableModelEvent evt) {
        }
    }

    /**
     * Constructor de la clase
     */
    public TablaSimple(String[] at, String[][] a) {
        attributeNames = at;
        datos = a;
        addTableModelListener(new TablaListener());
    }

    // Constructor
    public TablaSimple() {
        addTableModelListener(new TablaListener());
    }

    // Devuelve el n�mero de columnas de la tabla
    public int getColumnCount() {
        return (datos[0].length);
    }

    public String getColumnName(int i) {
        return (attributeNames[i]);
    }

    // Devuelve el n�mero de filas de la tabla
    public int getRowCount() {
        return (datos.length);
    }

    // Devuelve el valor de una determinada casilla de la tabla
    // identificada mediante fila y columna
    public Object getValueAt(int fila, int col) {
        return datos[fila][col];
    }

    // Cambia el valor que contiene una determinada casilla de
    // la tabla
    public void setValueAt(int valor, int fila, int col) {
        //   datos[fila][col] = valor;
        // Indica que se ha cambiado
        fireTableDataChanged();
    }

    // Indica si la casilla identificada por fila y columna es
    // editable
    public boolean isCellEditable(int fila, int col) {
        return (true);
    }
}
