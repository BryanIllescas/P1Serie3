/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoVendedor;
/**
 *
 * @author visitante
 */
public class clsVendedor {
    private int codigo_vendedor;
    private String nombre_vendedor;
    private String direccion_vendedor;
    private int telefono_vendedor;
    private int nit_vendedor;
    private int estatus_vendedor;

    public clsVendedor() {
    }
    
    public clsVendedor(int codigo_vendedor) {
        this.codigo_vendedor = codigo_vendedor;
    }    
    
    public clsVendedor(String nombre_vendedor, String direccion_vendedor, int telefono_vendedor, int nit_vendedor, int estatus_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
        this.direccion_vendedor = direccion_vendedor;
        this.telefono_vendedor = telefono_vendedor;
        this.nit_vendedor = nit_vendedor;
        this.estatus_vendedor = estatus_vendedor;
    }
    
    public clsVendedor(int codigo_vendedor, String nombre_vendedor, String direccion_vendedor, int telefono_vendedor, int nit_vendedor, int estatus_vendedor) {
        this.codigo_vendedor = codigo_vendedor;
        this.nombre_vendedor = nombre_vendedor;
        this.direccion_vendedor = direccion_vendedor;
        this.telefono_vendedor = telefono_vendedor;
        this.nit_vendedor = nit_vendedor;
        this.estatus_vendedor = estatus_vendedor;
    }    

    public int getcodigo_vendedor() {
        return codigo_vendedor;
    }

    public void setcodigo_vendedor(int codigo_vendedor) {
        this.codigo_vendedor = codigo_vendedor;
    }

    public String getnombre_vendedor() {
        return nombre_vendedor;
    }

    public void setnombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public String getdireccion_vendedor() {
        return direccion_vendedor;
    }

    public void setdireccion_vendedoro(String direccion_vendedor) {
        this.direccion_vendedor = direccion_vendedor;
    }
    public int getnit_vendedor() {
        return nit_vendedor;
    }

    public void setnit_vendedor(int nit_vendedor) {
        this.nit_vendedor = nit_vendedor;
    }
    public int getestatus_vendedor() {
        return estatus_vendedor;
    }

    public void setestatus_vendedor(int estatus_vendedor) {
        this.estatus_vendedor = estatus_vendedor;
    }
    @Override
    public String toString() {
        return "clsVendedor{" + "codigo_vendedor=" + codigo_vendedor + ", nombre_vendedor=" + nombre_vendedor + ", direccion_vendedor=" + direccion_vendedor + ", telefono_vendedor=" + telefono_vendedor + ", nit_vendedor=" + nit_vendedor + ", estatus_vendedor=" + estatus_vendedor + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsVendedor getBuscarInformacionVendedorPorNombre(clsVendedor nombre_vendedor)
    {
        daoVendedor daoVendedor = new daoVendedor();
        Object vendedor = null;
        return daoVendedor.consultaVendedorPorNombre((clsVendedor) vendedor);
    }
    public clsVendedor getBuscarInformacionVendedorPorId(clsVendedor codigo_vendedor)
    {
        daoVendedor daousuario = new daoVendedor();
        clsVendedor vendedor = null;
        return daousuario.consultaVendedorPorId(vendedor);
    }    
    public List<clsVendedor> getListadoVendedor()
    {
        daoVendedor daoVendedor = new daoVendedor();
        List<clsVendedor> listadoVendedor = daoVendedor.consultaVendedor();
        return listadoVendedor;
    }
    public int setBorrarVendedor(clsVendedor nombre_vendedor)
    {
        daoVendedor daoVendedor = new daoVendedor();
        clsVendedor vendedor = null;
        return daoVendedor.borrarVendedor(vendedor);
    }          
    public int setIngresarVendedor(clsVendedor nombre_vendedor)
    {
        daoVendedor daoVendedor = new daoVendedor();
        clsVendedor vendedor = null;
        return daoVendedor.ingresaVendedor(vendedor);
    }              
    public int setModificarVendedor(clsVendedor nombre_vendedor)
    {
        daoVendedor daoVendedor = new daoVendedor();
        clsVendedor vendedor = null;
        return daoVendedor.actualizaVendedor(vendedor);
    }              

    public void add(clsVendedor vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void nombre_vendedor(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setdireccion_vendedor(String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*public void setdireccion_vendedor(String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
