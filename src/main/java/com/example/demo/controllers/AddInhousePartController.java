package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.service.InhousePartService;
import com.example.demo.service.InhousePartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddInhousePartController{
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddInPart")
    public String showFormAddInhousePart(Model theModel){
        InhousePart inhousepart=new InhousePart();
        theModel.addAttribute("inhousepart",inhousepart);
        return "InhousePartForm";
    }

    @PostMapping("/showFormAddInPart")
    public String submitForm(@Valid @ModelAttribute("inhousepart") InhousePart part, BindingResult theBindingResult, Model theModel){

        theModel.addAttribute("inhousepart",part);
        if(theBindingResult.hasErrors()){
            return "InhousePartForm";
        }
        else{
        InhousePartService repo = context.getBean(InhousePartServiceImpl.class);
        InhousePart ip = repo.findById((int)part.getId());
        if (ip!=null) {
            part.setProducts(ip.getProducts());
        }

        // Task from Part G - this is no longer needed since it is preempted/handled by the validation implemented in Part H. Leaving code commented for evaluators inspection
        // min/max violation check
        // Not sure what to do other than return the outsourced part form and log. Task G only specifies: "Modify the code to enforce that the inventory is between or at the minimum and maximum value."
//        if (part.getInv() < part.getMin() || part.getInv() > part.getMax()) {
//            System.out.println("******MIN/MAX CONSTRAINT VIOLATED******");
//            return "minMaxViolation";
//        }

        repo.save(part);

        return "confirmationaddpart";}
    }

}
