import scopt.OParser

case class Config(count: Int = 1, objects: List[String] = List())

object Main {
  def main(args: Array[String]): Unit = {
    val builder = OParser.builder[Config]
    val parser = {
      import builder._
      OParser.sequence(
        programName("randomizer"),
        head("randomizer", "1.x"),
        arg[String]("<options...").unbounded().optional().action((x, c) =>
            c.copy(objects = c.objects :+ x)).text("Options to choose from"),
        help("help").text("prints this usage text")
      )
    }

    OParser.parse(parser, args, Config()) match {
      case Some(config) =>
        Picker.choose(config.objects, config.count).foreach(println)

      case None =>
        // arguments are bad, error message will have been displayed
    }
  }
}
