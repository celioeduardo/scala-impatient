package capitulo11

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Infixo extends FunSuite{
  /**
   * Você pode escrever
   * 	a identificador b
   * onde identificador denota um método com dois parâmetros
   * (um implícito, um explícito). Por exemplo, a expressão
   * 	1 to 10
   * é na verdade uma chamada de método
   * 	1.to(10)
   * Isso  é chamado expressão infixa (infix) ou intercalada
   * porque o operador está entre os argumentos. O operador
   * pode conter letras, como em to, ou pode conter caracteres
   * operadores - por exemplo:
   * 	1 -> 10
   * é uma chamada de método
   * 	1 .->(10)
   *  
   * Para definir um operador em suar própria classe, simplesmente
   * defina um método em que o nome seja o operador desejado.
   * Por exemplo, aqui está uma classe Fracao que multiplica
   * duas frações conforme a regra:
   * (n1 / d1) x (n2 / d2) = (n1n2 /d1d2)
   */
	
    class Fraction(n: Int, d: Int){
      private val num = n
      private val den = d
      
      def *(other: Fraction) = new Fraction(num * other.num , den * other.den)
    }
    
    test("calcular Fraction"){
      val f1 = new Fraction(1,2)
      val f2 = new Fraction(3,4)
      f1 * f2 
    }
	
}