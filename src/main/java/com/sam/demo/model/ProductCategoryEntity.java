package com.sam.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 
 * @author webwerks
 *
 */
@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategoryEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "category_name")
	private String categoryName;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "productCategory")
	private Set<ProductEntity> productEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}	
}
