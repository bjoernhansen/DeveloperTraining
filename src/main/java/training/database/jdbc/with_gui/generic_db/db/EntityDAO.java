package training.database.jdbc.with_gui.generic_db.db;

import training.database.DatabaseAccessData;
import training.database.jdbc.with_gui.generic_db.model.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EntityDAO
{
    public List<Entity> findAll(String tableName)
    {
        List<Entity> entityList = new ArrayList<>();
        try
        {
            Connection con = DBConnect.getConnection();
            Statement selectStatement = con.createStatement();
            ResultSet rs = selectStatement.executeQuery("SELECT * FROM " + tableName);
            while(rs.next())
            {
                Entity e = new Entity();
                e.setTableName(tableName);
                for(String fieldName : getFieldNames(tableName))
                {
                    e.addField(fieldName, rs.getObject(fieldName));
                }
                entityList.add(e);
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return entityList;
    }
    
    public List<String> getFieldNames(String tableName)
    {
        List<String> list = new ArrayList<>();
        try
        {
            Connection con = DBConnect.getConnection();
            String sql = "select * from " + tableName + " LIMIT 0";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData mrs = rs.getMetaData();
            for(int i = 1; i <= mrs.getColumnCount(); i++)
            {
                list.add(mrs.getColumnLabel(i));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args)
    {
        System.out.println(new EntityDAO().findAll(DatabaseAccessData.PREFERRED_TABLE));
    }
}
