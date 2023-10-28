package model;

public enum Profesion {
	
	EMPLEADO_PUBLICO ("Empleado Público"),
	DEVELOPER ("Developer"),
	MEDICO ("Médico");
	
	private String description;
	
	private Profesion(String desc) {
		this.description = desc;
	}

	public String getDescription() {
		return description;
	}
}