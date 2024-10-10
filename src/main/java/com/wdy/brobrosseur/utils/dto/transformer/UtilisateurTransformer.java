

/*
 * Java transformer for entity table utilisateur 
 * Created on 2024-10-03 ( Time 13:19:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.dto.transformer;

import com.wdy.brobrosseur.dao.entity.TypeClient;
import com.wdy.brobrosseur.dao.entity.Utilisateur;
import com.wdy.brobrosseur.utils.contract.FullTransformerQualifier;
import com.wdy.brobrosseur.utils.dto.UtilisateurDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "utilisateur"
 * 
 * @author Geo
 *
 */
@Mapper
public interface UtilisateurTransformer {

	UtilisateurTransformer INSTANCE = Mappers.getMapper(UtilisateurTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.typeClient.id", target="typeClientId"),
		@Mapping(source="entity.typeClient.libelle", target="typeClientLibelle"),
	})
	UtilisateurDto toDto(Utilisateur entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<UtilisateurDto> toDtos(List<Utilisateur> entities) throws ParseException;

    default UtilisateurDto toLiteDto(Utilisateur entity) {
		if (entity == null) {
			return null;
		}
		UtilisateurDto dto = new UtilisateurDto();
		dto.setId( entity.getId() );
		dto.setNom( entity.getNom() );
		dto.setPrenom( entity.getPrenom() );
		return dto;
    }

	default List<UtilisateurDto> toLiteDtos(List<Utilisateur> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<UtilisateurDto> dtos = new ArrayList<UtilisateurDto>();
		for (Utilisateur entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.nom", target="nom"),
		@Mapping(source="dto.username", target="username"),
		@Mapping(source="dto.prenom", target="prenom"),
		@Mapping(source="dto.email", target="email"),
		@Mapping(source="dto.telephone", target="telephone"),
		@Mapping(source="dto.telephone2", target="telephone2"),
		@Mapping(source="dto.motDePasse", target="motDePasse"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.isLocked", target="isLocked"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="typeClient", target="typeClient"),
	})
    Utilisateur toEntity(UtilisateurDto dto, TypeClient typeClient) throws ParseException;

    //List<Utilisateur> toEntities(List<UtilisateurDto> dtos) throws ParseException;

}
