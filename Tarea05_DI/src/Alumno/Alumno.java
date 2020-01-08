/**
 * Módulo: Formulario
 * Archivo: alumno.java
 * Objetivo: Generar un Java Bean para crear el patron de datos de los alumnos
 * Equipo/Persona: Jairo Martínez Garrido
 */
package Alumno;

/**
 * Clase Alumno. Datos relevantes de un alumno.
 * @author Jairo
 * @version  1.0 final
 */
public class Alumno {
    
    private String DNI;
    private String Modulo;
    private int Nota;
    private int Recuperacion;
    
    /**
     * Contructor de la clase Alumno.
     * @param DNI Almacena un valor tipo String.
     * @param Modulo Almacena un valor tipo String.
     * @param Nota Almacena un valor tipo int.
     * @param Recuperacion Almacena un valor tipo int.
     */
    public Alumno(String DNI, String Modulo, int Nota, int Recuperacion) {
        this.DNI = DNI;
        this.Modulo = Modulo;
        this.Nota = Nota;
        this.Recuperacion = Recuperacion;
    }
    /**
     * Metodo que permite consultar el dni de un alumno.
     * @return Devuelve el valor del atributo dni.
     */
    public String getDNI() {
        return DNI;
    }
    /**
     * Método que permite establecer el valor del dni de un alumno.
     * @param DNI Parámetro que representa el dni del alumno que
     * se desea asignar.
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    /**
     * Método que permite consultar el modulo de un alumno.
     * @return Devuelve el valor del atributo modulo.
     */
    public String getModulo() {
        return Modulo;
    }
    /**
     * Método que permite establecer el valor del modulo de un alumno.
     * @param Modulo Parámetro que representa el modulo del alumno que
     * se desea asignar.
     */
    public void setModulo(String Modulo) {
        this.Modulo = Modulo;
    }
    /**
     * Método que permite consultar la nota de un alumno.
     * @return Devuelve el valor del atributo nota.
     */
    public int getNota() {
        return Nota;
    }
    /**
     * Método que permite establecer el valor de la nota de un alumno.
     * @param Nota Parámetro que representa la nota del alumno que
     * se desea asignar.
     */
    public void setNota(int Nota) {
        this.Nota = Nota;
    }
    /**
     * Método que permite consultar la recuperación de un alumno.
     * @return Devuelve el valor del atributo recuperación.
     */
    public int getRecuperacion() {
        return Recuperacion;
    }
    /**
     * Método que permite establecer el valor de recuperacion de un alumno.
     * @param Recuperacion Parámetro que representa el dni del alumno que
     * se desea asignar.
     */
    public void setRecuperacion(int Recuperacion) {
        this.Recuperacion = Recuperacion;
    }
}
