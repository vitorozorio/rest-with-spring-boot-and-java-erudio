package br.com.erudio;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable (value = "numberOne") String numberOne,
            @PathVariable (value = "numberTwo") String numberTwo
            ) throws Exception {
        if  (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(
            @PathVariable (value = "numberOne") String numberOne,
            @PathVariable (value = "numberTwo") String numberTwo
    ) throws Exception {
        if  (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) * covertToDouble(numberTwo);
    }

    @RequestMapping(value = "/Division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double Division(
            @PathVariable (value = "numberOne") String numberOne,
            @PathVariable (value = "numberTwo") String numberTwo
    ) throws Exception {
        if  (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return covertToDouble(numberOne) / covertToDouble(numberTwo);
    }

    @RequestMapping(value = "/Media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double Media(
            @PathVariable (value = "numberOne") String numberOne,
            @PathVariable (value = "numberTwo") String numberTwo
    ) throws Exception {
        if  (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return ( (covertToDouble(numberOne) + covertToDouble(numberTwo) ) / 2)  ;
    }

    @RequestMapping(value = "/squareRoot/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Map<String, Double> squareRoot(
            @PathVariable (value = "numberOne") String numberOne,
            @PathVariable (value = "numberTwo") String numberTwo
    ) throws Exception {
        if  (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Map<String, Double> result = new HashMap<>();
        result.put("raizSeparada", Math.sqrt(covertToDouble(numberOne)) + Math.sqrt(covertToDouble(numberTwo)));
        result.put("raizDaSoma", Math.sqrt(covertToDouble(numberOne) + covertToDouble(numberTwo)));

        return result;
    }


    public static Double covertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
        // BR 10,25 US 10.25
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public static boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    }


