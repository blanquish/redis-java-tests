import redis.clients.jedis.Jedis;

/**
 * @author Blanca Garcia
 */
public class Main {

    public static void main(String[] arguments) {

        Jedis jedis = new Jedis("localhost");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println ("Value retrieved for key[foo]: value[" +value + "]");
    }

}
