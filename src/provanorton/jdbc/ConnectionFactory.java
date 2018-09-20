package provanorton.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Norton Wagner Martins
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        try {
            //jdbc do postgres/endereço/ porta/ database
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/viajemdb",
                    "postgres","postgres");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar uma "
                    + "conexão com o banco de dados "+
                    ex.getMessage());
        }
        return null;
    }    
    
}
