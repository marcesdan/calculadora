package calculadoraTest

import spock.lang.*
import calculadora.Calculadora

class RaizCubicaSpec extends Specification {
    
    @Shared
    Calculadora calculadora = new Calculadora()
    
    @Unroll('Con el valor #x')
    def 'Se prueba el método raiz cuadrada'() {

    	expect:
            resultado == calculadora.raizCubica(x)

    	where:
            x   ||  resultado  
            8   ||  2
            27  ||  3
            -8  ||  -2
            -27 ||  -3
    }
}
