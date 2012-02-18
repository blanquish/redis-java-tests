package com.vyre.notivyre.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import static junit.framework.Assert.fail;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 */

@RunWith(MockitoJUnitRunner.class)
public class RedisClientTest {

    @InjectMocks
    private RedisClient redisClient = new RedisClient("localhost");

    @Mock
    private Jedis jedis;


    @Test
    public void whenIPublishAMessageTheJedisClientIsInvoked(){
        when(jedis.publish(anyString(), anyString())).thenReturn(2L);

        redisClient.publish("channel", "foobar");

        verify(jedis).publish("channel", "foobar");

    }

    @Test
    public void whenISubscribeToAChannelTheClientShouldCallJedisSuscribe(){
        when(jedis.publish(anyString(), anyString())).thenReturn(2L);

        redisClient.subscribe(new JedisPubSub() {
            public void onMessage(String channel, String message) {
            }

            public void onSubscribe(String channel, int subscribedChannels) {
            }

            public void onUnsubscribe(String channel, int subscribedChannels) {
            }

            public void onPSubscribe(String pattern, int subscribedChannels) {
            }

            public void onPUnsubscribe(String pattern, int subscribedChannels) {
            }

            public void onPMessage(String pattern, String channel,
                    String message) {
            }
        }, "channel");

        verify(jedis).subscribe(any(JedisPubSub.class), eq("channel"));
        

    }
          

    @Test (expected=IllegalArgumentException.class)
    public void whenIGiveEmptyHostShouldThrowInvalidArgumentException(){
        RedisClient testFail = new RedisClient("");
    }

    @Test
    public void whenIGiveNullHostShouldThrowInvalidArgumentException(){

        try {
            RedisClient testFail = new RedisClient("");
            fail();
        } catch(IllegalArgumentException e) {

        }

    }

    
}
