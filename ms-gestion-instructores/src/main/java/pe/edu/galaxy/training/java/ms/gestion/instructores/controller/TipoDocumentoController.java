package pe.edu.galaxy.training.java.ms.gestion.instructores.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.instructores.dto.TipoDocumentoDTO;
import pe.edu.galaxy.training.java.ms.gestion.instructores.service.TipoDocumentoService;
@Slf4j
@RestController
@RequestMapping("/tipo-documentos")
public class TipoDocumentoController {

	//hay varios estandarares para hacer microservicios..uno de ellos es srping boot de los 3 que hay
	
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	@GetMapping
	public ResponseEntity<List<TipoDocumentoDTO>> findLike(){
		try {
			return ResponseEntity.ok(
				this.tipoDocumentoService.findLike(null));//
		}catch ( Exception e2) {
			log.error(e2.getMessage(),e2);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	//deberias impementar el @Valid para validar los datos de parametros
	//por ahora no se hara porque tampoco has validado en los campos del entity
	@PostMapping
	public ResponseEntity<TipoDocumentoDTO> insert(@RequestBody TipoDocumentoDTO tipoDocumentoDTO){
		try {
			return ResponseEntity.ok(
				this.tipoDocumentoService.save(tipoDocumentoDTO));//
		}catch ( Exception e2) {
			log.error(e2.getMessage(),e2);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
	}
	
	

}
