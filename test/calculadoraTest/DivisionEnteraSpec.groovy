package calculadoraTest

import spock.lang.*
import calculadora.Calculadora

class DivisionEnteraSpec extends Specification {
    
    @Shared
    Calculadora calculadora = new Calculadora()
    
    @Unroll
    def 'se prueba el metodo division enetera, con #x - #y'() {
    	
    	expect:
    		resultado == calculadora.divisionEntera(x,y)

    	where:
                x       |	y	||	resultado
                -10	|	3	||	-3
    		-10	|	-3	||	3
    		
                    1        |   9**9**9**9   ||    0
                9**9**9**9   |   9**9**9**9   ||    1
                -9**9**9**9  |   9**9**9**9   ||    -1
                9**9**9**9   |   -9**9**9**9  ||    -1
                -9**9**9**9  |   -9**9**9**9  ||    1
                    
    }
    
    @Unroll
    def 'se prueba el metodo division, con divisor = 0'() {

    	when:
    		calculadora.divisionEntera(0, 0)

    	then:
    		thrown(ArithmeticException)

    }
}
