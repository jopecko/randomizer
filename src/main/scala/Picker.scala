import scala.util.Random

object Picker {
  val random = new Random(System.currentTimeMillis())

  def choose(objects: List[String], count: Int): List[String] = {
    random.shuffle(objects).take(count)
  }
}
