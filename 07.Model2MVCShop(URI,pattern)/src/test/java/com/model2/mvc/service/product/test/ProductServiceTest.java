package com.model2.mvc.service.product.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/commonservice.xml" })
public class ProductServiceTest {

	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	//@Test
	public void testAddProduct() throws Exception{
		
		Product product = new Product();
		product.setProdName("testProdName");
		product.setProdDetail("testProdDetail");
		product.setManuDate("20240923");
		product.setPrice(1111);
		product.setFileName("testFileName");
		
		System.out.println("=="+product);
		
		productService.addProduct(product);
		
		product = productService.getProduct(10129);
		System.out.println("=="+product);
		Assert.assertEquals("testProdName", product.getProdName());
		Assert.assertEquals("testProdDetail", product.getProdDetail());
		Assert.assertEquals("20240923", product.getManuDate());
		Assert.assertEquals(1111, product.getPrice());
		Assert.assertEquals("testFileName", product.getFileName());
	}
	
	//@Test
	public void testGetProduct() throws Exception {
		Product product = new Product();
		
		product = productService.getProduct(10129);
		
		Assert.assertEquals(10129, product.getProdNo());
		Assert.assertEquals("testProdName", product.getProdName());
		Assert.assertEquals(1111, product.getPrice());
		Assert.assertEquals("20240923", product.getManuDate());
		Assert.assertEquals("testProdDetail", product.getProdDetail());

		
		Assert.assertNotNull(productService.getProduct(10121));
		Assert.assertNotNull(productService.getProduct(10121));
	}
	
	//@Test
	public void testUpdateProduct() throws Exception{
		Product product = productService.getProduct(10129);
		Assert.assertNotNull(product);
		
		Assert.assertEquals("testProdName", product.getProdName());
		Assert.assertEquals("testProdDetail", product.getProdDetail());
		Assert.assertEquals("20240923", product.getManuDate());
		Assert.assertEquals(1111, product.getPrice());
		Assert.assertEquals("testFileName", product.getFileName());
	
		product.setProdName("change");
		product.setProdDetail("test");
		product.setManuDate("20240922");
		product.setPrice(1111);
		product.setFileName("FileNameTest");
		
		productService.updateProduct(product);
		
		product = productService.getProduct(10129);
		Assert.assertNotNull(product);
		
		Assert.assertEquals("change", product.getProdName());
		Assert.assertEquals("test", product.getProdDetail());
		Assert.assertEquals("20240922", product.getManuDate());
		Assert.assertEquals(1111, product.getPrice());
		Assert.assertEquals("FileNameTest", product.getFileName());
	}
	
	//@Test
	public void testGetProductListAll()throws Exception{
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		Map<String, Object> map = productService.getProductList(search);
		
		List<Object> list = (List<Object>)map.get("list");
		Assert.assertEquals(3, list.size());
	
		Integer totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);
		
		System.out.println("==========================");
		
		search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("");
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 			
	}
	
	//@Test
	public void testGetProductListByProdNo() throws Exception{
		
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("0");
		search.setSearchKeyword("10129");
		Map<String, Object> map = productService.getProductList(search);
		
		List<Object> list = (List<Object>)map.get("list");
		Assert.assertEquals(1, list.size());
		
		Integer totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);
		
		System.out.println("=========================");
		
		search.setSearchCondition("0");
		search.setSearchKeyword(""+System.currentTimeMillis());
		map = productService.getProductList(search);
		
		list = (List<Object>)map.get("list");
		Assert.assertEquals(0, list.size());
		
		totalCount = (Integer)map.get("totalCount");
		System.out.println(totalCount);
		
	}
	
		@Test
	public void testGetProductListByProductName() throws Exception{
		
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("3");
	 	search.setSearchKeyword("change");
	 	Map<String, Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword(""+System.currentTimeMillis());
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(0, list.size());
	 	
	 	System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
		
		}	 
	 	
	}
	
	
	
	
	
	
