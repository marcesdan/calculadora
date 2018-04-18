package calculadoraTest

import spock.lang.*
import calculadora.Calculadora

class RestaSpec extends Specification {
    
    @Shared 
    Calculadora calculadora = new Calculadora()

    @Unroll('Con los valores #x - #y')
    def 'Se prueba el método resta'() {
    	
    	expect:
                resultado == calculadora.resta(x,y)

    	where:
    		x	|	y	||	resultado
                10	|	10	||	0
    		-10	|	10	||	-20
    		-10	|	-10	||	0
    		-0.25	|	0.25	||	-0.50
    		-0.25	|	-0.25	||	0
                9**9**9**9 |   9**9**9**9     ||      0
                
    }
}
