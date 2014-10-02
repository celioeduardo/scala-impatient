package capitulo10

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import scala.sys.process.FileProcessLogger

/**
 * Você pode adicionar uma trait a um objeto individual
 * quando você o constrói. 
 */

@RunWith(classOf[JUnitRunner])
class ObjetosComTraits extends FunSuite{
	
  test("objeto individual com uma trait"){
    
    trait Logged {
      def log(msg :String) { } // implementação sem operação
    }
    
    class Account
    
    class SavingsAccount extends Account with Logged {
      var balance = 0;
      def withdraw(amount: Double){
        if (amount > balance) log("Insufficient funds")
        //else ...
      }
    }
    
    // Conforme definido acima nada é logado, o que pode ser inútil.
    // Mas você pode misturar um logger melhor ao construir um objeto.
    // O ConsoleLogger estende a trait Logged
    trait ConsoleLogger extends Logged {
      override def log(msg: String){ println(msg) }
    }
    
    // Você pode adicionar essa trait quando constuir o objeto
    val acct = new SavingsAccount with ConsoleLogger
    
    // Quando chamar log no objeto acct, o método log da trait 
    // ConsoleLogger é executado
    // Outro objeto pode adicionar uma trait diferente
    trait FileLogger extends Logged {
      override def log(msg: String){ /* grava em arquivo... */ }
    }
    
    val acct2 = new SavingsAccount with FileLogger
    
  }
  
}