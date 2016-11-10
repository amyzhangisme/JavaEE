package com.tgb.container.service.impl;

import com.tgb.container.dao.Dao;
import com.tgb.container.service.Service;

public class ServiceImpl implements Service {
	private Dao dao;  
	//依赖注入
	public void setDao(Dao dao) {
		this.dao= dao;
	}
	
	@Override
	public void serviceMethod() {
		dao.daoMethod();
	}

}
