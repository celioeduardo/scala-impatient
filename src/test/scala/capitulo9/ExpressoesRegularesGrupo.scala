package capitulo9

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

/**
 * Grupos são úteis para subexpressões de expressões
 * regulares. Adicione parênteses entre as subexpressões
 * que você deseja extrair.
 */

@RunWith(classOf[JUnitRunner])
class ExpressoesRegularesGrupo extends FunSuite{
	
  // para encontrar os grupos, use o objeto
  // expressão regular como um "extrator"
  test("extrair correspondência de grupos"){
    val numitemPattern = "([0-9]+) ([a-z]+)".r
    
    val numitemPattern(num, item) = "99 bottles"
    assert("99" == num)
    assert("bottles" == item)
    
  }
  
  test("extrair múltiplas correspondências de grupos diferentes"){
    val numitemPattern = "([0-9]+) ([a-z]+)".r
    for (numitemPattern(num,item) <- numitemPattern.findAllIn("99 bottles, 98 bottles")){
      assert(num == "99" || num == "98")
      assert(item == "bottles")
    }
  }
  
  test("extrair múltiplas correspondências do mesmo grupo"){
    val numitemPattern = "([0-9]+)+".r
    val valores = numitemPattern.findAllIn("99 98,97 ").toArray
    assert(Array("99","98","97").deep == valores.deep)
  } 
  
}