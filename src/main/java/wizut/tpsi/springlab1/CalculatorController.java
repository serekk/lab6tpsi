package wizut.tpsi.springlab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {

    @RequestMapping("/calc")
    public String calc(Model model, CalculatorForm calculatorForm){

        model.addAttribute("x", calculatorForm.getX());
        model.addAttribute("y", calculatorForm.getY());
        Integer wynik;

        switch (calculatorForm.getOperator()){
            case "add":
                wynik = calculatorForm.getX() + calculatorForm.getY();
                model.addAttribute("operator", "+");
                break;
            case "subtract":
                wynik = calculatorForm.getX() - calculatorForm.getY();
                model.addAttribute("operator", "-");
                break;
            case "multiply":
                wynik = calculatorForm.getX() * calculatorForm.getY();
                model.addAttribute("operator", "*");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculatorForm);
        }

        model.addAttribute("wynik", wynik);
        return "calc";
    }

}
