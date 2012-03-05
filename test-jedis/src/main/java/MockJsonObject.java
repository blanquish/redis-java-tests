import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Blanca Garcia
 * @since X.X.X
 */

@SuppressWarnings("unused")
public class MockJsonObject {

    private String originUserId;
    private String destinationUserId;
    private Date creationDate;
    private String message;
    private String type;
    private String id;
    private boolean read;
    private Date readDate;

    public String toJSONString() {
        return new Gson().toJson(this);
    }

    public Map<String, String> toMap() {
        Map<String, String> map2 = new Gson().fromJson(this.toJSONString(), new TypeToken<Map<String, String>>() {}.getType());
        return map2;
    }

    public MockJsonObject(final String originUserId,
                          final String destinationUserId,
                          final Date creationDate,
                          final String message,
                          final String type,
                          final String id, final boolean read, final Date readDate) {
        this.originUserId = originUserId;
        this.destinationUserId = destinationUserId;
        this.creationDate = creationDate;
        this.message = message;
        this.type = type;
        this.id = id;
        this.read = read;
        this.readDate = readDate;
    }

    public String getOriginUserId() {
        return originUserId;
    }

    public void setOriginUserId(final String originUserId) {
        this.originUserId = originUserId;
    }

    public String getDestinationUserId() {
        return destinationUserId;
    }

    public void setDestinationUserId(final String destinationUserId) {
        this.destinationUserId = destinationUserId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(final boolean read) {
        this.read = read;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(final Date readDate) {
        this.readDate = readDate;
    }
}
