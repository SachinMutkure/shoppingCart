package com.sam.demo.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sam.demo.dao.ShoppingCartDao;
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
@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {

	private static final Logger LOG = LoggerFactory.getLogger(ShoppingCartDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Integer addCategory(String category) {
		LOG.info("Inside AddCategory :" + category);
		ProductCategoryEntity obj = new ProductCategoryEntity();
		obj.setCategoryName(category);
		Session session = sessionFactory.getCurrentSession();
		LOG.info("Session Object value :" + session);
		Integer status = (Integer) session.save(obj);
		LOG.info("Saved Operation Success:" + status);
		return status;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductCategoryEntity> getCategoryList() {
		LOG.info("Inside getCategoryList ");
		Session session = sessionFactory.getCurrentSession();		
		List<ProductCategoryEntity> list = session.createCriteria(ProductCategoryEntity.class).list();
		LOG.info("Category List :" + list);
		return list;
	}

	@Override
	public Integer addProduct(ProductEntity obj) {
		LOG.info("Inside addProduct Method:");
		Session session = sessionFactory.getCurrentSession();
		Integer status = (Integer) session.save(obj);		
		LOG.info("Save Status Successfull :" + status);
		return status;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDto> getProductList() {
		LOG.info("Inside get Product List");
		Session session = sessionFactory.getCurrentSession();
		
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("id").as("id"));
		projectionList.add(Projections.property("productName").as("productName"));
		projectionList.add(Projections.property("imageName").as("imageName"));
		projectionList.add(Projections.property("productPrice").as("productPrice"));
		projectionList.add(Projections.property("productQuantity").as("productQuantity"));
		projectionList.add(Projections.property("productCategory.categoryName").as("categoryName"));
		projectionList.add(Projections.property("productCategory.id").as("categoryId"));
		
		Criteria criteria = session.createCriteria(ProductEntity.class)
				.createAlias("productCategory", "productCategory").setProjection(projectionList);

		List<ProductDto> list = criteria.setResultTransformer(new AliasToBeanResultTransformer(ProductDto.class))
				.list();
		LOG.info("Product List Status :" + list);
		return list;
	}

	@Override
	public Integer addUser(UserRegistrationEntity obj) {
		LOG.info("Inside the addUser Method:");
		Session session = sessionFactory.getCurrentSession();
		Integer status = (Integer) session.save(obj);
		LOG.info("add User status :" + status);
		return status;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRegistrationEntity> userAuthenticate(UserRegistrationEntity obj) {
		LOG.info("Inside the User Authenticate Method:");
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM UserRegistrationEntity A WHERE A.emailId = :email and A.password= :password";
		Query query = session.createQuery(hql);
		query.setParameter("email", obj.getEmailId());
		query.setParameter("password", obj.getPassword());
		List<UserRegistrationEntity> results = query.list();
		return results;
	}

	@Override
	public Integer addToCart(AddToCartEntity entObj) {
		LOG.info("Inside the addToCart Method");
		Session session = sessionFactory.getCurrentSession();
		Integer status = (Integer) session.save(entObj);
		LOG.info("AddToCart Save Status :" + status);
		return status;
	}

	@Override
	public Long getProductCartCount(Integer userId) {
		LOG.info("Inside getProductCartCount Method");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from AddToCartEntity A where A.userId= :userId");
		query.setInteger("userId", userId);
		Long count = (Long) query.uniqueResult();
		LOG.info("Get Product count is :" + count + " to user :" + userId);
		return count;
	}
	
	@Override
	public Integer isProductExist(Integer userId, Integer productId){
		LOG.info("Inside the isProductExist Method :");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select A.productId FROM AddToCartEntity A where A.userId= :userId and productId= :productId"); 
		query.setInteger("userId", userId);
		query.setInteger("productId", productId);
		Integer result = (Integer)query.uniqueResult();
		LOG.info("Result Status :"+result);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDto> getCartProductList(Integer userId) {
		LOG.info("Inside getCartProductList Method:");

		Session session = sessionFactory.getCurrentSession();

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("id").as("id")); 
		projectionList.add(Projections.property("productEntity.productName").as("productName"));
		projectionList.add(Projections.property("productEntity.imageName").as("imageName"));
		projectionList.add(Projections.property("productEntity.productPrice").as("productPrice"));
		projectionList.add(Projections.property("productEntity.productQuantity").as("productQuantity"));
		projectionList.add(Projections.property("productCategory.categoryName").as("categoryName"));

		Criteria criteria = session.createCriteria(AddToCartEntity.class).createAlias("productEntity", "productEntity")
				.createAlias("productEntity.productCategory", "productCategory").setProjection(projectionList)
				.add(Restrictions.eq("userId", userId));

		List<ProductDto> productList = criteria.setResultTransformer(new AliasToBeanResultTransformer(ProductDto.class))
				.list();
		LOG.info("Add to cart product list :" + productList);
		return productList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDto> getProductByCategory(Integer categoryId) {
		LOG.info("Inside getProductByCategory Method:");
		Session session = sessionFactory.getCurrentSession();
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("categoryName").as("categoryName"));
		projectionList.add(Projections.property("productEntity.productName").as("productName"));
		projectionList.add(Projections.property("productEntity.imageName").as("imageName"));
		projectionList.add(Projections.property("productEntity.productPrice").as("productPrice"));
		projectionList.add(Projections.property("productEntity.productQuantity").as("productQuantity"));
		projectionList.add(Projections.property("productEntity.id").as("id"));

		Criteria criteria = session.createCriteria(ProductCategoryEntity.class)
				.createAlias("productEntity", "productEntity").setProjection(projectionList)
				.add(Restrictions.eq("id", categoryId));
		List<ProductDto> list = criteria.setResultTransformer(new AliasToBeanResultTransformer(ProductDto.class))
				.list();
		LOG.info("Get Product List by category :" + list);
		return list;
	}

	@Override
	public boolean updateProduct(ProductEntity productEntity) {
		LOG.info("Inside updateProduct Method :");
		Session session = sessionFactory.getCurrentSession();		
		boolean status = false;			
		try{
			session.saveOrUpdate(productEntity);
			status = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		LOG.info("Update Status :"+status);
		return status;
	}

	@Override
	public boolean updateCategory(ProductCategoryEntity categoryEntity) {
		LOG.info("Inside the updateCategory:");
		Session session = sessionFactory.getCurrentSession();
		boolean status = false;
		try {
			session.saveOrUpdate(categoryEntity);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("Update Status :" + status); 
		return status;
	}

	@Override
	public boolean removeCart(Integer cartId) {
		LOG.info("Inside the removeCart");
		Session session = sessionFactory.getCurrentSession();
		boolean status = false;
		try {
			Query q = session.createQuery("delete AddToCartEntity where id = :id");
			q.setInteger("id", cartId);
			q.executeUpdate();	
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return status;
	}	
}
