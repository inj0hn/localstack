package com.inj0hn.localstack.beans;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.google.auto.service.AutoService;


/**
 * Amazon client factory class. Clients are configured to point to LocalStack
 *
 */
@AutoService(S3Factory.class) // generates META-INF/services/com.inj0hn.localstack.beans.S3Factory required by ServiceLoader
public class LocalStackS3Factory implements S3Factory{
	
	private static final String LOCALSTACK_S3_ENDPOINT = "http://localhost:4572";
	
	// no-arg required by ServiceLoader class
	public LocalStackS3Factory() {
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.inj0hn.localstack.S3Factory#createAmazonS3()
	 */
	public AmazonS3 createAmazonS3() {
		return AmazonS3ClientBuilder.standard()
        		.withPathStyleAccessEnabled(true)
        		.withEndpointConfiguration(
        				new AwsClientBuilder.EndpointConfiguration(LOCALSTACK_S3_ENDPOINT, Regions.US_EAST_1.getName()))
        		.build();
	}

}
