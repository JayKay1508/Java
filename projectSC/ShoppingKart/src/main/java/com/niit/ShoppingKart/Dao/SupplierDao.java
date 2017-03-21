package com.niit.ShoppingKart.Dao;

import java.util.List;

import com.niit.ShoppingKart.Model.Supplier;

public interface SupplierDao {
	
	public List<Supplier> getSuppliers();
	
	public Supplier get(int supplierId);
	
	public void update(Supplier supplier);
	
	public void delete(int supplierid);

}
