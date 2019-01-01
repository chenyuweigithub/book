package service.impl;

import java.util.List;

import vo.Book;

public interface IBookService {
	public List getBookbycatalogid(Integer catalogid);
	public List getBookbyCatalogidPaging(Integer catalogid,int currentPage,int pageSize);
	public int getTotalbyCatalog(Integer catalogid);
	public List getRequiredBookbyHql(String hql);
	public int getTotalbyRequiredBook(String hql);
	public List getRequiredBookbyHqlPaging(String hql, int currentPage,int pageSize);
	public Book getBookbyId(Integer bookid);
}
