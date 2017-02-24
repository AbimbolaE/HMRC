package uk.gov.hmrc

import org.specs2.Specification

/**
  * Created by Abim on 24/02/2017.
  */
class ShopSpecification  extends Specification {

  override def is = s2"""

     The features of a shop application - purchasing items:

     An Apple should cost 0.60p                     ${ `An Apple should cost 0.60p` }
     An Orange should cost 0.25p                    ${ `An Orange should cost 0.25p` }
     An Apple and An Orange should cost 0.85p       ${ `An Apple and An Orange should cost 0.85p` }
     Some fruits (Apple. Apple, Orange, Apple) should cost 2.05  ${ `Some fruits (Apple. Apple, Orange, Apple) should cost 2.05` }
     Some fruits (Orange, Orange, Orange, Apple, Apple) should cost 1.95  ${ `Some fruits (Orange, Orange, Orange, Apple, Apple) should cost 1.95` }

  """
  def `An Apple should cost 0.60p` = {
    Shop.purchase(Array("apple")) === 0.6
  }

  def `An Orange should cost 0.25p` = {
    Shop.purchase(Array("orange")) === 0.25
  }

  def `An Apple and An Orange should cost 0.85p` = {
    Shop.purchase(Array("apple", "orange")) === 0.85
  }

  def `Some fruits (Apple. Apple, Orange, Apple) should cost 2.05` = {
    Shop.purchase(Array("apple", "apple", "orange", "apple")) === 2.05
  }

  def `Some fruits (Orange, Orange, Orange, Apple, Apple) should cost 1.95` = {
    Shop.purchase(Array("orange", "orange", "orange", "apple", "apple")) === 1.95
  }
}
