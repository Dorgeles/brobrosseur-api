

/*
 * Java transformer for entity table moyen_deplacement 
 * Created on 2024-10-03 ( Time 13:19:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.dto.transformer;

import com.wdy.brobrosseur.dao.entity.MoyenDeplacement;
import com.wdy.brobrosseur.utils.contract.FullTransformerQualifier;
import com.wdy.brobrosseur.utils.dto.MoyenDeplacementDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "moyen_deplacement"
 * 
 * @author Geo
 *
 */
@Mapper
public interface MoyenDeplacementTransformer {

	MoyenDeplacementTransformer INSTANCE = Mappers.getMapper(MoyenDeplacementTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
	})
	MoyenDeplacementDto toDto(MoyenDeplacement entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<MoyenDeplacementDto> toDtos(List<MoyenDeplacement> entities) throws ParseException;

    default MoyenDeplacementDto toLiteDto(MoyenDeplacement entity) {
		if (entity == null) {
			return null;
		}
		MoyenDeplacementDto dto = new MoyenDeplacementDto();
		dto.setId( entity.getId() );
		dto.setLibelle( entity.getLibelle() );
		return dto;
    }

	default List<MoyenDeplacementDto> toLiteDtos(List<MoyenDeplacement> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<MoyenDeplacementDto> dtos = new ArrayList<MoyenDeplacementDto>();
		for (MoyenDeplacement entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.libelle", target="libelle"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
	})
    MoyenDeplacement toEntity(MoyenDeplacementDto dto) throws ParseException;

    //List<MoyenDeplacement> toEntities(List<MoyenDeplacementDto> dtos) throws ParseException;

}
