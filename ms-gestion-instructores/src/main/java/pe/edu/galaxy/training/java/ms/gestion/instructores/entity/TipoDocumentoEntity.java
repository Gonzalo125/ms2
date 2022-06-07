package pe.edu.galaxy.training.java.ms.gestion.instructores.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="Tipo_Documento")
@Entity(name="TipoDocumentoEntity")
public class TipoDocumentoEntity extends GenericEntity {

	private static final long serialVersionUID = 3996275938268665151L;

//todo lo que es tranasversal puedes llevarlo a otra tabla.. puede llevarlo a un microservicio
	//de manejo de maestras
	@Id
	@Column(name="id_tipo_documento")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqTipoDocumento")
	@SequenceGenerator(name="seqInstructor",allocationSize=1,sequenceName="seq_Tipo_Documento")
	private Integer id;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="descripcion_corta")
	private String  descripcionCorta;
	
	@Column(name="descripcion_larga")
	private String  descripcionLarga;
	
		
	

}
