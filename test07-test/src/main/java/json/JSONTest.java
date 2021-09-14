package json;

import com.alibaba.fastjson.JSONObject;

public class JSONTest {

    public static void main(String[] args) {
        String data = "{  \"status\": \"500\",  \"message\": \"fail\",  \"data\": null}";
        DataForTest dataForTest = JSONObject.parseObject(data, DataForTest.class);
        System.out.println(dataForTest.getStatus());
        System.out.println(dataForTest.getData());
    }

}
