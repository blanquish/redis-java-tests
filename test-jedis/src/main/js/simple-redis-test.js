var redis = require("redis");

redis.debug_mode = false;

var express  = require("express");
var app      = express.createServer();
var sio = require('socket.io');

// Configure the app
app.configure(function() {
	app.use(express.methodOverride());
	app.use(express.bodyParser());
	app.use(app.router);
	app.use(express.static(__dirname + '/public'));
});

// Routes
//app.get("/", function(req, resp) {
//	resp.json({ name: 'blanca' , count: Math.floor(Math.random()*11) })
//});


// http://stackoverflow.com/questions/4441798/how-to-use-redis-publish-subscribe-with-nodejs-to-notify-clients-when-data-value
// Listen for requests
app.listen(3000);
console.log("Express server listening on port %d in %s mode", app.address().port, app.settings.env);

var io = sio.listen(app);

io.on('connection', function (client) {

    redis_client = redis.createClient()
    redis_client.subscribe("c1");

    redis_client.on("subscribe", function (channel, count) {
        console.log("client subscribed to '" + channel + "', '" + count + "' total subscriptions");
    });

    redis_client.on("message", function(channel, json) {
    //	var data = JSON.parse(json);
        console.log("client2 received message '" + json + "'");
        io.broadcast(json);
    });

    redis_client.on("error", function (err) {
        console.log("error event - " + redis_client.host + ":" + redis_client.port + " - " + err);
    });

    redis_client.on("unsubscribe", function (channel, count) {
        console.log("client2 unsubscribed from " + channel + ", " + count + " total subscriptions");
    });

    redis_client.quit(function (err, res) {
        console.log("Exiting from quit command.");
    });

});
