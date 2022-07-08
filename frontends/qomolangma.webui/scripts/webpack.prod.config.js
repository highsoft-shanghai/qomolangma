const { merge } = require("webpack-merge");
const getBaseConfig = require("./webpack.base.config");
const TerserPlugin = require("terser-webpack-plugin");
const CssMinimizerPlugin = require("css-minimizer-webpack-plugin");

function getProdConfig() {
  const webpackBaseConfig = getBaseConfig();

  return merge(webpackBaseConfig, {
    mode: "production",

    devtool: false,

    performance: {
      hints: "warning",
      maxAssetSize: 300000, //单文件超过300k，命令行告警
      maxEntrypointSize: 300000, //首次加载文件总和超过300k，命令行告警
    },

    optimization: {
      minimize: true,
      minimizer: [new CssMinimizerPlugin(), new TerserPlugin()],
      noEmitOnErrors: true,
    },
  });
}

module.exports = getProdConfig;
