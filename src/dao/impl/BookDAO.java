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
		startRow=(currentPage-1)*pageSize; //��ʼ�α�λ��
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List books=query.list();
		session.close();
		return books;
	}

	//���totalSize���ܼ�¼����
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
	//�������ͼ���totalSize���ܼ�¼����
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
		startRow=(currentPage-1)*pageSize; //��ʼ�α�λ��
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List books=query.list();
		session.close();
		return books;
	}

	@Override
	public Book getBookbyId(Integer bookid) {
		Session session=getSession();
		//Hibernate����Book��ĳ־ö���
		Book book=(Book)session.get(Book.class,bookid);
		session.close();
		return book;
	}
}
