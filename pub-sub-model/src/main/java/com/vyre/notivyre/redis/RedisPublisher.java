package com.vyre.notivyre.redis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;

/**
 * Simple publisher for REDIS to test, gets text from
 * the command line and publishes it to channel 'c1' on Redis
 * 
 * @author Blanca Garcia
 *
 */
public class RedisPublisher {

    public static void main (String[] args) {

        RedisClient client = new RedisClient("172.16.9.10");
        String channel = "c1";

        // used for serializing objects in json
//        Gson jsonHandler = new Gson();

        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        String message = "";

        System.out.println("Please enter a message to publish (type 'quit' to exit):  ");
        while (!(message.equals("quit"))) {

            try {
                message = in.readLine();
                client.publish(channel, "message: " + message);

                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
}
