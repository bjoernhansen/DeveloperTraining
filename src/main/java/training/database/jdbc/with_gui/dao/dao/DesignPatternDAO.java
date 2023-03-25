package training.database.jdbc.with_gui.dao.dao;


import training.database.jdbc.with_gui.dao.model.DesignPattern;

import java.util.List;

public interface DesignPatternDAO {
	
	boolean save(DesignPattern d);
	
	List<DesignPattern> findAll();

}
