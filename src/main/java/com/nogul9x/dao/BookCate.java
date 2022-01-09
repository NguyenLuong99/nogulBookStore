package com.nogul9x.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nogul9x.entity.BookCateEntity;
import com.nogul9x.entity.BookEntity;
import com.nogul9x.entity.CategoryEntity;
import com.nogul9x.model.ShowCategory;

public interface BookCate extends JpaRepository<BookCateEntity, Long> {
	@Query("SELECT new ShowCategory(b.category, b.book ,count(b.book)) FROM BookCateEntity b GROUP BY b.category")
	List<ShowCategory> getSelectCategory();
	@Query("Select b.category from BookCateEntity b where b.book.id=?1")
	List<CategoryEntity> findListCateByBookId(Long id);
	@Query("Select b from BookCateEntity b")
	List<BookCateEntity> findListBookCate();
	@Query("Select b from BookCateEntity b where b.book.id=?1")
	List<BookCateEntity> findListBookCateByBookId(Long id);
	@Query("Select b from BookCateEntity b where b.category.id=?1")
	List<BookCateEntity> findListBookCateByCateId(Long id);
	@Query("Select b.book from BookCateEntity b where b.category.id=?1")
	List<BookEntity> findListBookByCateId(Long id);
	@Query("Select b from BookCateEntity b where b.id=?1")
	BookCateEntity findBookCateById(Long id);
}
