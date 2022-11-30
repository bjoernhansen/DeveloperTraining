package training.design_pattern.dao.dao;


import training.design_pattern.dao.model.DesignPattern;

import java.util.List;

public interface DesignPatternDAO {
	
	boolean save(DesignPattern d);
	
	List<DesignPattern> findAll();

}
