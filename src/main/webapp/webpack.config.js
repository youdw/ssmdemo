var path = require("path");
var webpack = require("webpack");
//var commonsPlugin = new webpack.optimize.CommonsChunkPlugin('common.js');
module.exports = {
    entry: {
        demo: ["./source/demo/demo.jsx"],
    },
    output: {
        path: path.resolve(__dirname, "assets"),
        publicPath: "/assets/",
        filename: "[name].bundle.js"
    },
    resolve: {
        root: [
            path.resolve('./source')
        ],
        extensions: ['', '.js', '.jsx']
    },
    module: {
        loaders: [
            {
                test: /\.jsx?$/,
                exclude: /(node_modules|bower_components)/,
                loader: ['babel-loader'], // 'babel-loader' is also a legal name to reference
                query: {
                    presets: ['react', 'es2015-loose', "stage-1"],// 'es2015-loose' 兼容IE 因为default在IE下是关键字 不能用export default
                    plugins: ['transform-runtime']
                }
            },
            {test: /\.(css|less)$/, loader: 'style-loader!css-loader?localIdentName=[hash:base64:8]!less-loader'},
            {test: /\.png$/, loader: "url-loader?mimetype=image/png"},
            {test: /\.(ttf|eot|woff|woff2|otf|svg)/, loader: 'file-loader?name=./font/[name].[ext]'},

        ],
        postLoaders: [
            {
                test: /\.jsx?$/,
                loaders: ['es3ify-loader'] //兼容IE
            }
        ]
    },
    //plugins: [commonsPlugin]
    plugins: [
        new webpack.HotModuleReplacementPlugin()
    ],
};