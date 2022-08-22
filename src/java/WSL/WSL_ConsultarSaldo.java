/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSL;

import ModeloDAO.*;
import ModeloVO.*;
import javax.jws.*;

/**
 *Esta clase es la principal para el WSL
 * 
 * @author jhona
 * @version 1.0.0
 * @see 1.0.0
 */
@WebService(serviceName = "WSL_ConsultarSaldo")
public class WSL_ConsultarSaldo {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     *Este metodo consulta los datos d ela cuenta que tiene un cliente
     * 
     * @param idCuenta, Se requiere el id para saber el saldo
     * @return String, se retorna el saldo que tiene el usuario en la cuenta
     */
    @WebMethod(operationName = "consultarDinero")
    public String consultarDinero(@WebParam(name = "id") String idCuenta) {
        CuentaDAO cuentaDao = new CuentaDAO();
        CuentaVO cuentaVo = null;

        cuentaVo = cuentaDao.consultarCuentaPorId(idCuenta);

        return String.format("%.2f", Float.parseFloat(cuentaVo.getSaldo()));
//        return cuentaVo;
    }

    /**
     * Este metodo es para iniciar sesion
     * 
     * @param email, correo de inicio de sesion
     * @param pass, contraseña para iniciar sesion
     * @return boolean, retorna si el usuario existe o no en la bd
     */
    @WebMethod(operationName = "iniciarSesion")
    public boolean iniciarSesion(@WebParam(name = "email") String email, @WebParam(name = "pass") String pass) {
        UsuarioDAO cuentaDao = new UsuarioDAO();
        UsuarioVO usuarioVo = null;

        usuarioVo = cuentaDao.login(email, pass);

        // Se comprueba si el usuario existe en la bd
        return usuarioVo != null;
    }

    /**
     * Este metodo sirve para obtener informacion del cliente (informacion de distintas tablas y objetos)
     * @param idCliente, se require el id
     * @return Object, Retorna un array de objetos (Datos del cliente)
     */
    @WebMethod(operationName = "consultarDatosCliente")
    public Object[] consultarDatosCliente(@WebParam(name = "idCliente") String idCliente) {
        PruebaCuentaDAO pruebaCuentaDao = new PruebaCuentaDAO();

        Object[] objetos = pruebaCuentaDao.consultarDatosCliente(idCliente);

        return objetos;
    }

}
