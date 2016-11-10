package test1;

public class office {
   private String officeId ;
   private boss boss;
   public boss getboss() {
		return boss;
	}
	
	public void setboss(boss boss) {
		this.boss = boss;
	}

	public String getOfficeId() {
		return officeId;
	}
	
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	public String tostring(){
		return "office " +officeId + boss.z;
	}

}
