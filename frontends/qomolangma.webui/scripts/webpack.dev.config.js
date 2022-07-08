const webpack = require("webpack");
const { merge } = require("webpack-merge");
const getBaseConfig = require("./webpack.base.config");

function getDevConfig() {
  const webpackBaseConfig = getBaseConfig();

  return merge(webpackBaseConfig, {
    mode: "development",

    devtool: "source-map",

    // optimization: {
    //   minimize: true
    // },

    plugins: [new webpack.HotModuleReplacementPlugin()],
  });
}

module.exports = getDevConfig;
