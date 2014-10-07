package capitulo10

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class TraitsParaInterfacesRicas extends FunSuite{
  
  /**
   * Uma trait pode ter muitos métodos utilitários que 
   * dependem de alguns métodos abstratos. Um exemplo
   * é a trait Scala Iterator que define dezenas de métodos
   * em termos dos métodos abstratos next e hasNext.
   * 
   * Vamos enriquecer nossa API log anêmica. Geralmente
   * uma API de log permite você especificar um nível 
   * para cada mensagem de log para distinguir mensagens
   * informais de avisos ou erros. Nós podemos facilmente 
   * adicionar essa capacidade sem forçar qualquer regra
   * para o destino das mensagens de log
   */
  
  trait Logger {
    def log(msg: String): String
    def info(msg: String) = { log("INFO: "+msg) }
    def warn(msg: String) = { log("WARN: "+msg) }
    def severe(msg: String) = { log("SEVERE: "+msg) }
  }
  
  // Note a combinação do método abstrato e dos métodos
  // concretos.
  // Uma classe que usa a trait Logger pode agora chamar 
  // qualquer um dessas mensagens de log.
  class Account
  class SavingsAccount extends Account with Logger {
    var balance = 100.0;
    def withdraw(amount: Double) = {
    	if (amount > balance) severe("Insufficient funds")
    	else { balance -= amount; "OK" }
    }
    override def log(msg: String) = msg
  }
  
  test("combinacao de métodos abstratos e concretos em traits"){
    val acc1 = new SavingsAccount
    assert("SEVERE: Insufficient funds" == acc1.withdraw(150))
    
    val acc2 = new SavingsAccount
    assert("OK" == acc2.withdraw(50))
  }
  
  // O uso de métodos concretos e abstratos em uma trait é 
  // muito comum em Scala. Em Java, você precisaria declarar
  // uma interface e uma classe separada extendendo a interface,
  // tais como (Collection/AbstractCollection ou 
  // MouseListener/MouseAdapter)
  
}