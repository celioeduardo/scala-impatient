package capitulo6

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite


/**
 * Cada programa Scala precisa começar com um
 * método de objeto main do tipo Array[String] => Unit
 */
object HelloA {
  def main(args: Array[String]){
    println("Hello, World!")
  } 
}

/**
 * Ao invés de fornecer um método main, pode-se extender
 * a App trait e colocar o código do programa dentro do
 * construtor
 */
object HelloB extends App{
 if (args.length > 0)
    println("Hello, " + args(0))
  else
    println("Hello, World!")
}

@RunWith(classOf[JUnitRunner])
class ObjetosApplication extends FunSuite{
	
}