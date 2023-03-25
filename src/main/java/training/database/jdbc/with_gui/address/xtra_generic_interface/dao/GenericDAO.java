package training.database.jdbc.with_gui.address.xtra_generic_interface.dao;

import java.util.List;

public interface GenericDAO<T>
{
    
    /**
     * @return
     */
    List<T> findAll();
    
    boolean save(T typ);
    
    boolean delete(int id);
    
    boolean update(int id, String fieldName, String newValue);
    
}