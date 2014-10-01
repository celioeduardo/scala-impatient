package capitulo09

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

/**
 * Quando você processa input, frequentemente quer usar
 * expressões regulares para analisar esse input.
 * A classe scala.util.matching.Regex torna isso simples.
 */

@RunWith(classOf[JUnitRunner])
class ExpressoesRegulares extends FunSuite{
	
  // Para construir um objeto Regex, use o método r de uma
  // classe String
  test("padrão regex para número"){
    val numPattern = "[0-9]+".r
  }  
  
  // Se a expressão regular contém barras invertidas e 
  // aspas, então é uma boa idéia usar sintaxe string 
  // "raw" """..."""
  test("sintaxe raw string"){
    val wsnumwsPattern = """\s+[0-9]+\s+""".r
    //um pouco mais fácil de ler do que
    val wsnumwsPattern2 = "\\s+[0-9]+\\s+".r
  }
  
  // O método findAllIn retorna um iterator que
  // percorre todas as correspondências. 
  test("todas as correspondências numéricas"){
    val numPattern = "[0-9]+".r
    var s = ""
    
      // Você pode usar um for loop
    for (matchString <- numPattern.findAllIn("99 bottles, 98 bottles")) s += matchString + " "
    assert("99 98 " == s)
    
    // Ou converter o iterator em um array
    val matches = numPattern.findAllIn("99 bottles, 98 bottles").toArray
    assert(Array("99","98").deep == matches.deep)
    
  }
  
  test("primeira correspondência"){
    // Para encontrar a primeira correspondência em uma string use 
    // findFirstIn. Você obtém um Option[String]
    val wsnumwsPattern = """\s+[0-9]+\s+""".r
    val m1 = wsnumwsPattern.findFirstIn("99 bottles, 98 bottles")
    assert(Some(" 98 ") == m1)
  }
  
  test("verificar início de uma string"){
	val numPattern = "[0-9]+".r
    val wsnumwsPattern = """\s+[0-9]+\s+""".r
    // Para verificar se o início de uma string
    // corresponde ao padrão, use
    assert(Some("99") == numPattern.findPrefixOf("99 bottles, 98 bottles"))
	assert(None == wsnumwsPattern.findPrefixOf("99 bottles, 98 bottles"))
  }
  
  test("substituir correspondências"){
    val numPattern = "[0-9]+".r
    assert("XX bottles, 98 bottles" == numPattern.replaceFirstIn("99 bottles, 98 bottles", "XX"))
    assert("XX bottles, XX bottles" == numPattern.replaceAllIn("99 bottles, 98 bottles", "XX"))
  }
  
}