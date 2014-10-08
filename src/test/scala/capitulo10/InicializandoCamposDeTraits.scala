package capitulo10

import java.io.PrintWriter
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite


@RunWith(classOf[JUnitRunner])
class InicializandoCamposDeTraits extends FunSuite{
  
/**
 * Traits não podem parâmetros no construtor. Toda
 * trait tem somente um único construtor sem parâmetro.
 * 
 * Interessante que a ausência de parâmetros no construtor
 * é a única diferença técnica entre classes e traits. 
 * Por outro lado, traits podem tem todos os recursos de 
 * classes, como campos abstratos e concretos e superclasse.
 * 
 * Essa limitação pode ser um problema para traits que precisam
 * de alguma customização para serem úteis. Considere o 
 * file logger. Nós gostaríamos de especificar o arquivo de log,
 * mas não podemos usar um construtor com parâmetro.
 *     val acct = new SavingsAccount extends Account with FileLogger("myapp.log")
 *     // Erro: não pode ter construtor com parâmetros para traits. 
 * 
 * Uma alternativa é a trait FileLogger ter um campo abstrato para 
 * o nome do arquivo.
 */
  
  trait Logger{
    def log(msg:String) {}
  }
  
  trait FileLogger extends Logger{
    val filename: String
    val out = new PrintWriter(filename)
    override def log(msg:String) { out.println(msg); out.flush() }
  }
  
  class Account
  class SavingsAccount extends Account with Logger
  
  test("armadilha ao sobrescrever campo abstrato em trait"){
  
	// Uma classe usando essa trait poderia sobrescrever o campo filename.
	// Infelizmente existe uma armadilha. A abordagem direta NÃO funciona:
    intercept[NullPointerException] {
      val acct = new SavingsAccount with FileLogger {
		val filename = "myapp.log"
      }
	}
    // O problema é a ordem de construção. O construtor do 
    // FileLogger executa antes do construtor da subclasse.
    // Aqui a subclasse é um pouco difícil de ver. A declaração
    // new constrói uma instância de uma classe anônima 
    // estendendo SavingsAccount (a superclasse) com a trait
    // FileLogger. A inicialização do filename só acontece na
    // construção da subclasse anônima. Na verdade, isso nem
    // mesmo acontece, antes da subclasse rodar, um null pointer
    // exception é lançado no construtor do FileLogger.
  
  }
  
  test("sobrescrever campo com early definition"){
    // Um remédio para esse recurso obscuro foi descrito no
    // capítulo 8 - Early Definition. 
    // Aqui está a versão correta:
    
    val acct = new { // Bloco early definition depois do new
      val filename = "myapp.log"
    } with SavingsAccount with FileLogger
    // Isso não é bonito mas resolve nosso problema. 
    // A early definition ocorre antes da sequência normal
    // de construção. Quando FileLogger é construído,
    // o filename é inicializado.
    
    // Se você precisar do mesmo em uma classe, a sintaxe
    // seria:
    class SavingsAccount1 extends { // Early definition depois do extends
      val filename = "myapp.log"
    } with Account with FileLogger {
      // implementação do SavingsAccount1
    }
    
    // Outra alternativa é usar o valor lazy no construtor
    // do FileLogger
    
    trait Logger1 {
      def log(msg:String)
    }
    
    trait FileLogger1 extends Logger1{
      val filename: String
      lazy val out = new PrintWriter(filename)
      def log(msg:String) { out.println(msg); out.flush() }
    }
    // O campo out é inicializado quando for usado pela primeira
    // vez. Nesse momento, o campo filename já terá sido definido.
    // Porém, valores lazy são ineficientes uma vez que são sempre
    // verificados para inicialização antes de serem usados
  }
  
    
    
  
  
}