

/*
 * Java transformer for entity table utilisateur_activite 
 * Created on 2024-10-03 ( Time 13:19:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.dto.transformer;

import com.wdy.brobrosseur.dao.entity.Activite;
import com.wdy.brobrosseur.dao.entity.Utilisateur;
import com.wdy.brobrosseur.dao.entity.UtilisateurActivite;
import com.wdy.brobrosseur.utils.contract.FullTransformerQualifier;
import com.wdy.brobrosseur.utils.dto.UtilisateurActiviteDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "utilisateur_activite"
 * 
 * @author Geo
 *
 */
@Mapper
public interface UtilisateurActiviteTransformer {

	UtilisateurActiviteTransformer INSTANCE = Mappers.getMapper(UtilisateurActiviteTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.dateFin", dateFormat="dd/MM/yyyy",target="dateFin"),
		@Mapping(source="entity.activite.id", target="activiteId"),
		@Mapping(source="entity.activite.libelle", target="activiteLibelle"),
		@Mapping(source="entity.utilisateur.id", target="utilisateurId"),
		@Mapping(source="entity.utilisateur.nom", target="utilisateurNom"),
		@Mapping(source="entity.utilisateur.prenom", target="utilisateurPrenom"),
	})
	UtilisateurActiviteDto toDto(UtilisateurActivite entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<UtilisateurActiviteDto> toDtos(List<UtilisateurActivite> entities) throws ParseException;

    default UtilisateurActiviteDto toLiteDto(UtilisateurActivite entity) {
		if (entity == null) {
			return null;
		}
		UtilisateurActiviteDto dto = new UtilisateurActiviteDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<UtilisateurActiviteDto> toLiteDtos(List<UtilisateurActivite> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<UtilisateurActiviteDto> dtos = new ArrayList<UtilisateurActiviteDto>();
		for (UtilisateurActivite entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.commentaire", target="commentaire"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.dateFin", dateFormat="dd/MM/yyyy",target="dateFin"),
		@Mapping(source="activite", target="activite"),
		@Mapping(source="utilisateur", target="utilisateur"),
	})
    UtilisateurActivite toEntity(UtilisateurActiviteDto dto, Activite activite, Utilisateur utilisateur) throws ParseException;

    //List<UtilisateurActivite> toEntities(List<UtilisateurActiviteDto> dtos) throws ParseException;

}
