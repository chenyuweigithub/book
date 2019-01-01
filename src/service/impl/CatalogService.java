package service.impl;

import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;

import dao.impl.ICatalogDAO;

public class CatalogService implements ICatalogService {

	private ICatalogDAO catalogDAO;
	@Override
	public List getAllCatalogs() {
		// TODO Auto-generated method stub
		return catalogDAO.getAllCatalogs();
	}
	public ICatalogDAO getCatalogDAO() {
		return catalogDAO;
	}
	public void setCatalogDAO(ICatalogDAO catalogDAO) {
		this.catalogDAO = catalogDAO;
	}

}
