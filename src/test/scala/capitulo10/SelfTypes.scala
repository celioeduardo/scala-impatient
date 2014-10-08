package capitulo10

class SelfTypes {

  /**
   * Quando uma trait estende uma classe, existe uma garantia
   * que a supercasse está presente em qualquer classe mixando
   * a trait. Scala tem um mecanismo alternativo para garantir
   * isso: self types.
   * 
   * Quando uma trait inicia com
   * 	this: "Type" =>
   * então ela pode somente ser mixada em uma subclasse do 
   * tipo definido por "Type"
   * 
   */
  
  trait Logged {
    def log(msg:String)
  }
  
  trait LoggedException extends Logged {
    this: Exception =>
      def log() { log(getMessage()) }
  }
  
  /**
   * Note que a trait LoggedException não estende da classe
   * Exception. Ao invés, ela tem um self type de Exception.
   * Isso significa que essa trait só pode ser mixada em 
   * subclasses de Exception.
   * 
   * Nos métodos da trait, nós podemos chamar qualquer método
   * do self type. Por exemplo, a chamada para getMessage() no
   * método log é válida, uma vez que nós sabemos que this deve
   * ser uma Exception.
   * 
   * Se você tentar mixar uma trait em uma classe que não condiz
   * com o self type, um erro ocorre:
   * 	val f = new JFrame with LoggedException
   *  	// Erro: JFrame não é um subtype de Exception, o self type de LoggedException
   *   
   * Uma trait com um self type é similar a uma trait com um supertipo. Em
   * ambos os casos, é garantido que o tipo está presente em uma classe
   * que mixa a trait.
   * 
   * Existem algumas situações onde a notação self type é mais flexível que
   * traits com supertipos. Self types podem tratar dependências circulares
   * entre traits. Isso pode acontecer se você tem duas traits que precisam
   * uma da outra.
   * 
   * Self types podem também tratar structural types - tipos que simplesmente
   * specifica métodos que a classe deve ter, sem nomear a classe. Aqui está
   * o LoggedException1 usando um tipo estrutural (structural type)
   */
  trait LoggedException1 extends Logged{
    this: { def getMessage() : String } =>
      def log() { log(getMessage()) }
  }
  /**
   * Essa trait pode ser mixada em qualquer classe que tem um método getMessage.
   * Veja discussão de self types e structural types em mais detalhes no capítulo 18
   */
  
}