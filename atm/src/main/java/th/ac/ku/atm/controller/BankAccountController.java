package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;


@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {

    private BankAccountService bankAccountService;

    //responsible for handle user request
    //    step1: update model for template
    //    step2: chose HTML template

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    //handle user request
    @GetMapping
    public String getBankAccountPage(Model model) {

        //    step1: update model for template
        model.addAttribute("allBankAccounts", bankAccountService.getBankAccount());

        //    step2: chose HTML template
        return "bankaccount";
    }
    @PostMapping
    public String registerBankAccount(@ModelAttribute BankAccount bankAccount, Model model) {
        bankAccountService.createBankAccount(bankAccount);
        model.addAttribute("allBankAccounts", bankAccountService.getBankAccount());
        return "redirect:bankaccount"; //การใช้ redirect เปลี่ยนจาก method post -> get เพื่อใช้งาน getBankAccount เพื่อแสดงข้อมูล
    }
}



