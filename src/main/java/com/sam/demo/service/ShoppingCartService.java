package com.sam.demo.service;

import java.util.List;

import com.sam.demo.dto.ProductDto;
import com.sam.demo.model.AddToCartEntity;
import com.sam.demo.model.ProductCategoryEntity;
import com.sam.demo.model.ProductEntity;
import com.sam.demo.model.UserRegistrationEntity;

public interface ShoppingCartService {
	public Integer addCategory(String p);

	public List<ProductCategoryEntity> getCategoryList();

	public Integer addProduct(ProductEntity obj);

	public List<ProductDto> getProductList();

	public Integer addUser(UserRegistrationEntity obj);

	public List<UserRegistrationEntity> userAuthenticate(UserRegistrationEntity obj);

	public Integer addToCart(Integer productId, Integer userId);

	public Long getProductCartCount(Integer userId);

	public List<ProductDto> getCartProductList(Integer userId);

	public List<ProductDto> getProductByCategory(Integer categoryId);

	public boolean updateProduct(ProductDto product);

	public boolean updateCategory(Integer id, String categoryName);

	public Integer isProductExist(Integer userId, Integer productId); 
	
	public boolean removeCart(Integer cartId);
}
