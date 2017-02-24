package uk.gov.hmrc

/**
  * Created by Abim on 24/02/2017.
  */
object Shop {

  val catalogue = Map(
    "apple" -> BigDecimal(0.6),
    "orange" -> BigDecimal(0.25)
  )

  def main(args: Array[String]): Unit = {
    val cost = purchase(args)

    val receipt = s"The total cost is $cost"

    println(receipt)
  }

  def purchase(basket: Seq[String]): BigDecimal = costOf(basket)

  private def costOf(items: Seq[String]) = {
    items
      .flatMap(catalogue.get)
      .sum
  }
}
