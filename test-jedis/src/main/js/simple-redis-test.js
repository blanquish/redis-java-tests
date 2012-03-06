var redis = require("redis"),
    client = redis.createClient(); // we can supply port, host and options

client.on("error", function (err) {
    console.log("error event - " + client.host + ":" + client.port + " - " + err);
});

client.on("subscribe", function (channel, count) {
    console.log("client1 subscribed to '" + channel + "', '" + count + "' total subscriptions");
});


client.on("unsubscribe", function (channel, count) {
    console.log("client1 unsubscribed from " + channel + ", " + count + " total subscriptions");
});

client.quit(function (err, res) {
    console.log("Exiting from quit command.");
});

client.subscribe("c1");