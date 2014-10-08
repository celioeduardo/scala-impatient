package capitulo10

import java.io.PrintWriter
import java.util.Date

class OrdemConstrucaoTrait {

  /**
   * Assim como as classes traits podem ter construtores
   * composto de inicializações de campo e outras instruções
   * no corpo da trait.
   */
  
  trait Logger {
    def log(msg: String)
  }
  
  trait FileLogger extends Logger {
    val out = new PrintWriter("app.log") // Parte do construtor da trait
    out.println("# " + new Date().toString) // Também parte do construtor da trait
    
    def log(msg: String){out.println(msg); out.flush()} 
  }
  
  /**
   * Essas declarações são executadas durante a 
   * construção de qualquer objeto incorporando
   * a trait. Construtores executam na seguinte
   * ordem:
   * 
   *  - O construtor da superclasse é chamado primeiro
   *  - Os construtores da trait são executados depois do
   *    construtor da superclasse mas antes do construtor
   *    da subclasse
   *  - Traits são construídas da esquerda para a direita.
   *  - Dentro de cada trait os pais são construídos primeiro.
   *  - Se múltiplas traits compartilham um pai em comum, e o
   *    pai já foi construído, ele não é construído novamente.
   *  - Depois de todas as traits serem construídas a subclasse 
   *    é construída.
   *    
   *  Por exemplo, considere a classe SavingsAccount: 
   */
  
  trait ShortLogger extends Logger{}
  
  class Account
  class SavingsAccount extends Account with FileLogger with ShortLogger
  
  /**
   * Os construtores são executados na seguinte ordem:
   * - Account (A superclasse)
   * - Logger (O pai da primeira trait)
   * - FileLogger (a primeira trait)
   * - ShortLogger (a segunda trait). Note que seu pai já foi construído
   * - SavingsAccount (a classe)
   */
  
  /**
   * NOTA:
   * 
   * A ordem de construção é o reverso da linearização (linearization) 
   * da classe. A linearização é a especificação técnica de todas as
   * superclasses de um tipo. Ela é definida pela regra:
   * Se 
   *   C extends C1 with C2 with ... with Cn
   * então:
   *   lin(C) = C >> lin(Cn) >> ... >> lin(C2) >> lin(C1)
   * 
   * Aqui >> significa "concatene e remova duplicatas", com a direita
   * vencendo. Por exemplo: 
   * lin(SavingsAccount)
   * = SavingsAccount >> lin(ShorterLogger) >> lin(FileLogger) >> lin(Account)
   * = SavingsAccount >> (ShorterLogger >> Logger) >> (FileLogger >> Logger) >> lin(Account)
   * = SavingsAccount >> ShorterLogger >> FileLogger >> Logger >> Account
   *
   * Para simplicidade, foram omitidos os tipos ScalaObject, AnyRef e Any que estão 
   * mais ao fim de qualquer linearização. 
   * A linearização dá a ordem que super é resolvido em uma trait. Por exemplo,
   * chamar super em um ShortLogger invoca o método FileLogger e chamar super
   * em um FileLogger invoca o método Logger.
   */
  
  
}