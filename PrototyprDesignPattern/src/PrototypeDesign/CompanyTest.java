package PrototypeDesign;
import java.util.List;

import PrototypeDesign.Company;
public class CompanyTest {
	public static void main(String[] args) throws CloneNotSupportedException {
///		Already Created Method in program		
		Company Company = new Company();
		Company.loadData();
		
///		Use the clone method to get the Company object
///		copy the existing object into new Object		
		Company CompanyList1 = (Company) Company.clone();
			
		List<String> list1 = CompanyList1.getCompanyList();
		list1.add("MIVI");
		
		System.out.println("Company List: "+Company.getCompanyList());
		System.out.println("Company List Aftre Cloning: "+list1);
		
		list1.remove("Nokia");
		System.out.println("Company List Aftre Removing: "+list1);
	}

}