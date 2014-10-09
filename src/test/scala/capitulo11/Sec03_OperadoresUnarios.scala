package capitulo11

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class Sec03_OperadoresUnarios extends FunSuite{
/**
 * Operadores infixos são operadores binários-eles têm dois 
 * parâmetros. Um operador com um único parâmetro é chamado 
 * operador unário. Se ele seque o argumento ele é chamado
 * de operador pós-fixado. A expressão
 * 		a identificador
 * é o mesmo que a chamada do método a.identificador().
 * Por exemplo:
 * 		1 toString
 * é o mesmo que
 * 		1.toString()
 * Os quatro operadores +,-,!,~ sáo permitidos como operadores
 * pré-fixados, aparecendo antes de seus argumentos. Eles são
 * convertidos em chamadas para métodos com o nome unary_operador.
 * Por exemplo:
 * 		-a
 * significa o mesmo que
 * 		a.unary_-
 */
}