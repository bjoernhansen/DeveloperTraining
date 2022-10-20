package com.design_pattern.dao.dao;


import com.design_pattern.dao.model.DesignPattern;

import java.util.List;

public interface DesignPatternDAO {
	
	boolean save(DesignPattern d);
	
	List<DesignPattern> findAll();

}
