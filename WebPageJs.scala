//> using platform scala-js
//> using dep org.scala-js::scalajs-dom::2.6.0
//> using dep com.github.japgolly.scala-graal::core-js::2.1.0
//> using dep com.github.japgolly.scala-graal::ext-boopickle::2.1.0
//> using dep com.github.japgolly.scalajs-react::core::2.1.1
//> using file ./Shared.scala

import japgolly.scalagraal.Pickled
import japgolly.scalajs.react.ReactDOMServer

import scala.scalajs.js.annotation.JSExportTopLevel

/** This code is compiled into JS and executed on the JVM via Graal JS. */
object WebPageJs {
  import Shared._

  @JSExportTopLevel(Manifest.MySpa)
  def mySpa(p: Pickled[MySpaInputs]): String = {
    val input = p.value // Instance of MySpaInputs
    val vdom = Components.hello(input.name)
    ReactDOMServer.renderToString(vdom)
  }

  object Components {
    import japgolly.scalajs.react.ScalaComponent
    import japgolly.scalajs.react._
    import japgolly.scalajs.react.vdom.html_<^._

    def hello(input: String) = {
      val component = ScalaComponent.builder[String]
        .render($ => <.div("Hello ", $.props))
           .build
            component(input)
       }
  }

  def main(args: Array[String]): Unit =
    println("Hello WebPage (js)")
}
