package model;

public enum Role {

	ADMIN("ROLE_ADMIN"), USER("ROLE_USER"), GERENTE("GERENTE");

	private String descricao;
	private Integer id;

	Role(String descricao) {

		this.descricao = descricao;
	}

	// alterar hidrobike
	//ADMIN("admin"), USER("user"),GERENTE("gerente");
  public String getId(Role r){
		String id ="";
		if(Role.USER.name() == "USER"){
			id="2";
		}else if(Role.ADMIN.name()=="ADMIN"){
			id ="1";
	  }
		return id;

  }

	public String getDescricao() {
		return descricao;
	}


	public static void main(String[] args) {
		System.out.print(Role.USER.name());
	}

}
