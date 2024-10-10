
/*
 * Created on 2024-09-29 ( Time 22:05:30 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Status
 * 
 * @author Dorgeles
 *
 */
@Data
@ToString
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Status {
	private String	code;
	private String	message;
}
