package calculadoraTest

import spock.lang.*
import calculadora.Calculadora

class SumaSpec extends Specification {
    
    @Shared
    Calculadora calculadora = new Calculadora()
    
    @Unroll('Con los valores #x + #y')
    def 'Se prueba el método suma'() {

    	expect:
            resultado == calculadora.suma(x,y)

    	where:
            x       |	y	||  resultado  
            1       |	1	||  2
            -100    |	-100	||  -200
            -0.25   |	-0.25	||  -0.50
            9**9**9**9   |   9**9**9**9   ||  878657007392928659659549565314145424116020616354253421243353395500932689489528059546602825224965127458870129708708598191140759006905031706477040365481934797493007064648800001319010252047911826285936353996729755398179332342594551912490814906066380337289789701152692985382917390348563579115989847215566922972852897235334152787802208954649965262595282068554187637385646977206852558947348737887218537743586934413354571376956916996470005718513412778086061695891013154161246860132567008795167578088490859171965929143549211736932320759134865451408242521881878686435811951694730192631744306481939764726870726899550508786020736534687940852461602780501806798294003301663757330345596937175019494878237631378
        }
    
    def 'Se prueba que al pasar parámetros distintos de BigDecimal, se lanza una excepción '() {

    	when:
            double x1 = 2
            double x2 = 2
            calculadora.suma(x1,x2)
        
        and:
            String x3 = '2'
            String x4 = '2'
            calculadora.suma(x3,x4)

    	then:
            thrown(MissingMethodException)
    }
}