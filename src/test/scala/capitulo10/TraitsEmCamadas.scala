package capitulo10

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

/**
 * Você pode adicionar, a uma classe ou a um objeto,
 * múltiplas traits que chamam umas as outras começando
 * pela última. Isso é útil quando você precisa transformar
 * um valor em etapas
 */


@RunWith(classOf[JUnitRunner])
class TraitsEmCamadas extends FunSuite{

  trait Logged {
    def log(msg: String) = {""}
  }
  
  trait ConsoleLogger extends Logged {
    override def log(msg: String) = { "LOG: " + msg }
  }
  
  trait TimestampLogger extends Logged {
    override def log(msg: String) = {
      super.log("02/09/2014 13:59 " + msg)
      // Definido horário fixo para facilitar o
      // assert no test. O ideal seria usar:
      //super.log(new java.util.Date() + " " + msg)
    }
  }
  
  trait ShortLogger extends Logged {
    val maxLength = 15
    override def log(msg: String) = {
      super.log(
          if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "..."
      )
    }
  }
  
  // Note que cada um dos métodos log passa uma mensagem
  // modificada para super.log
  
  // Com traits, super.log não tem a mesma intenção que com
  // classes. (Se tivesse, então essas traits seriam inúteis - 
  // elas estenderiam de Logged cujos métodos não fazem nada
  // Ao invés disso, super.log chama a próxima trait em hierarquia
  // de traits, no qual depende da ordem em que as tratis foram
  // adicionadas. Geralmente, traits são processadas começando
  // com a última. (Seções posteriores considerarão detalhes 
  // quando as traits formam uma árvore arbitrária e não somente
  // uma cadeia)
  
  class Account
    
  class SavingsAccount extends Account with Logged {
    var balance = 10;
    def withdraw(amount: Double) = {
      if (amount > balance) log("Insufficient funds")
      else log("OK")
    }
  }
  
  test("traits em camadas"){
	
    val acct1 = new SavingsAccount with ConsoleLogger with 
	  TimestampLogger with ShortLogger
	
	// O método log do ShortLogger foi chamado primeiro, 
	// e sua chamada para super.log invocou o TimestampLogger
	assert("LOG: 02/09/2014 13:59 Insufficient..." == acct1.withdraw(25))
    
    val acct2 = new SavingsAccount with ConsoleLogger with 
	  ShortLogger with TimestampLogger
	// Já nesse outro caso, o TimeStampLogger aparece por último,
	// na lista de traits. Sua mensagem de log foi chamada primeiro,
	// e o resultado foi encurtado.
	assert("LOG: 02/09/2014 1..." == acct2.withdraw(25))
    
    // Com traits, você não pode dizer através do código fonte
    // qual método é chamado por super.algumMetodo. O método 
    // extato depende da ordem das traits no objeto ou classe 
    // que as usa. Isso torna super muito mais flexível que 
    // a herança da maneira tradicional.
    
    // Se você precisar controlar qual método da trait
    // é chamado, você pode especificá-lo entre colchetes
    // super[ConsoleLogger].log(...). O tipo especificado
    // precisa ser um supertipo imediato; você não pode
    // acessar traits ou classes que estão mais adiante
    // na hierarquia da herança.
    
  }
  
}