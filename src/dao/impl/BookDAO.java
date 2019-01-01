package dao.impl;

import java.util.List;

import org.hibernate.*;

import vo.Book;

public class BookDAO extends BaseDAO implements IBookDAO{

	@Override
	public List getBookbycatalogid(Integer catalogid) {
		Session session = getSession();
		String hql ="from Book b where b.catalog.catalogid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, catalogid);
		List books=query.list();
		System.out.print(books.get(2));
		session.close();
		return books;
	}

	@Override
	public List getBookbyCatalogidPaging(Integer catalogid, int currentPage,
			int pageSize) {
		Session session=getSession();
		Query query = session.createQuery("from Book b where b.catalog.catalogid=?");
		query.setParameter(0, catalogid);
		int startRow=0;
		startRow=(currentPage-1)*pageSize; //起始游标位置
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List books=query.list();
		session.close();
		return books;
	}

	//获得totalSize（总记录数）
	@Override
	public int getTotalbyCatalog(Integer catalogid) {
		Session session=getSession();
		Query query=session.createQuery("from Book b where b.catalog.catalogid=?");
		query.setParameter(0,catalogid);
		List books=query.list();
		int totalSize=books.size();
		session.close();
		return totalSize;
	}
	//获得搜索图书的totalSize（总记录数）
	public int getTotalbyRequiredBook(String hql) {
		Session session=getSession();
		Query query=session.createQuery(hql);
		List books=query.list();
		int totalSize=books.size();
		session.close();
		return totalSize;
	}
	
	@Override
	public List getRequiredBookbyHql(String hql) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Query query=session.createQuery(hql);
		List books=query.list();
		return books;
	}

	public List getRequiredBookbyHqlPaging(String hql, int currentPage,
			int pageSize) {
		Session session=getSession();
		Query query=session.createQuery(hql);
		int startRow=0;
		startRow=(currentPage-1)*pageSize; //起始游标位置
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List books=query.list();
		session.close();
		return books;
	}

	@Override
	public Book getBookbyId(Integer bookid) {
		Session session=getSession();
		//Hibernate返回Book类的持久对象
		Book book=(Book)session.get(Book.class,bookid);
		session.close();
		return book;
	}
}
