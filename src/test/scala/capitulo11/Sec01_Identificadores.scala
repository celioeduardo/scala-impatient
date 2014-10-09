package capitulo11

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Identificadores extends FunSuite{
/**
 * Os nomes de variáveis, functions, classes, etc... são chamados
 * identificadores. Em Scala, você tem mais escolhas para formar
 * identificadores do que em Java. É claro, que você pode seguir
 * consagrado padrão: sequências de caracteres alfanuméricos, 
 * começando com um caracter alfabético ou um underscore, tal
 * como fred12 ou _Wilma
 * 
 * Como em Java, caracteres Unicode são permitidos. Por exemplo,
 * José ou σoφός são identificadores válidos.
 * 
 * Além disso, você pode usar qualquer sequência de caracteres
 * operador:
 * 		- Caracteres ASCII além de letras, dígitos, underscore,
 *   	parênteses ()[]{}, ou delimitadores .,;'`". Em outras
 *    	palavras, qualquer dos !#%&*+-/:<=>?@\^|~
 *     
 *     	- Símbolos matemáticos Unicode ou outros símbolos das
 *      categorias Sm ou So do Unicode
 */
  test("identificadores de variáveis"){
    // ** e √ são identificadores válidos.
    val √ = scala.math.sqrt _
    val ** = "**"
	val !#%&*+-/:<=>?@\^|~ = "!#%&*+-/:<=>?@\\^|~"
	assert(2 == √(4))
	assert("**" == **)
	assert("""!#%&*+-/:<=>?@\^|~""" == !#%&*+-/:<=>?@\^|~)
	
	// Finalmente, você pode incluir praticamente qualquer
	// sequêcia de caracteres entre crases
	val `val` = 42
	assert(42 == `val`)
	// Esse é uma exemplo bobo, mas crases podem algumas vezes
	// ser uma saída de emergência. Por exemplo, em Scala, yield
	// é uma palavra reservada, mas você pode precisar acessar 
	// um método Java com o mesmo nome: Thread.`yield`()
	
  }
    
}