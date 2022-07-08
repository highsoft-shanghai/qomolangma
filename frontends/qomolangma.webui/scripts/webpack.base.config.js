const webpack = require("webpack");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const path = require("path");

const resolve = function (dir) {
  return path.resolve(__dirname + "/" + dir);
};

const devMode = process.env.NODE_ENV === "development";

const getCssLoader = () => {
  let cssLoader = [
    { loader: devMode ? "style-loader" : MiniCssExtractPlugin.loader },
    { loader: "css-loader" },
  ];
  return cssLoader;
};

function getCommonConfig() {
  const cssLoader = getCssLoader();
  const lessLoader = cssLoader.concat({
    loader: "less-loader",
  });
  return {
    entry: {
      app: `./src/index.tsx`,
    },

    output: {
      path: resolve("../dist"),
      publicPath: "/",
      filename: `js/[name].[fullhash:4].js`,
      chunkFilename: `js/[name].chunk.js`,
    },

    resolve: {
      alias: {
        "@": resolve("../src"),
        // "@components": resolve("../src/components"),
        // "@utils": resolve("../src/utils"),
      },
      extensions: ["*", ".js", ".jsx", ".ts", ".tsx", ".json"],
    },

    module: {
      rules: [
        {
          enforce: "pre",
          test: /\.(js|jsx|ts|tsx)$/,
          loader: "source-map-loader",
        },
        {
          test: /\.(js|jsx|ts|tsx)$/,
          exclude: resolve("node_modules"),
          use: {
            loader: "babel-loader",
          },
        },
        {
          test: /\.css$/,
          exclude: resolve("node_modules"),
          use: cssLoader,
        },
        {
          test: /\.less$/,
          exclude: resolve("node_modules"),
          use: lessLoader,
        },
        {
          test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
          loader: "url-loader",
          options: {
            name: "[name].[ext]",
            limit: 8192,
            esModule: false,
          },
        },
        {
          test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
          loader: "file-loader",
          options: {
            limit: 8192,
            name: `asserts/fonts/[name].[ext]`,
          },
        },
        {
          test: /\.(ogg|mp3|wav|mpe?g)$/i,
          loader: "file-loader",
          options: {
            name: `/img/[name].[fullhash:4].[ext]`,
          },
        },
      ],
    },

    plugins: [
      new CleanWebpackPlugin({
        root: resolve(".."),
      }),
      new MiniCssExtractPlugin({
        filename: `css/[name].[fullhash:4].css`,
        chunkFilename: `css/[id].[fullhash:4].css`,
      }),
      new webpack.NoEmitOnErrorsPlugin(),
      new webpack.DefinePlugin({
        "process.env": {
          NODE_ENV: JSON.stringify(process.env.NODE_ENV),
        },
      }),
      new HtmlWebpackPlugin({
        filename: resolve("../dist/index.html"),
        template: `src/index.html`,
        favicon: "src/icon.png",
      }),
    ],
  };
}

module.exports = getCommonConfig;
