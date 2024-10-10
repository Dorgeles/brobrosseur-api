

/*
 * Java transformer for entity table zone_livraison 
 * Created on 2024-10-03 ( Time 13:19:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.dto.transformer;

import com.wdy.brobrosseur.dao.entity.ZoneLivraison;
import com.wdy.brobrosseur.utils.contract.FullTransformerQualifier;
import com.wdy.brobrosseur.utils.dto.ZoneLivraisonDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "zone_livraison"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ZoneLivraisonTransformer {

	ZoneLivraisonTransformer INSTANCE = Mappers.getMapper(ZoneLivraisonTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
	})
	ZoneLivraisonDto toDto(ZoneLivraison entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ZoneLivraisonDto> toDtos(List<ZoneLivraison> entities) throws ParseException;

    default ZoneLivraisonDto toLiteDto(ZoneLivraison entity) {
		if (entity == null) {
			return null;
		}
		ZoneLivraisonDto dto = new ZoneLivraisonDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<ZoneLivraisonDto> toLiteDtos(List<ZoneLivraison> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ZoneLivraisonDto> dtos = new ArrayList<ZoneLivraisonDto>();
		for (ZoneLivraison entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.latitudeDepart", target="latitudeDepart"),
		@Mapping(source="dto.longitudeDepart", target="longitudeDepart"),
		@Mapping(source="dto.latitudeArrivee", target="latitudeArrivee"),
		@Mapping(source="dto.longitudeArrivee", target="longitudeArrivee"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
	})
    ZoneLivraison toEntity(ZoneLivraisonDto dto) throws ParseException;

    //List<ZoneLivraison> toEntities(List<ZoneLivraisonDto> dtos) throws ParseException;

}
