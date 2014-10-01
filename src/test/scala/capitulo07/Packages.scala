package capitulo7

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.junit.runner.RunWith
import org.scalatest.FunSuite
/**
 * A classe Employee pode ser acessada em qualquer lugar
 * como capitulo7.scala.impatient.Employee.
 * Diferente da definição de um objeto ou classe, uma
 * package pode estar definida em multiplos arquivos.
 * 
 * Não há uma relação imposta entre o diretório
 * do arquivo de origem e a package, ou seja,
 * não é necessário que a classe Employee esteja
 * no diretório capitulo7/scala/impatient
 * 
 */
package scala {
  package impatient{
    class Employee (val nome: String) 
  }
}

/**
 * Também é possível definir mais de uma package em 
 * um mesmo arquivo.
 */
package big {
  package capitulo07{
    class Counter
  }
}

@RunWith(classOf[JUnitRunner])
class Packages extends FunSuite{
	
  test("usando uma classe em uma package"){
    val kent = new capitulo7.scala.impatient.Employee("Kent Beck")
    assert("Kent Beck"==kent.nome)
  }
  
}