package dao.impl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;

public class CatalogDAO extends BaseDAO implements ICatalogDAO {

	@Override
	public List getAllCatalogs() {
		// TODO Auto-generated method stub
		Session session = getSession();
		Query query = session.createQuery("from Catalog c");
		List catalogs = query.list();
		session.close();
		return catalogs;
	}
	

}
