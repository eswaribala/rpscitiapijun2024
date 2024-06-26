package com.siemens.customerapisaml.controllers;
import com.siemens.customerapisaml.models.Customer;
import com.siemens.customerapisaml.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerFormController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
    public String home(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model) {
        model.addAttribute("name", principal.getName());
        model.addAttribute("emailAddress", principal.getFirstAttribute("email"));
        model.addAttribute("userAttributes", principal.getAttributes());
        return "homesecure";
    }


    @GetMapping("/home")
    public String load(Model model){
        model.addAttribute("customer", new Customer());
        return "home.html";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer, Model model){
        System.out.println(customer.getName().getFirstName());
        Customer customerObj=null;
        if(customer.getName().getFirstName()!=null){
            customerObj=this.customerService.addCustomer(customer);
            model.addAttribute("customerResponse",customerObj);
            return "showcustomer.html";
        }else{
            return "redirect:/home";
        }


    }
    @GetMapping("/showall")
    public String showAllCustomers(Model model){
       model.addAttribute("customers", this.customerService.fetchAllCustomers());
       return "viewcustomers.html";

    }


}
