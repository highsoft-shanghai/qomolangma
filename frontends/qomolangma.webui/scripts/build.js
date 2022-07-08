const webpack = require("webpack");
const getProdConfig = require("./webpack.prod.config");

async function build() {
  return new Promise(async (resolve, reject) => {
    const webpackConfig = getProdConfig();

    webpack(webpackConfig, (err, stats) => {
      process.stdout.write(
        stats.toString({
          colors: true,
          modules: false,
          children: false,
          chunks: true,
          chunkModules: false,
        }) + "\n\n"
      );
      if (err) {
        console.log(err);
        reject(err);
      }
      return resolve();
    });
  });
}

return build().then();
