package provanorton.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import provanorton.jdbc.ConnectionFactory;
import provanorton.model.Custo;
import provanorton.model.Destino;

/**
 * @author Norton Wagner Martins  
 * @date 19/09/2018
 */
public class CustoDAO implements GenericDAO<Custo>{
    private Connection connection = null;
    private DestinoDAO destinoDAO;

    @Override
    public void save(Custo entity) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO CUSTO(CD_CUSTO, CD_DESTINO, DS_CUSTO,")
                    .append("TP_CUSTO, VL_CUSTO) VALUES (?,?,?,?,?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setInt(2, entity.getDestino().getCodigo());
            pstm.setString(3, entity.getDsCusto());
            pstm.setInt(4, entity.getTpCusto());
            pstm.setDouble(5, entity.getVlCusto());
            pstm.execute();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir um Custo.");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    @Override
    public void update(Custo entity) throws SQLException {
        try{
            this.connection = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CUSTO SET CD_DESTINO = ?, ")
                    .append("DS_CUSTO = ?, TP_CUSTO = ?, ")
                    .append("VL_CUSTO = ? ")
                    .append("WHERE CD_CUSTO = ?");
            
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getDestino().getCodigo());
            pstm.setString(2, entity.getDsCusto());
            pstm.setInt(3, entity.getTpCusto());
            pstm.setDouble(4, entity.getVlCusto());
            pstm.setInt(5, entity.getCodigo());
            pstm.execute();
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Atualizar Custo");
            ex.printStackTrace();
        }finally{
            connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "DELETE FROM CUSTO WHERE CD_CUSTO = "+id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.execute();
            pstm.close();            
        }catch (SQLException ex){
            System.out.println("Erro ao Deletar Custo");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
    }

    @Override
    public Custo getById(int id) throws SQLException {
        Custo custo = null;
        DestinoDAO destinoDAO = new DestinoDAO();
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM CUSTO WHERE CD_CUSTO = "+id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            custo = new Custo();
            while (rs.next()) {
                custo.setCodigo(rs.getInt("CD_CUSTO"));
                custo.setDestino(destinoDAO.getById(rs.getInt("CD_DESTINO")));
                custo.setDsCusto(rs.getString("DS_CUSTO"));
                custo.setTpCusto(rs.getInt("TP_CUSTO"));
                custo.setVlCusto(rs.getDouble("VL_CUSTO"));
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao Fazer a busca de Custo por ID");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return custo;
    }

    @Override
    public List<Custo> getByName(String name) throws SQLException {
        Custo custo = null;
        List<Custo> custoList = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM CUSTO WHERE UPPER(DS_CUSTO) LIKE UPPER('%"+name+"%') ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            custoList = new ArrayList<>();
            while (rs.next()) {
                custo = new Custo();
                custo.setCodigo(rs.getInt("CD_DESTINO"));
                custo.setDestino(destinoDAO.getById(rs.getInt("CD_DESTINO")));
                custo.setDsCusto(rs.getString("DS_CUSTO"));
                custo.setTpCusto(rs.getInt("TP_CUSTO"));
                custo.setVlCusto(rs.getDouble("VL_CUSTO"));
                custoList.add(custo);
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao consultar Custo por Descricao");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return custoList;
    }

    @Override
    public List<Custo> getAll() throws SQLException {
        destinoDAO = new DestinoDAO();
        Custo custo = null;
        List<Custo> custoList = null;
        try{
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM CUSTO ORDER BY CD_CUSTO";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            custoList = new ArrayList<>();
            while (rs.next()) {
                custo = new Custo();
                custo.setCodigo(rs.getInt("CD_CUSTO"));
                custo.setDestino((destinoDAO.getById(rs.getInt("CD_DESTINO"))));
                custo.setDsCusto(rs.getString("DS_CUSTO"));
                custo.setTpCusto(rs.getInt("TP_CUSTO"));
                custo.setVlCusto(rs.getDouble("VL_CUSTO"));
                custoList.add(custo);
            }
            pstm.close();
        }catch (SQLException ex){
            System.out.println("Erro ao consultar todos os Custos");
            ex.printStackTrace();
        }finally {
            this.connection.close();
        }
        return custoList;
    } 

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = new ConnectionFactory().getConnection();
            String sql = "SELECT COALESCE(MAX(CD_CUSTO),0)+1 AS MAIOR FROM CUSTO ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next())
                return rs.getInt("MAIOR");
        }catch (SQLException ex){
            System.out.println("Erro ao consultar maior ID de Custo");
            ex.printStackTrace();
        }finally {
            pstm.close();
            this.connection.close();
        }
        return 1;
    } 

}
