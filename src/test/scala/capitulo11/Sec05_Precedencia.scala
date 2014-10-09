package capitulo11

class Sec05_Precedencia {
/**
 * Quando você tem dois ou mais operadores em uma linha sem 
 * parênteses, aqueles com maior precedência são executados 
 * primeiro. Por exemplo, na expressão:
 * 		1 + 2 * 3
 * o operador * é calculado primeiro. Linguagens como Java e
 * C++ tem um número fixados de operadores, e a linguagem 
 * tem regras padronizadas sobre quem tem precedência sobre 
 * quem. Scala tem operadores arbitrários, então ela usa um
 * esquema que trabalha com todos operadores, embora também
 * tem uma ordem de precedência familiar a aquelas padronizadas.
 * 
 * Exceto para operadores de atribuição, a precedência é 
 * determinada pelo primeiro caracter do operador.
 * 
 *  -------------------------------------------
 *   Maior precedência: Um caracter operador
 *   exceto os abaixo
 *  -------------------------------------------
 *   * / % 
 *  -------------------------------------------
 *   + -
 *  -------------------------------------------
 *   :
 *  -------------------------------------------
 *   < >
 *  -------------------------------------------
 *   ! = 
 *  -------------------------------------------
 *   & 
 *  -------------------------------------------
 *   ^
 *  -------------------------------------------
 *   |
 *  -------------------------------------------
 *   Um caracter que não é um operador caracter
 *  -------------------------------------------
 *   Menor precedência: Operadores atribuição
 *  -------------------------------------------  
 *  
 *  Caracteres na mesma linha levam a operadores
 *  com a mesma precedência.
 *  Operadores pós-fixados tem precedência menor
 *  que operadores infixos:
 *  	a infixOp b postfixOp
 *  é o mesmo que
 *  	(a infixOp b) postfixOp
 */
}