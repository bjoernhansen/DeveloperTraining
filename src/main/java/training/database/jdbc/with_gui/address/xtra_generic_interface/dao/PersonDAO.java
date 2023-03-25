package training.database.jdbc.with_gui.address.xtra_generic_interface.dao;

import training.database.jdbc.with_gui.address.xtra_generic_interface.model.Person;

import java.util.List;


public interface PersonDAO<T extends Person> extends GenericDAO<Person>
{
    /**
     * special Person dao-methods
     */
    
    public List<T> findPersonsByPLZ(String plz);
}
