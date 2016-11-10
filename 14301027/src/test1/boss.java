package test1;

import Annotation.Autowired;

public class boss {
	@Autowired
  private office office;
	@Autowired
  private car car;
	public String z= "zhangyuhui";

  
  
  public String tostring(){
	  System.out.println(office.tostring());
	 System.out.println(car.tostring());
	 
	  return "this boss has "+ car.tostring()+" and in "+office.tostring();
  }
}
