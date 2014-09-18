package capitulo8

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

/**
 * Quando você sobrescreve um val em uma classe e usa o
 * valor em uma superclass, o comportamento resultante
 * não é intuitivo.
 */
class Creature{
  val range:Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2
}

/**
 * Existe um problema! O valor range é usado no
 * construtor da superclasse, e o construtor da 
 * superclasse roda antes do construtor da subclasse.
 * Especificamente acontece o seguinte:
 * 1) O construtor Ant chama o construtor de Create 
 *    antes de fazer sua própria construção
 * 2) O construtor de Creature define seu campo 
 * 	  range como 10
 * 3) O construtor de Creature, para inicializar o
 *    array env chama o getter range()
 * 4) Esse método é sobrescrito para levar o campo
 *    range para a classe Ant
 * 5) O método range retorna 0. (Esse é o valor 
 *    inicial de todos os campos integers quando
 *    um objeto é alocado
 * 6) env é definido para um array de tamanho 0
 * 7) O construtor Ant continua, definindo o campo
 *    range para 2
 *
 * Embora pareça que range é definido como 10 ou 2,
 * env foi definido como um array de tamanho 0. 
 * Sendo assim, não deveria chamar o valor de val
 * no corpo de um construtor.
 * 
 * Contudo é possível usar a sintaxe "early definition"
 * na subclasse. Isso permite iniciar campos val da 
 * subclasse antes da superclasse ser executada. A 
 * sintaxe é meio estranha. Coloca-se os campos val
 * em um bloco depois da palavra chave extends, exemplo:
 */

class AntEarly extends {
  override val range = 2
} with Creature

@RunWith(classOf[JUnitRunner])
class OrdemConstrucaoEarlyDefinitions extends FunSuite{
  
  test("inicialização não intuitiva"){
    val ant = new Ant()
    assert(ant.env.length == 0) //Inexperado
  }
  
  test("inicialização com early declaration"){
    val ant = new AntEarly()
    assert(ant.env.length == 2)
  }
}