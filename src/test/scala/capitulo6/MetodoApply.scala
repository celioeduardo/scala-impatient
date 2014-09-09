package capitulo6

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

class BankAccount private (val id: Int, initialBalance: Double){
  private var _balance = initialBalance;
  
  def balance = _balance
}

object BankAccount {
  var lastId = 0
  
  def apply(initialBalance: Double) = new BankAccount(newUniqueNumber(),initialBalance)
  
  def newUniqueNumber() = {lastId += 1; lastId}
}


@RunWith(classOf[JUnitRunner])
class MetodoApply extends FunSuite{
	
  test("definição de contas bancárias com o método apply()"){
    val conta1 = BankAccount(1000.0)
    val conta2 = BankAccount(6547.98)
    
    assert(1 == conta1.id)
    assert(1000 == conta1.balance)
    
    assert(2 == conta2.id)
    assert(6547.98 == conta2.balance)
    
  }
  
}