package dto;

public abstract class Profile implements ProfileInterface {

	private String id;
	private String name;
	private String dob;
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getDoB() {
		// TODO Auto-generated method stub
		return this.dob;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void setDoB(String dob) {
		// TODO Auto-generated method stub
		this.dob = dob;
	}
}
