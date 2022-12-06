/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package TuLancha;

import static TuLancha.AccesoDatos.ventas;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author warne
 */
public class FXMLDashboardController implements Initializable {

    private Label label;
    @FXML
    private BarChart<?, ?> grafBarChart;
    @FXML
    private PieChart grafPieChart;
    @FXML
    private TableView tableView1;
    @FXML
    private LineChart<?, ?> Graf2LineChart;
    @FXML
    private TableColumn column_id;
    @FXML
    private TableColumn column_nombre;
    @FXML
    private TableColumn column_apellidos;

    private ObservableList<Cliente> clientes;
    @FXML
    private TableColumn<?, ?> column_genero;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Lectura de archivos
        AccesoDatos.cargarInfoClientes();
        AccesoDatos.cargarInfoVentas();
        
        //carga de componentes graficos
        //Grafico de lineas:
        ArrayList<Venta> ventas= AccesoDatos.ventas;
        Graf2LineChart.setTitle("Ventas por año:");
        cargarLineChart2021();
      
        
        //Tabla:
        clientes = FXCollections.observableArrayList(AccesoDatos.clientes);
        this.column_id.setCellValueFactory(new PropertyValueFactory("ID"));
        this.column_nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.column_apellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.column_genero.setCellValueFactory(new PropertyValueFactory("genero"));
        cargarTable();
        
        //Grafico pastel
        AccesoDatos.conteoXgenero();
        int cantMasc=AccesoDatos.cantMas;
        int cantFem=AccesoDatos.cantFem;
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                            new PieChart.Data("Femenino", cantFem),
                            new PieChart.Data("Masculino", cantMasc));
        
        grafPieChart.setData(pieChartData);
        
    }

    public void cargarTable() {
        tableView1.setItems(clientes);
    }
    
    public void cargarLineChart2021(){
        XYChart.Series series2021 = new  XYChart.Series();
        XYChart.Series series2022 = new  XYChart.Series();
        series2021.setName("2021");
        series2022.setName("2022");
        for (int i=0; i<24; i++) {
           if (i<12){
           series2021.getData().add(new XYChart.Data(ventas.get(i).getMes(),ventas.get(i).getTotalVentas()));
           }else{
           series2022.getData().add(new XYChart.Data(ventas.get(i).getMes(),ventas.get(i).getTotalVentas()));
           }
        }
        Graf2LineChart.getData().addAll(series2021,series2022);
    }

}
