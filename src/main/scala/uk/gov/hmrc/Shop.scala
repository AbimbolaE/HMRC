package uk.gov.hmrc

/**
  * Created by Abim on 24/02/2017.
  */
object Shop {

  def main(args: Array[String]): Unit = {
    val cost = purchase(args)

    val receipt = s"The total cost is $cost"

    println(receipt)
  }

  def purchase(basket: Seq[String]): BigDecimal = ???
}
