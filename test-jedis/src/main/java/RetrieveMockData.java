import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

/**
 * @author Blanca Garcia
 * @since X.X.X
 */
public class RetrieveMockData {

    public static void main (String[] args) {

        Jedis jedis = new Jedis("localhost");

        for (int i=1; i< 20; i++) {
            // Get a property of a hashmap
//            List<String> data1 = jedis.hmget("user:userId"+i+"a", "originUserId");

            // get all properties of a hashmap at once, convert to JSON and print
            Map<String, String> data = jedis.hgetAll("user:userId"+i+"a");
            System.out.println(new Gson().toJson(data));
        }
    }
}
