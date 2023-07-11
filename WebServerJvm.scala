//> using dep com.github.japgolly.scala-graal::core::2.1.0
//> using dep com.github.japgolly.scala-graal::core-js::2.1.0
//> using dep com.github.japgolly.scala-graal::ext-boopickle::2.1.0
//> using file ./Shared.scala
//> using resourceDir ./js

import japgolly.scalagraal._
import japgolly.scalagraal.js._

object WebServer {
  import GraalBoopickle._
  import GraalJs._
  import Shared._

  private val ctx = GraalContext()

  private lazy val init: Expr.Result[Unit] =
    ctx.eval(setup)

  val setup: Expr[Unit] =
    ReactSsr.Setup(
      Expr.requireFileOnClasspath(s"react.production.min.js"),
      Expr.requireFileOnClasspath(s"react-dom-server.browser.production.min.js"),
    )

  val renderMySpa: MySpaInputs => Expr[String] =
    Expr.fn1[MySpaInputs](Manifest.MySpa).compile(_.asString)

  def index(input: MySpaInputs): Expr.Result[String] = {
    val expr = for {
      _ <- setup
      _ <- Expr.requireFileOnClasspath(s"webpage.js").void
      // _ <- ReactSsr.setUrl("https://shipreq.com")
      r <- renderMySpa(input)
    } yield r
    ctx.eval(expr)
  }

  def main(args: Array[String]): Unit ={
    println("Hello Jvm")
    val page = index(MySpaInputs("SSR"))
    println(page)
  }
}
