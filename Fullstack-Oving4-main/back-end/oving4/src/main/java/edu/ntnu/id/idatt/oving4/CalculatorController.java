package edu.ntnu.id.idatt.oving4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class CalculatorController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) {
      LOGGER.info("Adding {} and {}", a, b);
      return calculatorService.add(a, b);
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a, @RequestParam double b) {
      LOGGER.info("Subtracting {} from {}", b, a);
      return calculatorService.subtract(a, b);
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
      LOGGER.info("Multiplying {} and {}", a, b);
      return calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double a, @RequestParam double b) {
      LOGGER.info("Dividing {} by {}", a, b);
      return calculatorService.divide(a, b);
    }
}