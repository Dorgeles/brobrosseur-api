

/*
 * Java transformer for entity table role 
 * Created on 2024-10-03 ( Time 13:19:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.dto.transformer;

import com.wdy.brobrosseur.dao.entity.Role;
import com.wdy.brobrosseur.utils.contract.FullTransformerQualifier;
import com.wdy.brobrosseur.utils.dto.RoleDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * TRANSFORMER for table "role"
 * 
 * @author Geo
 *
 */
@Mapper
public interface RoleTransformer {

	RoleTransformer INSTANCE = Mappers.getMapper(RoleTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.dateFin", dateFormat="dd/MM/yyyy",target="dateFin"),
	})
	RoleDto toDto(Role entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<RoleDto> toDtos(List<Role> entities) throws ParseException;

    default RoleDto toLiteDto(Role entity) {
		if (entity == null) {
			return null;
		}
		RoleDto dto = new RoleDto();
		dto.setId( entity.getId() );
		dto.setLibelle( entity.getLibelle() );
		return dto;
    }

	default List<RoleDto> toLiteDtos(List<Role> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		for (Role entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.description", target="description"),
		@Mapping(source="dto.libelle", target="libelle"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.dateFin", dateFormat="dd/MM/yyyy",target="dateFin"),
	})
    Role toEntity(RoleDto dto) throws ParseException;

    //List<Role> toEntities(List<RoleDto> dtos) throws ParseException;

}
