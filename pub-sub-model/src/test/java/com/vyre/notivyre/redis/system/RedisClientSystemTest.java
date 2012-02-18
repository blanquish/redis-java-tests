package com.vyre.notivyre.redis.system;

import com.vyre.notivyre.redis.RedisClient;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by IntelliJ IDEA.
 * User: blanca
 * Date: 18-Feb-2012
 * Time: 19:32:36
 * To change this template use File | Settings | File Templates.
 */

@RunWith(MockitoJUnitRunner.class)
public class RedisClientSystemTest {

    RedisClient redisClient;

    @Before
    public void setUp(){
        redisClient = new RedisClient("localhost");
    }

    @Test
    public void whenISubscribeToAChannelAndPublishAMessageIShouldReceiveIt(){

        redisClient.subscribe(new JedisPubSub() {

            @Override
            public void onMessage(String channel, String message) {
                if(channel.equals("systemTestChannel"))
                    assertEquals(message, "msg1");
            }

            @Override
            public void onPMessage(String pattern, String channel, String message) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onSubscribe(String channel, int subscribedChannels) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onUnsubscribe(String channel, int subscribedChannels) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onPUnsubscribe(String pattern, int subscribedChannels) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onPSubscribe(String pattern, int subscribedChannels) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        }, "systemTestChannel");


        redisClient.publish("systemTestChannel", "msg1");
        


    }

}
