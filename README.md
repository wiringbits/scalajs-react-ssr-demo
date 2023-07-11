# scalajs-react SSR demo

A Server-side rendering (SSR) demo for scalajs-react, based on https://blog.shipreq.com/post/scala_react_and_ssr_part_1

## Dependencies

- [scala-cli](https://scala-cli.virtuslab.org) 1.0.1
- GraalVM 17 (sdkman can pick it automatically)

## Run

- Package sjs code: `scala-cli --power package WebPageJs.scala -o js/webpage.js`
- Run server code: `scala-cli WebServerJvm.scala`

## Update react dependencies

Let's suppose we want to pick react 16, we'll download the dependencies through npm like this:

```shell
npm install react@^16.5.2
npm install react-dom@^16.5.2
```

Then, grab the minified js code:

```shell
cp node_modules/react/umd/react.production.min.js js 
cp node_modules/react-dom/umd/react-dom-server.browser.production.min.js js
```

NOTE: The `umd` variant is the one that works.
