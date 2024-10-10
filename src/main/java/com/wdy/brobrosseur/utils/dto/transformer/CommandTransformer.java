

/*
 * Java transformer for entity table command 
 * Created on 2024-10-03 ( Time 13:19:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.dto.transformer;

import com.wdy.brobrosseur.dao.entity.Command;
import com.wdy.brobrosseur.dao.entity.Prestation;
import com.wdy.brobrosseur.dao.entity.Utilisateur;
import com.wdy.brobrosseur.utils.contract.FullTransformerQualifier;
import com.wdy.brobrosseur.utils.dto.CommandDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "command"
 * 
 * @author Geo
 *
 */
@Mapper
public interface CommandTransformer {

	CommandTransformer INSTANCE = Mappers.getMapper(CommandTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.utilisateur.id", target="utilisateurId"),
		@Mapping(source="entity.utilisateur.nom", target="utilisateurNom"),
		@Mapping(source="entity.utilisateur.prenom", target="utilisateurPrenom"),
		@Mapping(source="entity.prestation.id", target="prestationId"),
		@Mapping(source="entity.prestation.libelle", target="prestationLibelle"),
	})
	CommandDto toDto(Command entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<CommandDto> toDtos(List<Command> entities) throws ParseException;

    default CommandDto toLiteDto(Command entity) {
		if (entity == null) {
			return null;
		}
		CommandDto dto = new CommandDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<CommandDto> toLiteDtos(List<Command> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<CommandDto> dtos = new ArrayList<CommandDto>();
		for (Command entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.typeCommand", target="typeCommand"),
		@Mapping(source="dto.latitudeLivraison", target="latitudeLivraison"),
		@Mapping(source="dto.note", target="note"),
		@Mapping(source="dto.longitudeLivraison", target="longitudeLivraison"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="utilisateur", target="utilisateur"),
		@Mapping(source="prestation", target="prestation"),
	})
    Command toEntity(CommandDto dto, Utilisateur utilisateur, Prestation prestation) throws ParseException;

    //List<Command> toEntities(List<CommandDto> dtos) throws ParseException;

}
