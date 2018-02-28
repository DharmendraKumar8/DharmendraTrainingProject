package com.example.demo.domain;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookCategory {
	     @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int CategoryId;
	    private String name;
	    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
	    private Set<Book> books;

	    public BookCategory(){

	    }

		public BookCategory(int categoryId, String name, Set<Book> books) {
			super();
			CategoryId = categoryId;
			this.name = name;
			this.books = books;
		}

		public int getCategoryId() {
			return CategoryId;
		}

		public void setCategoryId(int categoryId) {
			CategoryId = categoryId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Set<Book> getBooks() {
			return books;
		}

		public void setBooks(Set<Book> books) {
			this.books = books;
		}
	    

}
