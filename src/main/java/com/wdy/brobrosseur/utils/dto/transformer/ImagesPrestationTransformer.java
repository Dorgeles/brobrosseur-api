

/*
 * Java transformer for entity table images_prestation 
 * Created on 2024-10-03 ( Time 13:19:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.dto.transformer;

import com.wdy.brobrosseur.dao.entity.ImagesPrestation;
import com.wdy.brobrosseur.dao.entity.Prestation;
import com.wdy.brobrosseur.utils.contract.FullTransformerQualifier;
import com.wdy.brobrosseur.utils.dto.ImagesPrestationDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "images_prestation"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ImagesPrestationTransformer {

	ImagesPrestationTransformer INSTANCE = Mappers.getMapper(ImagesPrestationTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.prestation.id", target="prestationId"),
		@Mapping(source="entity.prestation.libelle", target="prestationLibelle"),
	})
	ImagesPrestationDto toDto(ImagesPrestation entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ImagesPrestationDto> toDtos(List<ImagesPrestation> entities) throws ParseException;

    default ImagesPrestationDto toLiteDto(ImagesPrestation entity) {
		if (entity == null) {
			return null;
		}
		ImagesPrestationDto dto = new ImagesPrestationDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<ImagesPrestationDto> toLiteDtos(List<ImagesPrestation> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ImagesPrestationDto> dtos = new ArrayList<ImagesPrestationDto>();
		for (ImagesPrestation entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.url", target="url"),
		@Mapping(source="dto.description", target="description"),
		@Mapping(source="dto.ordre", target="ordre"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="prestation", target="prestation"),
	})
    ImagesPrestation toEntity(ImagesPrestationDto dto, Prestation prestation) throws ParseException;

    //List<ImagesPrestation> toEntities(List<ImagesPrestationDto> dtos) throws ParseException;

}
