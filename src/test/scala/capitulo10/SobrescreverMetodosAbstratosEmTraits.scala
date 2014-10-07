package capitulo10

class SobrescreverMetodosAbstratosEmTraits {

  trait Logger {
    def log(msg: String) // Este é um método abstrato
  }
  
  trait TimestampLogger extends Logger {
  //  ** ERRO DE COMPILAÇÃO **
  //  override def log(msg: String) {
  //    super.log(new java.util.Date() + " " + msg)
  //  }
    
    // A construção acima não funcionaria porque não
    // há como saber qual método log está sendo realmente
    // chamado - isso depende da ordem que as traits estão 
    // sendo "mixadas"
    
    // Scala assume que TimestampLogger.log ainda é abstrato
    // - isso exige um método log concreto para ser "mixado".
    // Você precisa marcar o método com as palavras chave
    // abstract e override assim:
    
    abstract override def log(msg: String) {
      super.log(new java.util.Date() + " " + msg)
    }
    
  }
  
  
  
}