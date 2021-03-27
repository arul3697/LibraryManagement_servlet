package main.java.com.ssb.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "author_name")
	private String author_name;

	@Column(name = "publisher_name")
	private String publisher_name;

	@Column(name = "contact_number")
	private String contact_number;

	@Column(name = "account_enabled")
	private boolean account_enabled;
	
	
	@Column(name = "fileName")
	private String fileName;
	
	@Column(name = "path")
	private String path;
	
}
