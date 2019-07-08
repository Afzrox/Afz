package PrototypeDesign;
import java.util.ArrayList;
import java.util.List;

public class Company implements Cloneable {

	private List<String> CompanyList;
	
	public Company(){
		CompanyList = new ArrayList<String>();
	}
	
	public Company (List<String> list){
		this.CompanyList=list;
	}
	public void loadData(){
		//read all employees from database and put into the list
		CompanyList.add("Nokia");
		CompanyList.add("Samsung");
		CompanyList.add("LG");
		CompanyList.add("Moto");
		CompanyList.add("RedMi");
	}
	
	public List<String> getCompanyList() {
		return CompanyList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
			List<String> temp = new ArrayList<String>();
			for(String s : this.getCompanyList()){
				temp.add(s);
			}
			return new Company(temp);
	}
}
