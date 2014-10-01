package capitulo05

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite


/**
 * Em Scala uma classe não é declarada como public.
 * Um Scala source pode conter varias classes, todas com
 * visibilidade publica
 */
class Counter{
  private var value = 0;
  def increment() {value +=1}
  def current = value;
}


@RunWith(classOf[JUnitRunner])
class ClassesSimples extends FunSuite{
  
  test("usando uma classe simples"){
    val myCounter = new Counter //ou new Counter()
    myCounter.increment();
    assert(1 == myCounter.current) //métodos podem ser chamados sem parênteses
    //É considerado um bom estilo usar () para métodos que mudam
    //estado e omitir os parênteses para acessores
  }

}