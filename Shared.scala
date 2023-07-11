//> using dep com.github.japgolly.scala-graal::ext-boopickle::2.1.0

import boopickle.Default._

object Shared {

  object Manifest {
    final val MySpa = "mySpa"
  }

  final case class MySpaInputs(name: String)

  implicit val picklerMySpaInputs: Pickler[MySpaInputs] =
    generatePickler[MySpaInputs]
}
