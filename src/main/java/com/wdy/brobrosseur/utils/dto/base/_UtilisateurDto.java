
/*
 * Java dto for entity table utilisateur 
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
 * DTO customize for table "utilisateur"
 * 
 * @author Smile Back-End generator
 *
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _UtilisateurDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected String     nom                  ;
    protected String     username             ;
    protected String     prenom               ;
    protected String     email                ;
    protected String     telephone            ;
    protected String     telephone2           ;
    protected String     motDePasse           ;
    protected Integer    statusId             ;
    protected Integer    updatedBy            ;
    protected Boolean    isDeleted            ;
    protected Integer    createdBy            ;
	protected String     deletedAt            ;
    protected Boolean    isLocked             ;
	protected String     updatedAt            ;
	protected String     createdAt            ;
    protected Integer    typeClientId         ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------
	//protected Integer    typeClient;
	protected String typeClientLibelle;

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<String>   nomParam              ;                     
	protected SearchParam<String>   usernameParam         ;                     
	protected SearchParam<String>   prenomParam           ;                     
	protected SearchParam<String>   emailParam            ;                     
	protected SearchParam<String>   telephoneParam        ;                     
	protected SearchParam<String>   telephone2Param       ;                     
	protected SearchParam<String>   motDePasseParam       ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<Boolean>  isLockedParam         ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<Integer>  typeClientIdParam     ;                     
	protected SearchParam<Integer>  typeClientParam       ;                     
	protected SearchParam<String>   typeClientLibelleParam;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
