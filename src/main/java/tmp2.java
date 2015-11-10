import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Iterator;

public class tmp2 {
    public static void main(String[] args) throws IOException {

        String js = "{\"id\":123,\"cardNo\":1412,\"name\":\"Oleksii\",\"permanent\":true,\"phoneNumbers\":[123456,987654],\"role\":\"Manager\"}";
        firstSituation(js);
        secondSituation(js);
    }


    public static void firstSituation(String ok) throws IOException {

        byte[] jsonData = ok.getBytes();
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(jsonData);
        JsonNode idNode = rootNode.path("id");
        System.out.println("id = " + idNode.asInt());

        JsonNode phoneNosNode = rootNode.path("phoneNumbers");
        Iterator<JsonNode> elements = phoneNosNode.elements();
        while (elements.hasNext()) {
            JsonNode phone = elements.next();
            System.out.println("phoneNumbers = " + phone.asLong());
        }
    }


    public static void secondSituation(String ok) throws IOException {

        byte[] jsonData = ok.getBytes();
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(jsonData);
        JsonNode idNode = rootNode.path("id");
        System.out.println("id = " + idNode.asInt());

        JsonNode phoneNosNode = rootNode.path("cardNo");
        System.out.println("cardNo = " + phoneNosNode.asInt());
    }
}