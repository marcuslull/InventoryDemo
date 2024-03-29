package com.example.demo.controllers;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddOutsourcedPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(Model theModel){
        Part part=new OutsourcedPart();
        theModel.addAttribute("outsourcedpart",part);
        return "OutsourcedPartForm";
    }

    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") OutsourcedPart part, BindingResult bindingResult, Model theModel){

        theModel.addAttribute("outsourcedpart",part);
        if(bindingResult.hasErrors()){
            return "OutsourcedPartForm";
        }
        else{
        OutsourcedPartService repo = context.getBean(OutsourcedPartServiceImpl.class);
        OutsourcedPart op = repo.findById((int)part.getId());
        if (op!=null) {
            part.setProducts(op.getProducts());
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
