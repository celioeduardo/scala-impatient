package capitulo10

class CamposConcretosEmTraits {
  
  trait Logger{
    def log(msg:String) = {msg}
  }
  
  /**
   * Um campo em uma trait pode ser concreto ou 
   * abstrato. Se você fornecer um valor inicial
   * o campo é concreto.
   */
  trait ShortLogger extends Logger{
    val maxLength = 15 // Um campo concreto
    override def log(msg: String) = {
      super.log(
          if (msg.length <= maxLength) msg else msg.substring(0, maxLength - 3) + "..."
      )
    }
  }
  
  /**
   * Uma classe que mixa esta trait recebe
   * o campo maxField. Em geral, uma classe
   * obtem um campo para cada campo concreto
   * em uma de suas traits. Esses campos NÃO
   * são herdados; eles são simplesmente 
   * adicionados para a subclasse. Essa parece
   * ser uma distinção sutíl, mas é importante.
   * Vamos olhar o processo mais de perto.
   */

  trait ConsoleLogger extends Logger{
    override def log(msg: String) = { super.log("Console:[" + msg + "]")}
  }
 
  class Account {var balance = 0.0}
  class SavingsAccount extends Account with ConsoleLogger with ShortLogger {
    val interest = 0.0
    def withdraw(amount: Double) = {
      if (amount > balance) log("Insufficient funds")
      else {balance -= amount; "OK"}
    }
  }
  
  /**
   * Note que nossa subclasse tem um campo interest. Este é um
   * campo definido na própria subclasse.
   * Como a classe Account tem o campo balance, a subclasse 
   * SavingsAccount herda esse campo da maneira normal. O 
   * objeto SavingsAccount é formado de todos os campos 
   * de suas superclasses junto com qualquer outros campos
   * da subclasse. Você pode pensar no objeto SavingsAccount
   * como "começando" com um objeto superclasse.
   * 
   *    +------------+
   *    |  balance   | Objeto Superclasse
   *    |------------|
   *    |  interest  | Campos da
   *    |  maxLength | Subclasse
   *    +------------+
   *    
   * Na JVM, uma classe pode somente estender uma superclasse,
   * então os campos da trait não podem ser herdados da mesma
   * maneira. Ao invés, o campo maxLength é adicionado a classe
   * SavingsAccount depois do campo interest.
   * 
   * Você pode pensar nos campos concretos das traits como 
   * "instruções de montagem" para as classes que usam a trait.
   * Quaisquer desses campos tornam-se campos da classe.
   */
  
}