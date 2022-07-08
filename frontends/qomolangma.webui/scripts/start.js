const webpack = require("webpack");
const webpackDevServer = require("webpack-dev-server");
const getDevConfig = require("./webpack.dev.config.js");
const pkg = require("../package.json");

const port = pkg.port || 3000;

const resolve = function (dir) {
  return __dirname + "/" + dir;
};

const options = {
  contentBase: resolve("../dist"),
  host: "0.0.0.0",
  stats: { colors: true },
  hot: true,
  noInfo: false,
  historyApiFallback: true,
  publicPath: "/",
};

const webpackConfig = getDevConfig();

webpackDevServer.addDevServerEntrypoints(webpackConfig, options);

const compiler = webpack(webpackConfig);
const server = new webpackDevServer(compiler, options);

server.listen(port, "0.0.0.0", function (err) {
  if (err) {
    console.error(err);
  }
  console.log("\n-------------\n");
  console.log(`http://127.0.0.1:${port}/index.html`);
  console.log("\n-------------\n");
});
