package capitulo10

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class CamposAbstratosEmTraits extends FunSuite {

  /**
   * Um campo não inicializado em uma trait é abstrato e 
   * deve ser sobrescrito na sublcasse concreta.
   */
  trait Logger{
    def log(msg:String) = {msg}
  }
 
  trait ShortLogger extends Logger{
    val maxLength: Int // Um campo abstrato
    override def log(msg: String) = {
      super.log(
          if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "..."
      )
    }
  }
  
  /**
   * Quando ovcê usa essa trait em uma classe concreta você
   * precisa fornecer o campo maxLength
   */
  
  class Account
  class SavingsAccount extends Account with ShortLogger {
    val maxLength = 20 // Sem necessidade da palavra chave override
  }
  /**
   * Agora todas as mensagens de log serão truncadas depois de 20 
   * caracteres.
  */
    
  /**
   * Essa maneira de fornecer valores para parâmetros de trait é
   * particularmente útil quando você constrói objetos na hora.
   * Vamos voltar ao nosso objeto SavingsAccount original
   */
  class SavingsAccountOriginal extends Account with Logger{ } 
  
  val acct = new SavingsAccountOriginal with ShortLogger {
    val maxLength = 20;
  }
  
}