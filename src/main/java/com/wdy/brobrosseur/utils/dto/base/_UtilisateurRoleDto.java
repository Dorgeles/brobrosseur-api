
/*
 * Java dto for entity table utilisateur_role 
 * Created on 2024-10-03 ( Time 13:00:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.dto.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wdy.brobrosseur.utils.contract.SearchParam;
import lombok.Data;
import lombok.ToString;

/**
 * DTO customize for table "utilisateur_role"
 * 
 * @author Smile Back-End generator
 *
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _UtilisateurRoleDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected Integer    utilisateurId        ;
    protected Integer    roleId               ;
    protected String     commentaire          ;
    protected Integer    statusId             ;
    protected Integer    updatedBy            ;
    protected Boolean    isDeleted            ;
    protected Integer    createdBy            ;
	protected String     deletedAt            ;
	protected String     updatedAt            ;
	protected String     createdAt            ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------
	//protected Integer    role;
	protected String roleLibelle;
	//protected Integer    utilisateur;
	protected String utilisateurNom;
	protected String utilisateurPrenom;
	protected String utilisateurEmail;
	protected String utilisateurTelephone;

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<Integer>  utilisateurIdParam    ;                     
	protected SearchParam<Integer>  roleIdParam           ;                     
	protected SearchParam<String>   commentaireParam      ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<Integer>  roleParam             ;                     
	protected SearchParam<String>   roleLibelleParam      ;                     
	protected SearchParam<Integer>  utilisateurParam      ;                     
	protected SearchParam<String>   utilisateurNomParam   ;                     
	protected SearchParam<String>   utilisateurPrenomParam;                     
	protected SearchParam<String>   utilisateurEmailParam ;                     
	protected SearchParam<String>   utilisateurTelephoneParam;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
