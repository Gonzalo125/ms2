package pe.edu.galaxy.training.java.ms.gestion.instructores.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.gestion.instructores.dto.TipoDocumentoDTO;
import pe.edu.galaxy.training.java.ms.gestion.instructores.entity.TipoDocumentoEntity;
import pe.edu.galaxy.training.java.ms.gestion.instructores.repository.TipoDocumentoRepository;
import pe.edu.galaxy.training.java.ms.gestion.instructores.service.exception.ServiceException;
@Slf4j
@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	@Autowired
	private ObjectMapper objectMapper;
	//EN LOS METODOS DE ABAJO FALTAN MAS VALIDACIONES.. COMO SI UN OBEJTO VIENE VACIO Y RETONRAMOS VACIDO

	@Override
	public List<TipoDocumentoDTO> findLike(TipoDocumentoDTO t) throws ServiceException {
			
		try {
			//coomo estas trabajando con DTO a ese nivel ..ya no con repository .. entonces
			//debes de crear un bean con jsonMapper
			//caa traes del repsoitoio los dadaots y usas el metodo getTipoDocumentodto PARA CONVERTI DE ENTIDAD D dto
			return this.tipoDocumentoRepository.getAllCustom()
					.stream()
					.map(e->this.getTipoDocumentoDTO(e))
					.collect(Collectors.toList());
			}catch(Exception e2) {
				log.error(e2.getMessage(), e2);
				throw new ServiceException(e2);
			}
		
	}

	@Override
	public Optional<TipoDocumentoDTO> findById(TipoDocumentoDTO tipoDocumentoDTO) throws ServiceException {
		
			try {
				return Optional.of(// aca usa el metodo de getTiopoDocumentoDTO DE PARAMETRO DEBES METER UN DTO
					//PARA ELLO DEL DOCUMENTO REPOSITORY..BUSCAS SU ID ..PERO ES METODO TIENE DE PARAMETRO DTO ASI 
					//QUE LE METES EL GET-ID DEL TIPODOCUMENTODTO QUE VIENE DE AFUERA(PARAMETRO) ..
					//UNA VEZ QUE LO TENGAS EL ID TIPO DTO. LE PONES .GE() PARA QUE EL DOCUMENTOREPOSITORY SEA ACEPTADO COMO PARAMETOR PARA EL METODO QUE TRABAJ CON DTO
					//NO CAMBIA ..SOLO PARA QUE SEA ACEPTABLE COMO PARAMETRO NADA MAS DE AHI LO CONVIERTE SA OPTIONAL
					this.getTipoDocumentoDTO(this.tipoDocumentoRepository.findById(tipoDocumentoDTO.getId()).get()));
			} catch(Exception e2) {
				//depende si queremos llevar el erro al controlador o lo vemos aqui nomas
				//se debe manejar el log de errores en cada capa de la aplicacion
				log.error(e2.getMessage(), e2);
				throw new ServiceException(e2);
			}
		}

	@Override
	public TipoDocumentoDTO save(TipoDocumentoDTO tipoDocumentoDTO) throws ServiceException {
		try {
			// aca vas a retornar un DTO , pero el guardado..po eso adentro usas el save del repositorio y como paramero le metes
			return this.getTipoDocumentoDTO(this.tipoDocumentoRepository.save(this.getTipoDocumentoEntity(tipoDocumentoDTO)));
		}catch(Exception e2) {
			log.error(e2.getMessage(), e2);
			throw new ServiceException(e2);
		}
		
	}
	//convertir un DTO a un entidad 
	private TipoDocumentoEntity getTipoDocumentoEntity(TipoDocumentoDTO tipoDocumentoDTO) {
		return objectMapper.convertValue(tipoDocumentoDTO,TipoDocumentoEntity.class);
	}
	//convertir una entidada a un DTO
	private TipoDocumentoDTO getTipoDocumentoDTO(TipoDocumentoEntity tipoDocumentoEntity) {
		return objectMapper.convertValue(tipoDocumentoEntity,TipoDocumentoDTO.class);
	}

	

}
