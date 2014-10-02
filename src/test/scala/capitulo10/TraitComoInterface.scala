package capitulo10

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import java.lang.Cloneable
import java.io.Serializable

@RunWith(classOf[JUnitRunner])
class TraitComoInterface extends FunSuite{
  
  // Uma trait Scala pode trabalhar exatamente
  // como uma interface Java
  test("trait Scala como interface Java"){
	  
	  trait Logger{
	    def log(msg: String) //Um método abstrato
	  }
	  
	  // Uma subclasse fornece uma implementação
	  class ConsoleLogger extends Logger{ // Use extends não implements
	    def log(msg: String) {println(msg)} // Não precisa especificar override
	  }
	  
	  // Se precisar de mais de uma trait, adicione outras usando
	  // a palavra chave with
	  // Aqui foram usadas as interfaces Cloneable e Serializable da 
	  // biblioteca do Java, apenas para mostrar a sintaxe. Todas as
	  // interfaces Java podem ser usadas como Scala traits
	  // Como em Java, uma classe Scala pode extender somente de 
	  // uma classe mas pode ter qualquer número de traits
	  class ConsoleLogger1 extends Logger with Cloneable with Serializable{
	    def log(msg: String) {println(msg)}
	  } 
  }
  
}