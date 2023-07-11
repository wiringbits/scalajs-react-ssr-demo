# scalajs-react SSR demo

A Server-side rendering (SSR) demo for scalajs-react, based on https://blog.shipreq.com/post/scala_react_and_ssr_part_1

## Dependencies

- [scala-cli](https://scala-cli.virtuslab.org) 1.0.1
- GraalVM 17 (sdkman can pick it automatically)

## Run

- Package sjs code: `scala-cli --power package WebPageJs.scala -o js/webpage.js`
- Run server code: `scala-cli WebServerJvm.scala`
