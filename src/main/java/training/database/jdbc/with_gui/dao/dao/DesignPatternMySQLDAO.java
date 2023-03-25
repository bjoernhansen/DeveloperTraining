package training.database.jdbc.with_gui.dao.dao;

import training.database.jdbc.with_gui.dao.model.DesignPattern;
import training.database.jdbc.with_gui.dao.db.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DesignPatternMySQLDAO implements DesignPatternDAO
{
    
    @Override
    public boolean save(DesignPattern d)
    {
        try
        {
            Connection con = DBConnect.getInstance()
                                      .getConnection();
            final String q = "INSERT INTO designpattern (name,beschreibung) VALUES (?,?)";
            PreparedStatement inserStatement = con.prepareStatement(q);
            inserStatement.setString(1, d.getName());
            inserStatement.setString(2, d.getBeschreibung());
            return inserStatement.executeUpdate() == 1;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<DesignPattern> findAll()
    {
        Connection con = DBConnect.getInstance()
                                  .getConnection();
        List<DesignPattern> personList = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM designpattern"))
        {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                DesignPattern p = new DesignPattern();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setBeschreibung(rs.getString("beschreibung"));
                personList.add(p);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return personList;
    }
}
