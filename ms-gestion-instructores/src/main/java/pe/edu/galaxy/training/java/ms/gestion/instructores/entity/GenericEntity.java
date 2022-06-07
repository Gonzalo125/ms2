package pe.edu.galaxy.training.java.ms.gestion.instructores.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;
@Data
@MappedSuperclass // para que hagas  herencia a nivel de entidades creando esta clase generica
public class GenericEntity implements Serializable{

	private  static final long seriaLVersionUID=-7517414058164718476L;
	@Column(name="estado")
	private  String  estado="1";

}
