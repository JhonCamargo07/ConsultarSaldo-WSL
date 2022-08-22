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
     * @return CuentaVO, se retorna el objeto que se consulto
     */
    @WebMethod(operationName = "consultarDinero")
    public CuentaVO consultarDinero(@WebParam(name = "id") String idCuenta) {
        CuentaDAO cuentaDao = new CuentaDAO();
        CuentaVO cuentaVo = null;

        cuentaVo = cuentaDao.consultarCuentaPorId(idCuenta);

//        return String.format("%.2f", Float.parseFloat(cuentaVo.getSaldo()));
        return cuentaVo;
    }

    /**
     * Este metodo es para iniciar sesion
     * 
     * @param email, correo de inicio de sesion
     * @param pass, contraseña para iniciar sesion
     * @return UsuarioVO, los datos del usuario que inicio sesion
     */
    @WebMethod(operationName = "iniciarSesion")
    public UsuarioVO iniciarSesion(@WebParam(name = "email") String email, @WebParam(name = "pass") String pass) {
        UsuarioDAO cuentaDao = new UsuarioDAO();
        UsuarioVO usuarioVo = null;

        usuarioVo = cuentaDao.login(email, pass);

        if (usuarioVo == null) {
            usuarioVo = new UsuarioVO(null, null, null, null);
        }

        return usuarioVo;
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
