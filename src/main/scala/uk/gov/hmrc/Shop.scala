package uk.gov.hmrc

/**
  * Created by Abim on 24/02/2017.
  */
object Shop {

  val catalogue = Map(
    "apple" -> BigDecimal(0.6),
    "orange" -> BigDecimal(0.25)
  )
  
  val discountFactor = Map(
    "apple" -> 2,
    "orange" -> 3
  )

  def main(args: Array[String]): Unit = {
    val cost = purchase(args)

    val receipt = s"The total cost is $cost"

    println(receipt)
  }

  def purchase(basket: Seq[String]): BigDecimal = costOf(basket) - discountOf(basket)

  private def costOf(items: Seq[String]): BigDecimal = {
    items
      .flatMap(catalogue.get)
      .sum
  }

  private def discountOf(items: Seq[String]): BigDecimal = {
    val (apples, oranges) = items.sorted.partition(_ == "apple")

    val totalAppleDiscount = apples.size / discountFactor("apple") * catalogue("apple")
    val totalOrangeDiscount = oranges.size / discountFactor("orange") * catalogue("orange")

    val totalDiscount = totalAppleDiscount + totalOrangeDiscount
    totalDiscount
  }
}
