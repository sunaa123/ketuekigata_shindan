package cc.shinbi.shindan.model;

public class Result {
	private String name;
	private String description;
	
	public Result(String name, String description) {
		this.name = name;                  //名前
		this.description = description;    //説明
		
		 
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
}
