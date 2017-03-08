package com.sam.demo.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.demo.dao.ShoppingCartDao;
import com.sam.demo.dto.ProductDto;
import com.sam.demo.model.AddToCartEntity;
import com.sam.demo.model.ProductCategoryEntity;
import com.sam.demo.model.ProductEntity;
import com.sam.demo.model.UserRegistrationEntity;
import com.sam.demo.service.ShoppingCartService;

/**
 * 
 * @author webwerks
 *
 */
@Transactional
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
 
	private static final Logger LOG = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);
	
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	@Override
	public Integer addCategory(String category) {
		LOG.info("Inside addCategory Method:");
		return shoppingCartDao.addCategory(category);
	}

	@Override
	public List<ProductCategoryEntity> getCategoryList() {
		LOG.info("Inside GetCategoryList Method:");
		return shoppingCartDao.getCategoryList();
	}

	@Override
	public Integer addProduct(ProductEntity obj) {
		LOG.info("Inside addProduct Method:");
		return shoppingCartDao.addProduct(obj);
	}

	@Override
	public List<ProductDto> getProductList() {
		LOG.info("Inside getProductList Method:");
		return shoppingCartDao.getProductList();
	}

	@Override
	public Integer addUser(UserRegistrationEntity obj) {
		LOG.info("Inside the addUser Method:");
		return shoppingCartDao.addUser(obj);
	}

	@Override
	public List<UserRegistrationEntity> userAuthenticate(UserRegistrationEntity obj) {
		LOG.info("Inside the userAuthenticate");
		return shoppingCartDao.userAuthenticate(obj);
	}

	@Override
	public Integer addToCart(Integer productId, Integer userId) {
		LOG.info("Inside the addToCart Method");
		AddToCartEntity entObj = new AddToCartEntity();
		entObj.setProductId(productId);
		entObj.setUserId(userId);
		return shoppingCartDao.addToCart(entObj);
	}

	@Override
	public Long getProductCartCount(Integer userId) {
		LOG.info("Inside getProductCartCount Method:");
		return shoppingCartDao.getProductCartCount(userId);
	}

	@Override
	public List<ProductDto> getCartProductList(Integer userId) {
		LOG.info("Inside getCartProductList:");
		return shoppingCartDao.getCartProductList(userId);
	}

	@Override
	public List<ProductDto> getProductByCategory(Integer categoryId) {
		LOG.info("Inside getProductByCategory:");
		return shoppingCartDao.getProductByCategory(categoryId);
	}

	@Override
	public boolean updateProduct(ProductDto product) {
		LOG.info("Inside updateProduct:");
		
		ProductEntity productEntity = new ProductEntity();
		
		productEntity.setId(product.getId());
		productEntity.setProductName(product.getProductName());
		productEntity.setCategoryId(product.getCategoryId());
		productEntity.setProductPrice(product.getProductPrice());
		productEntity.setProductQuantity(product.getProductQuantity());
		productEntity.setImageName(product.getImageName());
		return shoppingCartDao.updateProduct(productEntity);
	}

	@Override
	public boolean updateCategory(Integer id, String categoryName) {
		LOG.info("Inside the updateCategory:");
		ProductCategoryEntity categoryEntity = new ProductCategoryEntity();
		categoryEntity.setId(id);
		categoryEntity.setCategoryName(categoryName);
		return shoppingCartDao.updateCategory(categoryEntity);
	}

	@Override
	public Integer isProductExist(Integer userId, Integer productId) {
		LOG.info("Inside isProductExist Method:");
		return shoppingCartDao.isProductExist(userId, productId);
	}

	@Override
	public boolean removeCart(Integer cartId) {
		LOG.info("Inside removeCart Method");
		return shoppingCartDao.removeCart(cartId);
	}	
}
