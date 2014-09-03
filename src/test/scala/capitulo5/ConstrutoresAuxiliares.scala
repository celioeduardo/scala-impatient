package capitulo5

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

/**
 * Classes Scala tem que ter um construtor que é mais
 * importante que os outros, chamado construtor primário.
 * Adicionalmente uma classe pode ter varios outros
 * construtores auxiliares
 *
 * Cada construtor auxiliar é chamado this e tem que 
 * chamar em primeiro lugar um outro construtor auxiliar
 * ou o construtor primário
 */

class Pessoa{
  private var name = ""
  private var age = 0
  
  def this(name: String){// Um construtor auxiliar
    this() //Está chamando o construtor primário
    this.name = name;
  }
  
  def this(name: String, age: Int){ //Outro construtor auxiliar
    this(name) //Está chamando o construtor auxiliar anterior
    this.age = age
  }
  
}

@RunWith(classOf[JUnitRunner])
class ConstrutoresAuxiliares extends FunSuite{

  test("construtores auxiliares"){
    val p1 = new Pessoa //Construtor primário
    val p2 = new Pessoa("Fred") //Primeiro construtor auxiliar
    val p3 = new Pessoa("Fred", 42) //Segundo construtor auxiliar
  }
  
}