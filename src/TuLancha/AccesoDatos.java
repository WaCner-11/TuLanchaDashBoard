/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TuLancha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author warne
 */
public class AccesoDatos {

    static ArrayList<Cliente> clientes = new ArrayList();

    static ArrayList<Venta> ventas = new ArrayList();

    static int cantMas = 0;

    static int cantFem = 0;

    public static void cargarInfoClientes() {
        BufferedReader br = null;
        clientes.clear();
        try {
            String line;
            File archivo = new File("C:\\Users\\warne\\OneDrive\\Escritorio\\TuLanchaDashBoard-master\\src\\TuLancha\\Clientes.csv");
            br = new BufferedReader(new FileReader(archivo));
            while ((line = br.readLine()) != null) {
                String[] atributos = line.split(",");
                if (!"ID".equals(atributos[0])) {
                    Cliente newClient = new Cliente(atributos[0], atributos[1],
                            atributos[2] + " " + atributos[3], atributos[4].charAt(0));
                    clientes.add(newClient);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public static void cargarInfoVentas() {
        BufferedReader br = null;
        ventas.clear();
        try {
            String line;
            File archivo = new File("C:\\Users\\warne\\OneDrive\\Escritorio\\TuLanchaDashBoard-master\\src\\TuLancha\\Ventas.csv");
            br = new BufferedReader(new FileReader(archivo));
            while ((line = br.readLine()) != null) {
                String[] atributos = line.split(",");
                if (!"totalVentas".equals(atributos[0])) {
                    Venta newVenta = new Venta(atributos[1], Integer.valueOf(atributos[0]));
                    ventas.add(newVenta);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public static void conteoXgenero() {
        for (Cliente cliente : clientes) {
            if(cliente.getGenero()=='F'){
                cantFem++;
            }
            else{
                cantMas++;
            }
        }
    }

//    public static void infoClientes() {
//        BufferedReader br = null;
//        clientes.clear();
//        try {
//            String line;
//            File archivo = new File("Clientes.csv");
//            br = new BufferedReader(new FileReader(archivo));
//            while ((line = br.readLine()) != null) {
//                String[] atributos = line.split(",");
//                if (!"ID".equals(atributos[0])) {
//                    Cliente pmv = new Cliente(atributos[0], atributos[1],
//                            atributos[2]);
//                    clientes.add(pmv);
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace(System.out);
//        } finally {
//            try {
//                br.close();
//            } catch (IOException ex) {
//                ex.printStackTrace(System.out);
//            }
//        }
//    }
}
