package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Modelo.Usuario;

public class ControladorUsuario {
	
	private Usuario usuarioActual;
	private ConectorDB conector;
	
	
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}
	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	public ConectorDB getConector() {
		return conector;
	}
	public void setConector(ConectorDB conector) {
		this.conector = conector;
	}
	//crear metodo solo para conectar y llamar desde otros metodos siempre que sea != null;
	
	
	
	//iniciar sesion
	public void inciarSesion(String nombreUsuario, String contraseña) {
		//creas coneccion 
		ConectorDB conexion = new ConectorDB();
		Connection cn = null;
		Statement stm = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			String query = "SELECT * FROM t_user WHERE user_name = ?";
			pstm = cn.prepareStatement(query);
			pstm.setString(1, nombreUsuario);
			rs = pstm.executeQuery();
				if (rs.next()) {
					rs.close();
					String query2 = "SELECT * FROM t_user WHERE password = ?";
					pstm = cn.prepareStatement(query2);
					pstm.setString(2, contraseña);
					rs = pstm.executeQuery();
					if (rs.next()) {
						System.out.println("Usuario registrado...");
						//devolver fila y asignar a usuarioActual
						
						
					}else {	
					System.out.println("Contraseña incorrecta. Revise sus credenciales.");
					}
				}else {
					System.out.println("Usuario incorrecto. Revise sus credenciales.");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null) {
						rs.close();
					}
					if(stm != null) {
						stm.close();
					}
					if (cn != null) {
						cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//termina inicio de Sesion;
	
	
	
}
