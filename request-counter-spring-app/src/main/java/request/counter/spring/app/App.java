package request.counter.spring.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.services.s3.model.S3Object;



public class App {
    public  static void main(String[] args) throws IOException{

    }

    public static void getObjectFromS3(AmazonS3 s3Client,
                                         String bucketName,
                                         String bucketKey) throws IOException{
        S3Object fullObject = null, objectPortion = null, headerOverrideObject = null;
        fullObject = s3Client.getObject(new GetObjectRequest(bucketName,bucketKey));
        System.out.println("Content-Type:" + fullObject.getObjectMetadata().getContentType());
        System.out.println("Content:" );
        displayTextInputStream(fullObject.getObjectContent());

    }

    private static void displayTextInputStream(InputStream input) throws IOException {
        // Read the text input stream one line at a time and display each line.
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println();
    }
}
