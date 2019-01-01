package service.impl;

import java.util.List;

import vo.Book;
import dao.impl.IBookDAO;

public class BookService implements IBookService{

	private IBookDAO bookDAO;
	@Override
	public List getBookbycatalogid(Integer catalogid) {
		
		return bookDAO.getBookbycatalogid(catalogid);
	}
	
	@Override
	public List getRequiredBookbyHql(String hql) {
		// TODO Auto-generated method stub
			return bookDAO.getRequiredBookbyHql(hql);
	}
	
	//根据图书种类id得到分页图书
	public List getBookbyCatalogidPaging(Integer catalogid,int currentPage,int pageSize){
		return bookDAO.getBookbyCatalogidPaging(catalogid, currentPage, pageSize);
	}
	//根据图书种类得到该类图书的数目
	public int getTotalbyCatalog(Integer catalogid){
		return bookDAO.getTotalbyCatalog(catalogid);
	}
		
	public IBookDAO getBookDAO() {
		return bookDAO;
	}
	public void setBookDAO(IBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public int getTotalbyRequiredBook(String hql) {
		// TODO Auto-generated method stub
		return bookDAO.getTotalbyRequiredBook(hql);
	}

	@Override
	public List getRequiredBookbyHqlPaging(String hql, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return bookDAO.getRequiredBookbyHqlPaging(hql, currentPage, pageSize);
	}

	@Override
	public Book getBookbyId(Integer bookid) {
		return bookDAO.getBookbyId(bookid);
	}



}
