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
    private int IdUsuario;
    private String NombreUsuario;
    private String ContrasenaUsuario;

    public clsVendedor() {
    }
    
    public clsVendedor(int IdVendedor) {
        this.IdVendedor = IdVendedor;
    }    
    
    public clsVendedor(String NombreUsuario, String ContrasenaUsuario) {
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
    }
    
    public clsVendedor(int IdUsuario, String NombreUsuario, String ContrasenaUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
    }    

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContrasenaUsuario() {
        return ContrasenaUsuario;
    }

    public void setContrasenaUsuario(String ContrasenaUsuario) {
        this.ContrasenaUsuario = ContrasenaUsuario;
    }
    @Override
    public String toString() {
        return "clsVendedor{" + "IdUsuario=" + IdUsuario + ", NombreUsuario=" + NombreUsuario + ", ContrasenaUsuario=" + ContrasenaUsuario + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsVendedor getBuscarInformacionVendedorPorNombre(clsVendedor Vendedor)
    {
        daoVendedor daoVendedor = new daoVendedor();
        return daoVendedor.consultaVendedorPorNombre(Vendedor);
    }
    public clsUsuario getBuscarInformacionUsuarioPorId(clsUsuario usuario)
    {
        daoVendedor daousuario = new daoVendedor();
        return daousuario.consultaUsuariosPorId(usuario);
    }    
    public List<clsUsuario> getListadoUsuarios()
    {
        daoVendedor daousuario = new daoVendedor();
        List<clsUsuario> listadoUsuarios = daousuario.consultaVendedor();
        return listadoUsuarios;
    }
    public int setBorrarUsuario(clsUsuario usuario)
    {
        daoVendedor daousuario = new daoVendedor();
        return daousuario.borrarVendedor(usuario);
    }          
    public int setIngresarUsuario(clsUsuario usuario)
    {
        daoVendedor daousuario = new daoVendedor();
        return daousuario.ingresaVendedor(usuario);
    }              
    public int setModificarUsuario(clsUsuario usuario)
    {
        daoVendedor daousuario = new daoVendedor();
        return daousuario.actualizaVendedor(usuario);
    }              
}
