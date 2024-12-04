package br.com.erudio.services;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.MathOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;
import static br.com.erudio.math.MathConverter.covertToDouble;
import static br.com.erudio.math.MathConverter.isNumeric;

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
        return MathOperation.sum( covertToDouble(numberOne),covertToDouble(numberTwo) );
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(
            @PathVariable (value = "numberOne") String numberOne,
            @PathVariable (value = "numberTwo") String numberTwo
    ) throws Exception {
        if  (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return MathOperation.multiplication( covertToDouble(numberOne),covertToDouble(numberTwo) );
    }

    @RequestMapping(value = "/Division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(
            @PathVariable (value = "numberOne") String numberOne,
            @PathVariable (value = "numberTwo") String numberTwo
    ) throws Exception {
        if  (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return MathOperation.division( covertToDouble(numberOne),covertToDouble(numberTwo) );
    }

    @RequestMapping(value = "/Media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(
            @PathVariable (value = "numberOne") String numberOne,
            @PathVariable (value = "numberTwo") String numberTwo
    ) throws Exception {
        if  (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return MathOperation.mean(covertToDouble(numberOne),covertToDouble(numberTwo));
    }

    @RequestMapping(value = "/squareRoot/{numberOne}", method = RequestMethod.GET)
    public Double squareRoot(
            @PathVariable (value = "numberOne") String numberOne
    ) throws Exception {
        if  (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return MathOperation.squareRoot(covertToDouble(numberOne));
    }

    }


