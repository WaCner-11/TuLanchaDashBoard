/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TuLancha;

/**
 *
 * @author warne
 */
public class Cliente {
    
    private String ID;
    private String nombre;
    private String apellidos;
    private char genero;

    public Cliente() {
    }

    public Cliente(String ID, String nombre, String apellidos, char genero) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("ID=").append(ID);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", genero=").append(genero);
        sb.append('}');
        return sb.toString();
    }
}
