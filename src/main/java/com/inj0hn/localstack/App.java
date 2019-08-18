package com.inj0hn.localstack;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.inj0hn.localstack.beans.BeanFactory;

/**
 * LocalStack S3 app sample
 *
 */
public class App {
	
    public static void main( String[] args ) throws IOException {
    	// uploads an S3 object to LocalStack S3
        AmazonS3 s3 = BeanFactory.amazonS3();
        try(InputStream in = new ByteArrayInputStream("testing...".getBytes())) {
        	s3.putObject("bar", "foo.txt", in, new ObjectMetadata());
        }
        
        s3.putObject("bar","foo.log", new File("/tmp/text.out"));
    }
}
