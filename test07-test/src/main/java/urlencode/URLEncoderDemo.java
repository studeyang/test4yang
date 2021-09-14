package urlencode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String value = "http://143.0.12.71:8003/rest/v4/file?protocol=s3.minio-share_2214_2:2203-2/2214/202005/20100/4A1561EA8100CDDF113B1E58A26485C8/archives/A012EFD638234F0FB3814BB79F4C272B_file.jpg";
        System.out.println(URLEncoder.encode(value, "UTF-8"));
//        String decode = "http%3A%2F%2F172.23.22.172%3A8084%2Frest%2Fv4%2Ffile%3Fprotocol%3D";
        String decode = "%7B%22isForcedIdentify%22%3Atrue%2C%22urlOnly%22%3Atrue%2C%22correctSkew%22%3Afalse%2C%22rotation%22%3Atrue%2C%22isPrior%22%3Afalse%7D";
        System.out.println(URLDecoder.decode(decode, "UTF-8"));


    }

}
