
/*
 * Created on 2024-09-29 ( Time 22:05:30 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.contract;

import com.wdy.brobrosseur.utils.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Response Base
 * 
 * @author Dorgeles
 *
 */
@Data
@ToString
@NoArgsConstructor
public class ResponseBase {

	protected Status	status = new Status();
	protected boolean	hasError;
	protected String	sessionUser;
	protected Long		count;
}
