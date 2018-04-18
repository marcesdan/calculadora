package calculadoraTest

import spock.lang.*
import calculadora.Calculadora

class RaizCuadradaSpec extends Specification {
    
    @Shared
    Calculadora calculadora = new Calculadora()
    
    @Unroll('Con el valor #x')
    def 'Se prueba el método raiz cuadrada'() {

    	expect:
        resultado == calculadora.raizCuadrada(x)

    	where:
            x   ||  resultado  
            4   ||  2
            9   ||  3
        }
        
    def 'Se prueba que al pasar un valor negativo, se lanza una excepción'() {
    	
        when:
            calculadora.raizCuadrada(-4)
        
        then:
            thrown(ArithmeticException)

            
    }
}
