package com.smartCity.finesService.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.smartCity.finesService.entities.Fine;

public class FinesRepository {
	private Connection conn;

    public FinesRepository() throws SQLException {
    	/*String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String pass = System.getenv("DB_PASSWORD");
        conn = DriverManager.getConnection(url, user, pass);*/

    }
    
 // Ajouter un fine
    public Fine save(Fine fine) throws SQLException {
    	 conn = ConnectionDataBase.getConnection();
        String sql = "INSERT INTO fine(amount, paid, reason, citizen_id) VALUES (?,?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setDouble(1, fine.getAmount());
        ps.setBoolean(2, fine.isPaid());
        ps.setString(3, fine.getReason());
        ps.setLong(4, fine.getCitizen_id());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()) fine.setId(rs.getLong(1));

        return fine ;
    }
    
 // Afficher la liste des fines
    public List<Fine> getFines() throws SQLException {
    	 conn = ConnectionDataBase.getConnection();
    	 String sql = "SELECT * FROM fine";
         PreparedStatement rs = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         ResultSet ListFines = rs.executeQuery();
         List<Fine> fines = new ArrayList<>();
         while( ListFines.next()) {
             Fine fine = new Fine();
             fine.setId(ListFines.getLong("id"));
             fine.setAmount(ListFines.getDouble("amount"));
             fine.setPaid(ListFines.getBoolean("paid"));;
             fine.setReason(ListFines.getString("reason"));;
             fines.add(fine);
         }

         return fines;
    }
    
    
    public Fine getFineById(Long id) throws SQLException {
    	conn = ConnectionDataBase.getConnection();
    	Fine fine = new Fine();
    	 PreparedStatement ps = conn.prepareStatement("SELECT * FROM fine WHERE id = ?");
         ps.setLong(1, id);
         ResultSet rs = ps.executeQuery();
         if(rs.next()) {  
             fine.setId(rs.getLong("id"));
             fine.setAmount(rs.getDouble("amount"));
             fine.setPaid(rs.getBoolean("paid"));;
             fine.setReason(rs.getString("reason"));;         }

        return fine;
    }
}
