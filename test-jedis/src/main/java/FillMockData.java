import org.joda.time.DateTime;
import redis.clients.jedis.Jedis;

/**
 * @author Blanca Garcia
 * @since X.X.X
 */
public class FillMockData {

    public static void main (String[] args) {
        
        Jedis connection = new Jedis("localhost");
        storeMockData(connection);
    }

    private static void storeMockData(final Jedis connection) {
        boolean unread = false;

        DateTime creationDate2 = new DateTime();
        for (int i=1; i< 20; i++) {

            MockJsonObject mockJsonObject = new MockJsonObject("userId"+i, "userId"+i+"a", creationDate2.minusDays(i).toDate(),
                                                      "test message "+i, "notification"+i, "identifier"+i, unread, null);

            connection.hmset("user:"+mockJsonObject.getDestinationUserId(), mockJsonObject.toMap());

        }
    }
}
