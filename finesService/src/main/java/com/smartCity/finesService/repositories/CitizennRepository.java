package com.smartCity.finesService.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.smartCity.finesService.entities.Citizen;
import com.smartCity.finesService.entities.Fine;

public class CitizennRepository {
	private Connection conn;

    public CitizennRepository() throws SQLException {
    	
       // conn = ConnectionDataBase.getConnection();
    }

 // Ajouter un citoyen
    public Citizen save(Citizen citizen) throws SQLException {
    	conn = ConnectionDataBase.getConnection();
        String sql = "INSERT INTO citizen(national_id_number, full_name, gender, nationality, phone_number, address, profession) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, citizen.getNationalIdNumber());
        ps.setString(2, citizen.getFullName());
        ps.setString(3, citizen.getGender());
        ps.setString(4, citizen.getNationnality());
        ps.setString(5, citizen.getPhoneNumber());
        ps.setString(6, citizen.getAddress());
        ps.setString(7, citizen.getProfession());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()) citizen.setId(rs.getLong(1));

        return citizen;
    }
    
    
    public List <Citizen> getCitizens() throws SQLException {
    	 conn = ConnectionDataBase.getConnection();
        String sql = "SELECT * FROM citizen";
        PreparedStatement rs = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet ListCitizen = rs.executeQuery();
        List<Citizen> citizens = new ArrayList<>();
        while( ListCitizen.next()) {
            Citizen citizen = new Citizen();
            citizen.setId(ListCitizen.getLong("id"));
            citizen.setNationalIdNumber(ListCitizen.getString("national_id_number"));
            citizen.setFullName(ListCitizen.getString("full_name"));
            citizen.setGender(ListCitizen.getString("gender"));
            citizen.setNationnality(ListCitizen.getString("nationality"));
            citizen.setPhoneNumber(ListCitizen.getString("phone_number"));
            citizen.setAddress(ListCitizen.getString("address"));
            citizen.setProfession(ListCitizen.getString("profession"));
            citizens.add(citizen);
        }

        return citizens;
    }
    
    
    public Citizen getCitizenById(Long id) throws SQLException {
    	 conn = ConnectionDataBase.getConnection();
    	Citizen citizen = new Citizen();
    	 PreparedStatement ps = conn.prepareStatement("SELECT * FROM citizen WHERE id = ?");
         ps.setLong(1, id);
         ResultSet rs = ps.executeQuery();
         if(rs.next()) {
             citizen = new Citizen();
             citizen.setId(rs.getLong("id"));
             citizen.setNationalIdNumber(rs.getString("national_id_number"));
             citizen.setFullName(rs.getString("full_name"));
             citizen.setGender(rs.getString("gender"));
             citizen.setNationnality(rs.getString("nationality"));
             citizen.setPhoneNumber(rs.getString("phone_number"));
             citizen.setAddress(rs.getString("address"));
             citizen.setProfession(rs.getString("profession"));
         }

        return citizen;
    }
    
    

    // Récupérer un citoyen avec ses amendes
    public List<Fine> findByIdWithFines(Long id) throws SQLException {
    	conn = ConnectionDataBase.getConnection();
    	List<Fine> fines = new ArrayList<>();
        Citizen citizen = null;

        // récupérer le citoyen
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM citizen WHERE id = ?");
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            citizen = new Citizen();
            citizen.setId(rs.getLong("id"));
            citizen.setNationalIdNumber(rs.getString("national_id_number"));
            citizen.setFullName(rs.getString("full_name"));
            citizen.setGender(rs.getString("gender"));
            citizen.setNationnality(rs.getString("nationality"));
            citizen.setPhoneNumber(rs.getString("phone_number"));
            citizen.setAddress(rs.getString("address"));
            citizen.setProfession(rs.getString("profession"));

            // récupérer les amendes liées
            PreparedStatement psFines = conn.prepareStatement("SELECT * FROM fine WHERE citizen_id = ?");
            psFines.setLong(1, id);
            ResultSet rsFines = psFines.executeQuery();
         
            while(rsFines.next()) {
                Fine fine = new Fine();
                fine.setId(rsFines.getLong("id"));
                fine.setAmount(rsFines.getDouble("amount"));
                fine.setCitizen_id(id);
                fines.add(fine);
            }
        }

        return fines;
    }
    

}
