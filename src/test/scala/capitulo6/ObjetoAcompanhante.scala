package capitulo6

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

class Account{
  val id = Account.newUniqueNumber()
  private var balance = 0.0
  def deposit(amount: Double){ balance += amount}
}

object Account{
  private var lastNumber = 0
  def newUniqueNumber() = { lastNumber += 1; lastNumber}
}

@RunWith(classOf[JUnitRunner])
class ObjetoAcompanhante {
	
}