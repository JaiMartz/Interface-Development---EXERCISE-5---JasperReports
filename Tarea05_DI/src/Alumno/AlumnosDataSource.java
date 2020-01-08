/**
 * Módulo: Formulario
 * Archivo: AlumnosDataSource.java
 * Objetivo: Generar un Java Bean para crear el patron de datos de los alumnos
 * Equipo/Persona: Jairo Martínez Garrido
 */
package Alumno;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jairo
 */
public class AlumnosDataSource implements JRDataSource {
    
    private final ObservableList<Alumno> listaAlumnos = FXCollections.observableArrayList();
    private int indiceAlumnoActual = -1;
    
    /**
     * Devuelve los valores correspondientes a cada atributo de nuestro objeto Alumno.
     * @param jrf Recoge un parametro JRField
     * @return Devuelve el atributo valor
     * @throws JRException 
     */
    @Override
    public Object getFieldValue(JRField jrf) throws JRException{
        
        Object valor = null;
        
        if("DNI".equals(jrf.getName())){
            valor = listaAlumnos.get(indiceAlumnoActual).getDNI();
        }else if("Modulo".equals(jrf.getName())){
            valor = listaAlumnos.get(indiceAlumnoActual).getModulo();
        }else if("Nota".equals(jrf.getName())){
            valor = listaAlumnos.get(indiceAlumnoActual).getNota();
        }else if("Recuperacion".equals(jrf.getName())){
            valor = listaAlumnos.get(indiceAlumnoActual).getRecuperacion();
        }
        return valor;
    }
    /**
     * 
     * @return
     * @throws JRException 
     */
    @Override
    public boolean next() throws JRException{
        indiceAlumnoActual++;
        return indiceAlumnoActual<listaAlumnos.size();
    }
    /**
     * 
     * @param alumno 
     */
    public void addAlumno(Alumno alumno){
        this.listaAlumnos.add(alumno);
    }
}
