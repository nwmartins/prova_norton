package provanorton.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import provanorton.jdbc.ConnectionFactory;
import provanorton.model.Destino;

/**
 * @author Norton Wagner Martins
 * @date 19/09/2018
 */
public class DestinoDAO implements GenericDAO<Destino> {

    private Connection connection = null;

    @Override
    public void save(Destino entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO DESTINO(CD_DESTINO, DS_DESTINO, DT_INICIO,")
                    .append("DT_TERMINO, VL_TOTAL) VALUES (?,?,?,?,?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getDestino());
            pstm.setDate(3, entity.getDtInicio());
            pstm.setDate(4, entity.getDtTermino());
            pstm.setDouble(5, entity.getVlTotal());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir um Destino.");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
        
        /*try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERTO INTO DESTINO(CD_DESTINO, DS_DESTINO, DT_INICIO,")
                    .append("DT_TERMINO, VL_TOTAL) VALUES (?,?,?,?,?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getDestino());
            pstm.setDate(3, entity.getDtInicio());
            pstm.setDate(4, entity.getDtTermino());
            pstm.setDouble(5, entity.getVlTotal());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir um Destino.");
            ex.printStackTrace();
        } finally {
            connection.close();
        }*/
    }

    @Override
    public void update(Destino entity) throws SQLException {
        try{
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE DESTINO SET DS_DESTINO = ?, ")
                    .append("DT_INICIO = ?, DT_TERMINO = ?, ")
                    .append("VL_TOTAL = ? ")
                    .append("WHERE CD_DESTINO = ?");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getDestino());
            pstm.setDate(2, entity.getDtInicio());
            pstm.setDate(3, entity.getDtTermino());
            pstm.setDouble(4, entity.getVlTotal());
            pstm.setInt(5, entity.getCodigo());
            pstm.execute();
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Atualizar Destino");
            ex.printStackTrace();
        }finally{
            connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "DELETE FROM DESTINO WHERE CD_DESTINO = "+id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            pstm.close();            
        }catch (SQLException ex){
            System.out.println("Erro ao Deletar Destino");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
    }

    @Override
    public Destino getById(int id) throws SQLException {
        Destino destino = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM DESTINO WHERE CD_DESTINO = "+id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            destino = new Destino();
            while (rs.next()) {
                destino.setCodigo(rs.getInt("CD_DESTINO"));
                destino.setDestino(rs.getString("DS_DESTINO"));
                destino.setDtInicio(rs.getDate("DT_INICIO"));
                destino.setDtTermino(rs.getDate("DT_TERMINO"));
                destino.setVlTotal(rs.getDouble("VL_TOTAL"));
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Fazer a busca de Destino por ID");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return destino;
    }

    @Override
    public List<Destino> getByName(String name) throws SQLException {
        Destino destino = null;
        List<Destino> destinoList = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM DESTINO WHERE UPPER(DS_DESTINO) LIKE UPPER('%"+name+"%') ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            destinoList = new ArrayList<>();
            while (rs.next()) {
                destino = new Destino();
                destino.setCodigo(rs.getInt("CD_DESTINO"));
                destino.setDestino(rs.getString("DS_DESTINO"));
                destino.setDtInicio(rs.getDate("DT_INICIO"));
                destino.setDtTermino(rs.getDate("DT_TERMINO"));
                destino.setVlTotal(rs.getDouble("VL_TOTAL"));
                destinoList.add(destino);
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao consultar Destino por Nome");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return destinoList;
    }

    @Override
    public List<Destino> getAll() throws SQLException {
        Destino destino = null;
        List<Destino> destinoList = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM DESTINO ORDER BY CD_DESTINO";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            destinoList = new ArrayList<>();
            while (rs.next()) {
                destino = new Destino();
                destino.setCodigo(rs.getInt("CD_DESTINO"));
                destino.setDestino(rs.getString("DS_DESTINO"));
                destino.setDtInicio(rs.getDate("DT_INICIO"));
                destino.setDtTermino(rs.getDate("DT_TERMINO"));
                destino.setVlTotal(rs.getDouble("VL_TOTAL"));
                destinoList.add(destino);
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao consultar todos  os Destinos");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return destinoList;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_DESTINO),0)+1 AS MAIOR FROM DESTINO ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("MAIOR");
        }catch (SQLException ex){
            System.out.println("Erro ao consultar maior ID de Destino");
            ex.printStackTrace();
        }finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    } 

}
