package capitulo06

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

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
class ObjetoAcompanhante extends FunSuite{
	
  test("duas contas obtendo valor de um Object Companion"){
    val conta1 = new Account
    val conta2 = new Account
    
    assert(1 == conta1.id)
    assert(2 == conta2.id)
  }
  
}