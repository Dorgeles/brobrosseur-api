                                                        													
/*
 * Java business for entity table utilisateur_activite 
 * Created on 2024-10-03 ( Time 13:00:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.business;

import com.wdy.brobrosseur.dao.entity.Activite;
import com.wdy.brobrosseur.dao.entity.Utilisateur;
import com.wdy.brobrosseur.dao.entity.UtilisateurActivite;
import com.wdy.brobrosseur.dao.repository.ActiviteRepository;
import com.wdy.brobrosseur.dao.repository.UtilisateurActiviteRepository;
import com.wdy.brobrosseur.dao.repository.UtilisateurRepository;
import com.wdy.brobrosseur.utils.*;
import com.wdy.brobrosseur.utils.contract.IBasicBusiness;
import com.wdy.brobrosseur.utils.contract.Request;
import com.wdy.brobrosseur.utils.contract.Response;
import com.wdy.brobrosseur.utils.dto.ActiviteDto;
import com.wdy.brobrosseur.utils.dto.UtilisateurActiviteDto;
import com.wdy.brobrosseur.utils.dto.transformer.ActiviteTransformer;
import com.wdy.brobrosseur.utils.dto.transformer.UtilisateurActiviteTransformer;
import com.wdy.brobrosseur.utils.enums.StatusEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
BUSINESS for table "utilisateur_activite"
 * 
 * @author Geo
 *
 */

@Component
public class UtilisateurActiviteBusiness implements IBasicBusiness<Request<UtilisateurActiviteDto>, Response<UtilisateurActiviteDto>> {

	private Response<UtilisateurActiviteDto> response;
	@Autowired
	private UtilisateurActiviteRepository utilisateurActiviteRepository;
	@Autowired
	private ActiviteRepository activiteRepository;
	@Autowired
	private ActiviteBusiness activiteBusiness;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private FunctionalError functionalError;
	@Autowired
	private TechnicalError technicalError;
	@Autowired
	private ExceptionUtils exceptionUtils;
	@PersistenceContext
	private EntityManager em;

	private SimpleDateFormat dateFormat;
	private SimpleDateFormat dateTimeFormat;
	private SimpleDateFormat timeFormat;

	public UtilisateurActiviteBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		timeFormat =new SimpleDateFormat("HH:mm:ss");
	}
	
	/**
	 * create UtilisateurActivite by using UtilisateurActiviteDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UtilisateurActiviteDto> create(Request<UtilisateurActiviteDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create UtilisateurActivite-----");

		Response<UtilisateurActiviteDto> response = new Response<UtilisateurActiviteDto>();
		List<UtilisateurActivite>        items    = new ArrayList<UtilisateurActivite>();
			
		for (UtilisateurActiviteDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("utilisateurId", dto.getUtilisateurId());
			fieldsToVerify.put("datasActivite", dto.getDatasActivite());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}


			// Verify if utilisateurActivite to insert do not exist
			UtilisateurActivite existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("utilisateurActivite id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// Verify if activite exist
			Activite existingActivite = null;
			Request<ActiviteDto> requestActivite = new Request<ActiviteDto>();
			requestActivite.setDatas(dto.getDatasActivite());
			requestActivite.setUser(dto.getUtilisateurId());
			Response<ActiviteDto> responseActivite = activiteBusiness.create(requestActivite, locale);
			if (!responseActivite.isHasError()) {
				existingActivite = ActiviteTransformer.INSTANCE.toEntity(responseActivite.getItems().get(0));
			} else {
				response.setStatus(responseActivite.getStatus());
				response.setHasError(true);
				return response;
			}

			// Verify if utilisateur exist
			Utilisateur existingUtilisateur = null;
			if (dto.getUtilisateurId() != null && dto.getUtilisateurId() > 0){
				existingUtilisateur = utilisateurRepository.findOne(dto.getUtilisateurId(), false);
				if (existingUtilisateur == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("utilisateur utilisateurId -> " + dto.getUtilisateurId(), locale));
					response.setHasError(true);
					return response;
				}
			}
			UtilisateurActivite entityToSave = null;
			entityToSave = UtilisateurActiviteTransformer.INSTANCE.toEntity(dto, existingActivite, existingUtilisateur);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<UtilisateurActivite> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = utilisateurActiviteRepository.saveAll((Iterable<UtilisateurActivite>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("utilisateurActivite", locale));
				response.setHasError(true);
				return response;
			}
			List<UtilisateurActiviteDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UtilisateurActiviteTransformer.INSTANCE.toLiteDtos(itemsSaved) : UtilisateurActiviteTransformer.INSTANCE.toDtos(itemsSaved);

			final int size = itemsSaved.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setHasError(false);
		}

		// System.out.println("----end create UtilisateurActivite-----");
		return response;
	}

	/**
	 * update UtilisateurActivite by using UtilisateurActiviteDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UtilisateurActiviteDto> update(Request<UtilisateurActiviteDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update UtilisateurActivite-----");

		Response<UtilisateurActiviteDto> response = new Response<UtilisateurActiviteDto>();
		List<UtilisateurActivite>        items    = new ArrayList<UtilisateurActivite>();
			
		for (UtilisateurActiviteDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la utilisateurActivite existe
			UtilisateurActivite entityToSave = null;
			entityToSave = utilisateurActiviteRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("utilisateurActivite id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if activite exist
			if (dto.getActiviteId() != null && dto.getActiviteId() > 0){
				Activite existingActivite = activiteRepository.findOne(dto.getActiviteId(), false);
				if (existingActivite == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("activite activiteId -> " + dto.getActiviteId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setActivite(existingActivite);
			}
			// Verify if utilisateur exist
			if (dto.getUtilisateurId() != null && dto.getUtilisateurId() > 0){
				Utilisateur existingUtilisateur = utilisateurRepository.findOne(dto.getUtilisateurId(), false);
				if (existingUtilisateur == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("utilisateur utilisateurId -> " + dto.getUtilisateurId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setUtilisateur(existingUtilisateur);
			}
			if (Utilities.notBlank(dto.getCommentaire())) {
				entityToSave.setCommentaire(dto.getCommentaire());
			}
			if (dto.getStatusId() != null && dto.getStatusId() > 0) {
				entityToSave.setStatusId(dto.getStatusId());
			}
			if (dto.getUpdatedBy() != null && dto.getUpdatedBy() > 0) {
				entityToSave.setUpdatedBy(dto.getUpdatedBy());
			}
			if (dto.getCreatedBy() != null && dto.getCreatedBy() > 0) {
				entityToSave.setCreatedBy(dto.getCreatedBy());
			}
			if (Utilities.notBlank(dto.getDeletedAt())) {
				entityToSave.setDeletedAt(dateFormat.parse(dto.getDeletedAt()));
			}
			if (Utilities.notBlank(dto.getDateFin())) {
				entityToSave.setDateFin(dateFormat.parse(dto.getDateFin()));
			}
			entityToSave.setUpdatedBy(request.getUser());
			entityToSave.setUpdatedAt(Utilities.getCurrentDate());
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<UtilisateurActivite> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = utilisateurActiviteRepository.saveAll((Iterable<UtilisateurActivite>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("utilisateurActivite", locale));
				response.setHasError(true);
				return response;
			}
			List<UtilisateurActiviteDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UtilisateurActiviteTransformer.INSTANCE.toLiteDtos(itemsSaved) : UtilisateurActiviteTransformer.INSTANCE.toDtos(itemsSaved);

			final int size = itemsSaved.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setHasError(false);
		}

		// System.out.println("----end update UtilisateurActivite-----");
		return response;
	}

	/**
	 * delete UtilisateurActivite by using UtilisateurActiviteDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UtilisateurActiviteDto> delete(Request<UtilisateurActiviteDto> request, Locale locale)  {
		// System.out.println("----begin delete UtilisateurActivite-----");

		Response<UtilisateurActiviteDto> response = new Response<UtilisateurActiviteDto>();
		List<UtilisateurActivite>        items    = new ArrayList<UtilisateurActivite>();
			
		for (UtilisateurActiviteDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, Object> fieldsToVerify = new HashMap<String, Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la utilisateurActivite existe
			UtilisateurActivite existingEntity = null;

			existingEntity = utilisateurActiviteRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("utilisateurActivite -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------



			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			utilisateurActiviteRepository.saveAll((Iterable<UtilisateurActivite>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete UtilisateurActivite-----");
		return response;
	}

	/**
	 * get UtilisateurActivite by using UtilisateurActiviteDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UtilisateurActiviteDto> getByCriteria(Request<UtilisateurActiviteDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get UtilisateurActivite-----");

		Response<UtilisateurActiviteDto> response = new Response<UtilisateurActiviteDto>();
		List<UtilisateurActivite> items 			 = utilisateurActiviteRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<UtilisateurActiviteDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UtilisateurActiviteTransformer.INSTANCE.toLiteDtos(items) : UtilisateurActiviteTransformer.INSTANCE.toDtos(items);

			final int size = items.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setCount(utilisateurActiviteRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("utilisateurActivite", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get UtilisateurActivite-----");
		return response;
	}

	/**
	 * get full UtilisateurActiviteDto by using UtilisateurActivite as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private UtilisateurActiviteDto getFullInfos(UtilisateurActiviteDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
		// put code here
		List<UtilisateurActivite> activiteList = utilisateurActiviteRepository.findByUtilisateurId(dto.getUtilisateurId(), false);
		if (Utilities.isNotEmpty(activiteList)) {
		dto.setDatasActivite(ActiviteTransformer.INSTANCE.toDtos(activiteList.stream().map(UtilisateurActivite::getActivite).collect(Collectors.toList())));
		}
		dto.setActiviteId(null);
		dto.setActiviteLibelle(null);
		dto.setUtilisateurNom(null);
		if (Utilities.isTrue(isSimpleLoading)) {
			return dto;
		}
		if (size > 1) {
			return dto;
		}

		return dto;
	}
}
