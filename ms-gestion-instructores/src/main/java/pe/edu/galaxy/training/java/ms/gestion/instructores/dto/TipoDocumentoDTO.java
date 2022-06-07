package pe.edu.galaxy.training.java.ms.gestion.instructores.dto;
import pe.edu.galaxy.training.java.ms.gestion.instructores.dto.GenericDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data// genera el code de maenra automica
// el hashcode..la unicidad del objeto para tema de comparaacion
@EqualsAndHashCode(callSuper=false)// va a heredar el hashcode del pade

public class TipoDocumentoDTO extends GenericDTO {
//usamos DTO porque no estamos llevando los datos de la BD a la capa de presntacion o a un capa superio
	// estas manteinendo independeicia
	private static final long serialVersionUID = 3996275938268665151L;
	
	private String tipo;
	
	
	private String  descripcionCorta;
	
	
	private String  descripcionLarga;
	
		
	

}
