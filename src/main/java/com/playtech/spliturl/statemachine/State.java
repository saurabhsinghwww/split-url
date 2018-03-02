package com.playtech.spliturl.statemachine;

import java.net.URL;

import com.playtech.spliturl.model.URLModel;

/**
 * This class provides states and implements state changing methods.
 * 
 * @author Saurabh Singh
 * @version 1.0
 */
public interface State {
	
	URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder);

}
