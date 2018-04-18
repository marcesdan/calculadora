package calculadora

/**
 *
 * @author marces
 */
class Utils {
    
    static def esCero(BigDecimal x) {
        x.abs() < 0.000000001
    }
}

