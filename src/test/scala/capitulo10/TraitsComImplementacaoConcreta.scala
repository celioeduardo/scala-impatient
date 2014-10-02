package capitulo10

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class TraitsComImplementacaoConcreta extends FunSuite{

  // Em Scala, os métodos de uma trait não precisam ser 
  // abstratos.
  test("trait com método concreto"){
    
    // A trait ConsoleLogger fornece um método
    // como uma implementação, nesse caso um 
    // que imprime a mensagem de log no console.
    trait ConsoleLogger {
      def log(msg: String) {println(msg)}
    }
    
    // Exemplo de como usar essa trait
    class Account(var balance: Double)
    // Em Scala (e em outras linguagens tha permitem isso)
    // nós dizemos que a funcionalidade ConsoleLogger está
    // mesclada ("mixed in") com a classe SavingAccounts 
    class SavingAccounts(_balance: Double) 
    	extends Account(_balance) with ConsoleLogger{
      
      def withdraw(amount: Double) = {
        if (amount > balance){ 
          log("Insufficient funds"); false
        }
        else {
          balance -= amount; true
        }
      }
    }
    
    val a1 = new SavingAccounts(50);
    val a2 = new SavingAccounts(50);
    
    assert(true == a1.withdraw(20))
    assert(false == a2.withdraw(60))
    
  }
  
}