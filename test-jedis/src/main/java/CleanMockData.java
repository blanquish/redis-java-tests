import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Quick code to delete all data fed by {@link FillMockData} program
 * @author Blanca Garcia
 */
public class CleanMockData {

    public static void main (String[] args){
        Jedis connection = new Jedis("localhost");
        deleteAllMockData(connection);
    }

    private static void deleteAllMockData(final Jedis connection) {

        for  (int i=1; i< 20; i++) {

            String hashMapId = "user:userId"+i+"a";
            Set<String> keys = connection.hkeys(hashMapId);

            assert (keys.size() > 0);
            for (String key : keys) {

                assert(connection.hexists(hashMapId, key));

                connection.hdel(hashMapId, key);

                assert(!connection.hexists(hashMapId, key));
            }
        }
    }
}
