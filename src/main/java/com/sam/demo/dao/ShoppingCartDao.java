package com.sam.demo.dao;

import java.util.List;

import com.sam.demo.dto.ProductDto;
import com.sam.demo.model.AddToCartEntity;
import com.sam.demo.model.ProductCategoryEntity;
import com.sam.demo.model.ProductEntity;
import com.sam.demo.model.UserRegistrationEntity;

/**
 * 
 * @author webwerks
 *
 */
public interface ShoppingCartDao {
	public Integer addCategory(String category);

	public List<ProductCategoryEntity> getCategoryList();

	public Integer addProduct(ProductEntity obj);

	public List<ProductDto> getProductList();

	public Integer addUser(UserRegistrationEntity obj);

	public List<UserRegistrationEntity> userAuthenticate(UserRegistrationEntity obj);

	public Integer addToCart(AddToCartEntity entObj);

	public Long getProductCartCount(Integer userId);

	public List<ProductDto> getCartProductList(Integer userId);

	public List<ProductDto> getProductByCategory(Integer categoryId);

	public boolean updateProduct(ProductEntity productEntity);

	public boolean updateCategory(ProductCategoryEntity categoryEntity);
	
	public Integer isProductExist(Integer userId, Integer productId);
	
	public boolean removeCart(Integer cartId); 
}
