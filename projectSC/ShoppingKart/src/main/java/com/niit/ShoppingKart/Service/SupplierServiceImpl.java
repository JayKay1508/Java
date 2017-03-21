package com.niit.ShoppingKart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingKart.Dao.SupplierDao;
import com.niit.ShoppingKart.Model.Supplier;

@Service
public class SupplierServiceImpl implements SupplierService{
	@Autowired
	private SupplierDao supplierDao;
	
	
	
	@Transactional
	public List<Supplier> getSuppliers() {
		// TODO Auto-generated method stub
		return supplierDao.getSuppliers();
	}

	@Transactional
	public Supplier get(int supplierId) {
		// TODO Auto-generated method stub
		return supplierDao.get(supplierId);
	}

	@Transactional
	public void update(Supplier supplier) {
		// TODO Auto-generated method stub
		supplierDao.update(supplier);
	}

	@Transactional
	public void delete(int supplierId) {
		supplierDao.delete(supplierId);
		// TODO Auto-generated method stub
		
	}

}
