package com.inj0hn.localstack.beans;

import com.amazonaws.services.s3.AmazonS3;

public interface S3Factory {

	/**
	 * Creates a new Amazon S3 client
	 * 
	 * @return S3 client
	 */
	AmazonS3 createAmazonS3();
}
