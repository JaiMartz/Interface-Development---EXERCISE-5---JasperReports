/**
 * Módulo: Formulario
 * Archivo: vistaController.java
 * Objetivo: Generar un Java Bean para crear el patron de datos de los alumnos
 * Equipo/Persona: Jairo Martínez Garrido
 */
package controller;

import Alumno.AlumnoProperties;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * Clase vistaController. Controlador de la ventana principal
 * de la aplicacion.
 * @author Jairo
 * @version  1.0 final
 */

public class vistaController implements Initializable {
    
    //Creamos los elementos
    @FXML public Button btnGuardar;
    @FXML public TextField txfDNI;
    @FXML public TextField txfModulo;
    @FXML public TextField txfNota;
    @FXML public TextField txfRecuperacion;
    
    //Añadimos la tabla
    @FXML public TableView<AlumnoProperties> tablaAlumnos; 
    @FXML public TableColumn clDNI;
    @FXML public TableColumn clModulo;
    @FXML public TableColumn clNota;
    @FXML public TableColumn clRecuperacion;
    
    private final ObservableList<AlumnoProperties>listaAlumnos = FXCollections.observableArrayList();
    
    /**
     * Añadimos los objetos AlumnoProperties a la lista.
     */
    @FXML
    private void añadirAlumnos(){

        listaAlumnos.add(new AlumnoProperties("76652856C", "AD", 5, 0));
        listaAlumnos.add(new AlumnoProperties("76652856C", "PSP", 7, 0));
        listaAlumnos.add(new AlumnoProperties("12345752C", "PSP", 2, 4));
        listaAlumnos.add(new AlumnoProperties("12345672D", "AD", 8, 0));
        listaAlumnos.add(new AlumnoProperties("12345672E", "PSP", 1, 3));
        listaAlumnos.add(new AlumnoProperties("18761672F", "AD", 10, 0));
        listaAlumnos.add(new AlumnoProperties("76652856C", "SGE", 6, 0));
        listaAlumnos.add(new AlumnoProperties("0147672H", "SGE", 3, 3));
        listaAlumnos.add(new AlumnoProperties("97530872I", "AD", 6, 0));
        listaAlumnos.add(new AlumnoProperties("76652856C", "DI", 9, 0));
        listaAlumnos.add(new AlumnoProperties("01455672K", "PSP", 4, 4));
        listaAlumnos.add(new AlumnoProperties("05945672L", "AD", 7, 0));
        listaAlumnos.add(new AlumnoProperties("75345672M", "PSP", 8, 0));
        listaAlumnos.add(new AlumnoProperties("15945672N", "DI", 4, 5));
        listaAlumnos.add(new AlumnoProperties("75355672O", "DI", 5, 0));
        listaAlumnos.add(new AlumnoProperties("02145672P", "SGE", 1, 4));
        listaAlumnos.add(new AlumnoProperties("98515672Q", "DI", 9, 0));
        listaAlumnos.add(new AlumnoProperties("03125672R", "DI", 3, 2));
        listaAlumnos.add(new AlumnoProperties("12753672S", "SGE", 8, 0));
        listaAlumnos.add(new AlumnoProperties("18745672T", "SGE", 5, 0));
        
    }
    
    /**
     * Limpiamos los campos de texto.
     */
    @FXML
    private void limpiarCampos(){
    
        txfDNI.setText("");
        txfModulo.setText("");
        txfRecuperacion.setText("");
        txfNota.setText("");
    }
    /**
     * Crearmos una clase condicional para guardar la información en la tabla.
     * @param event Recoge el evento que activa la función.
     */
    @FXML
    private void accionGuardarNotas(ActionEvent event) {
        String dniRegExp = "\\d{8}[A-HJ-NP-TV-Z]";
        int parseNota = Integer.parseInt(txfNota.getText());
        int parseRecu = Integer.parseInt(txfRecuperacion.getText());
        
        String titError = "Error";
        String msgErrorInvalido = "El valor introducido no es válido, inténtelo de nuevo.\n"
                + "\n-Recuerde que la nota no puede ser mayor que 10"
                + "\n-Recuerde que la nota no puede ser menor que 0."
                + "\n-Recuerde que la nota de recuperacion no puede ser mayor que 5."
                + "\n-Recuerde que la nota de recuperacion no puede ser menor que 0."
                + "\n-Recuerde que DNI debe tener 8 digitos y 1 letra." ;
        String msgRecuError = "Si el alumno ha aprobado, no puede tener valor de recuperación";
        String msgDniError = "El DNI introducido no es valido, intentelo de nuevo.";
        
        if((parseNota<0) || (parseNota>10) || (parseRecu<0) ||(parseRecu>5)){
            JOptionPane.showConfirmDialog(null, msgErrorInvalido, titError, JOptionPane.ERROR_MESSAGE);
        }else if(!Pattern.matches(dniRegExp, txfDNI.getText())){
            JOptionPane.showConfirmDialog(null, msgDniError, titError, JOptionPane.ERROR_MESSAGE);
        }else if((parseNota>= 5)&&(parseRecu >= 5)){
            JOptionPane.showConfirmDialog(null, msgRecuError, titError, JOptionPane.ERROR_MESSAGE);
        }else{
            if(parseNota >= 5){
            parseRecu = 0;
            }
            AlumnoProperties Alumno = new AlumnoProperties(txfDNI.getText() ,txfModulo.getText(), Integer.parseInt(txfNota.getText()), parseRecu);
            listaAlumnos.add(Alumno);
            limpiarCampos();
        }
    }
    /**
     * Abre una ventana secundaria on la opcion de elegir el módulo 
     * por el que filtrar el informe.
     * @param event Recoge el evento que activa la función.
     */
    @FXML
    public void AbrirVentanaSecundaria(ActionEvent event){

        try {
            //Cargamos la vista de la ventana modal
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/views/VistaVentanaSecundaria.fxml"));
            
            Parent root = (Parent) fxml.load();

            //Creamos un Stage para poder mostrar la vista
            Stage stage = new Stage();
            stage.setTitle("Generacion de Informes");
            
            //Parametros ObservableList, recuperamos tabla
            ObservableList<AlumnoProperties> alumno = tablaAlumnos.getItems();
            //Cargamos el controller vistaController
            VistaSecundariaController controlador = fxml.getController();
            controlador.setObservableList(alumno);
            //Establecemos las medidas de la ventana
            stage.setScene(new Scene(root, 470, 322));
            
            //Mostramos la ventana
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(vistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clDNI.setCellValueFactory(new PropertyValueFactory<AlumnoProperties, String>("DNI"));
        clModulo.setCellValueFactory(new PropertyValueFactory<AlumnoProperties, String>("Modulo"));
        clNota.setCellValueFactory(new PropertyValueFactory<AlumnoProperties, Integer>("Nota"));
        clRecuperacion.setCellValueFactory(new PropertyValueFactory<AlumnoProperties, String>("Recuperacion"));
        
        añadirAlumnos();
        tablaAlumnos.setItems(listaAlumnos);
        
    }    
    
}
