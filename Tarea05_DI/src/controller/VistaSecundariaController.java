/**
 * Módulo: Formulario
 * Archivo: VistaSecundariaController.java
 * Objetivo: Generar un Java Bean para crear el patron de datos de los alumnos
 * Equipo/Persona: Jairo Martínez Garrido
 */
package controller;

import Alumno.Alumno;
import Alumno.AlumnoProperties;
import Alumno.AlumnosDataSource;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.fxutils.viewer.JasperViewerFX;

/**
 * Clase VistaSecundariaController. Controlador de la ventana secundaria
 * de la aplicacion.
 * @author Jairo
 * @version  1.0 final
 */
public class VistaSecundariaController implements Initializable {


    @FXML
    private TableView tabla;
    @FXML
    private Button InformeGlobal;
    @FXML
    private ComboBox cmBox;
    @FXML
 
    private ObservableList<AlumnoProperties> tablaAlumnos;
    
/**
 * Genera los informes globales
 * @param event Recoge el evento que activa el método.
 */
    @FXML
    private void informeGlobal(ActionEvent event){
        try{
            
            AlumnosDataSource datasource = new AlumnosDataSource();
            
            for(AlumnoProperties alumn: tablaAlumnos){
                
                    datasource.addAlumno(new Alumno(alumn.getDNI(),alumn.getModulo(),alumn.getNota(),alumn.getRecuperacion()));  
            }
                    JasperReport informe = (JasperReport) 
                        JRLoader.loadObjectFromFile("E:\\NetBeansProjects\\Segundo_Cuatrimestre\\Tarea05_DI\\src\\Informes\\informeGlobal.jasper");
                    JasperPrint impresionInforme = JasperFillManager.fillReport(informe, null, datasource);

                    //Visualizacion del informe
                    JasperViewer visualizadorInformes = new JasperViewer(impresionInforme, false);
                    visualizadorInformes.setTitle("Grafico de calificaciones");
                    visualizadorInformes.setVisible(true);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Genera los informes por asignatura.
     * @param event Recoge el evento que activa el método.
     */
    @FXML
    private void informeAsignaturas(ActionEvent event){
        AlumnosDataSource datasource = new AlumnosDataSource();
        
        for(AlumnoProperties alumn: tablaAlumnos){
            
           if(cmBox.getValue().equals(alumn.getModulo())){
               datasource.addAlumno(new Alumno(alumn.getDNI(),alumn.getModulo(),alumn.getNota(),alumn.getRecuperacion()));
           }
        }
                try{
                    JasperReport informe = (JasperReport) 
                        JRLoader.loadObjectFromFile("E:\\NetBeansProjects\\Segundo_Cuatrimestre\\Tarea05_DI\\src\\Informes\\informeAsignaturas.jasper");
                    JasperPrint impresionInforme = JasperFillManager.fillReport(informe, null, datasource);

                    //Visualizacion del informe
                    JasperViewer visualizadorInformes = new JasperViewer(impresionInforme, false);
                    visualizadorInformes.setTitle("Grafico de calificaciones");
                    visualizadorInformes.setVisible(true);
                } catch (JRException ex) {
                    System.out.println(ex.getCause());
                }  
    }
    /**
     * Establece las opciones dentro del combobox.
     * @return Devuelve el valor de asignaturas.
     */
    @FXML
    private ObservableList comboBox(){
    
        ObservableList<String> Asignaturas = FXCollections.observableArrayList();
        Asignaturas.addAll("AD","PSP","DI","SGE");
        return Asignaturas;
    }
    /**
     * Establece el valor del ObservableList.
     * @param observable Parametro que representa el valor del ObservableList.
     */
    public void setObservableList(ObservableList<AlumnoProperties> observable){
        this.tablaAlumnos = observable;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmBox.setItems(comboBox());
        cmBox.setValue("AD");
        cmBox.setVisibleRowCount(4);
    }    
    
}
