var webpack = require('webpack');
var WebpackDevServer = require('webpack-dev-server');
var config = require('./webpack.config');

var host = "127.0.0.1";

config.entry.demo.unshift("webpack-dev-server/client?http://"+host+":9090", "webpack/hot/dev-server");

new WebpackDevServer(webpack(config), {
    publicPath: config.output.publicPath,
    hot: true,
    noInfo: false
}).listen(9090, host, function (err, result) {
    if (err) {
        console.log(err);
    }
    console.log("Listening at "+host+":9090");
});
