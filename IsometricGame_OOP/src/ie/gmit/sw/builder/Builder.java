package ie.gmit.sw.builder;

public class Builder {
	public static Builder cf = new Builder();
	
	private Builder(){}
	
	public static Builder getInstance(){
		return cf;
	}
	
	public Level newCustomer(){
		return new LevelBuilder();
	}
}
