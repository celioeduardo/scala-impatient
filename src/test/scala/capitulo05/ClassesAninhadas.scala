package capitulo05

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer

/**
 * Em Scala é possível aninhar praticamente tudo
 * dentro de tudo. Definir funções dentro de funções
 * e classes dentro de outras classes
 */

class Network{
  class Member(val name: String){
    val contacts = new ArrayBuffer[Member]
  }
  
  private val members = new ArrayBuffer[Member]
  
  def join(name: String) = {
    val m = new Member(name);
    members += m
    m
  }
}

/**
 * Em uma classe aninhada é possivel acessar uma 
 * referência da classe externa como ClasseExterna.this
 * como em Java. Alternativamente pode-se atribuir um
 * alias para esta referência com a seguinte sintaxe:
 */
class Net(name: String) { outer =>
  class Member(name: String){
    val contacts = new ArrayBuffer[Member]
	def description = name + " inside " + outer.name
  }
  
}

@RunWith(classOf[JUnitRunner])
class ClassesAninhadas extends FunSuite{
	
  test("adicionar membros somente em sua network"){
	  val chatter = new Network
	  val myFace = new Network
	  
	  val fred = chatter.join("Fred")
	  val wilma = chatter.join("Wilma")
	  fred.contacts += wilma
	  
	  val barney = myFace.join("Barney") //Tem o tipo myFace.Member
	  
	  //Um tipo myFace.Member não pode ser adicionado a 
	  //buffer de elementos chatter.Member
	  //fred.contacts += barney
  }
  
  test("acesso à classe externa com alias"){
    val chatter = new Net("Chatter")
    val martin = new chatter.Member("Martin")
    assert("Martin inside Chatter" == martin.description)
  }
  
  
}