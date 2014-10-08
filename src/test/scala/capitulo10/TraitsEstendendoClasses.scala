package capitulo10

import java.io.IOException

class TraitsEstendendoClasses {
  
  /**
   * Uma trait pode estender outra trait e é comum ter
   * uma hierarquia de traits. Embora seja menos comum,
   * uma trait pode extender uma classe. Essa classe 
   * torna-se a superclasse de qualquer classe mixando
   * a trait.
   */
	
  /**
   * Exemplo: A trait LoggedException estende a classe
   * Exception
   */
  trait Logged {
    def log(msg: String) { println(msg) } 
  }
  trait LoggedException extends Exception with Logged {
    def log() { log(getMessage()) }
  }
  
  // Um LoggedException tem um método log para logar 
  // a mensagem da exceção. Note que o método log 
  // chama o método getMessage que é herdado da 
  // superclasse Exception.
  
  // Agora vamos formar uma classe que mixa com essa trait
  class UnhappyException extends LoggedException { // Essa classe estende uma trait
    override def getMessage() = "arggh!"
  }
  // A superclasse da trait torna a superclasse de nossa classe.
  
  // E se nossa subclasse já estendesse outra superclasse? 
  // Não há problemas se ela for uma subclasse da superclasse
  // da trait. Exemplo:
  class UnhappyException1 extends IOException with LoggedException
  // Aqui a classe UnhappyException1 estende de IOException que já 
  // estende Exception. Quando mixar a trait, sua superclasse já 
  // está presente, e não há necessidade de adicioná-la.
  
  // Porém se sua classe estende de classes não relacionadas, então
  // não é possível mixá-la na trait. Por exemplo, você não pode
  // formar a seguinte classe:
  // class UnhappyException extends JFrame with LoggedException
  //       Erro: superclasses não relacionadas
  // Seria impossível adicionar JFrame e Exception como superclasses.
  
  
  
  
  
}