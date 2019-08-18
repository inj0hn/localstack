package com.inj0hn.localstack.beans;

import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

import com.amazonaws.services.s3.AmazonS3;

/**
 * 
 * Main bean factory using {@link ServiceLoader}, rudimentary Java DI API.
 * ServiceLoader locates and instantiates providers on-demand. It maintains a cache of
 * providers that were loaded in the order it was instantiated. 
 *
 */
public class BeanFactory {

	public static AmazonS3 amazonS3() {
		return StreamSupport.
    			// SerivceLoader#reload - to clear the cache 
    			stream(ServiceLoader.load(S3Factory.class).spliterator(), false)
    			.findFirst()
    			.orElseThrow(IllegalArgumentException::new)
    			.createAmazonS3();
	}
}
