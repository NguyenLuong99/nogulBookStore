package com.nogul9x.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nogul9x.entity.BookEntity;
import com.nogul9x.model.BookDetail;





public interface BookDAO extends JpaRepository<BookEntity, Long>{
	@Query("select new BookDetail(b,b.publisher.name,b.author.name ,b.price,b.salePrice)  from BookEntity b")
	List<BookDetail> getBookDetail();
	@Query("select  b from BookEntity b  order by b.views DESC")
	List<BookEntity> fillViewsDESC();
	@Query("select  b from BookEntity b  where b.author.id=?1")
	List<BookEntity> fillBookByAuthorId(long id);
	@Query("select  b from BookEntity b  where b.publisher.id=?1")
	List<BookEntity> fillBookByPublisherId(long id);
	@Query("select  new BookDetail(b,b.publisher.name,b.author.name ,b.price,b.salePrice) from BookEntity b where b.id=?1")
	BookDetail findByLongId(Long id);
	@Query("select b from BookEntity b where b.id=?1")
	BookEntity findBookByLongId(Long id);
	@Query("select b from BookEntity b where b.name=?1")
	BookEntity findBookByName(String name);
	@Query("select  new BookDetail(b,b.publisher.name,b.author.name ,b.price,b.salePrice) from BookEntity b WHERE b.name LIKE ?1")
	Page<BookDetail> fillToTable(String name, Pageable pageable);
	@Query("select  b from BookEntity b WHERE b.name LIKE ?1")
	Page<BookEntity> fillBookToTable(String name, Pageable pageable);
	@Query("select  b from BookEntity b WHERE b.author.id = ?1")
	Page<BookEntity> fillBookToTableByAuthorId(Long id, Pageable pageable);
	@Query("select  b from BookEntity b WHERE b.publisher.id = ?1")
	Page<BookEntity> fillBookToTableByPublisherId(Long id, Pageable pageable);
	@Query("select  b.book from BookCateEntity b WHERE b.category.id = ?1")
	Page<BookEntity> fillBookToTableByCategoryId(Long id, Pageable pageable);
	@Query("select count(b) from BookEntity b")
	int countBook();
	@Query("select sum(b.views) from BookEntity b")
	Long countView();
//	@Query(value="select * from Products where id not in (select p.Product_Id from Product_Cate p inner join Categories c on p.Cate_Id = c.id WHERE c.id = :uid)", nativeQuery = true)
//	List<BookEntity> findProduct(@Param("uid") int id);
//	
//	@Query(value="select * from Products where id not in (select p.Product_Id from Product_Size p inner join Sizes c on p.Size_Id = c.id WHERE c.id = :uid)", nativeQuery = true)
//	List<BookEntity> findSize(@Param("uid") int id);
//	
//	@Query(value="select * from Products where id not in (select p.Product_Id from Product_Color p inner join Colors c on p.Color_Id = c.id WHERE c.id = :uid)", nativeQuery = true)
//	List<BookEntity> findColor(@Param("uid") int id);
//	
//	@Query(value="select TOP(8) * from Products Where Status = 1 order by views DESC", nativeQuery = true)
//	List<BookEntity> fillViewsDESC();
//	
//	@Query(value="select TOP(8) * from Products Where Status = 1 order by ManuDay DESC", nativeQuery = true)
//	List<BookEntity> fillDateDESC();
//	
//	@Query(value="SELECT * FROM Products WHERE Status = 1 AND Id In (SELECT Product_Id From Product_Cate WHERE Cate_Id = ?1) order by ManuDay DESC", nativeQuery = true)
//	Page<BookEntity> fillShopDESC(int number1 , Pageable pageable);
//	
//	@Query("SELECT p FROM Product p WHERE p.manufacture.id = (SELECT p.manufacture.id FROM Product p WHERE p.id = ?1)")
//	List<BookEntity> fillBonusProduct(int number);
}
