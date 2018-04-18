package calculadoraTest

import spock.lang.*
import calculadora.Calculadora

class DivisionSpec extends Specification {
    
    @Shared
    Calculadora calculadora = new Calculadora()

    @Unroll('Con los valores #x / #y')
    def 'Se prueba el metodo división'() {
    	
    	expect:
    		resultado == calculadora.division(x,y)

    	where:
    		x       |   y       ||  resultado
    		-10     |   10      ||      -1
    		-10	|   -10     ||      1
                -0.25	|   0.25    ||      -1
    		-0.25	|   -0.25   ||      1

                9**9**9**9   |   9**9**9**9   ||    1
                -9**9**9**9  |   9**9**9**9   ||    -1
                9**9**9**9   |   -9**9**9**9  ||    -1
                -9**9**9**9  |   -9**9**9**9  ||    1
                
                17  |       13     ||   1.3076923077
            }
    
    @Unroll
    def 'se prueba el metodo division, con divisor = 0'() {

    	when:
    		calculadora.division(0, 0)

    	then:
    		thrown(ArithmeticException)

    }
}
