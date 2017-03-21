package com.niit.ShoppingKart.Service;

import java.util.List;

import com.niit.ShoppingKart.Model.Supplier;

public interface SupplierService {
	
	public List<Supplier> getSuppliers();
	
	public Supplier get(int supplierId);
	
	public void update(Supplier supplier);
	
	public void delete(int supplierId);


}
