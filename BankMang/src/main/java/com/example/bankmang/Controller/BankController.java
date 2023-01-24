package com.example.bankmang.Controller;

import com.example.bankmang.Pojo.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BankController {
    ArrayList<Customers> customers=new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Customers> getCustomers(){
        return customers;
    }
    @PostMapping("/add")
    public String AddCustomer(@RequestBody Customers customer){
        customers.add(customer);
        return "Customer Added!";
    }
    @PutMapping("/update/{index}")
    public String Update(@PathVariable int index,Customers customer){
        customers.set(index,customer);
        return "Updated!";
    }
    @PutMapping("/withdraw/{index}")
    public int Withdraw(@PathVariable int index,@RequestBody Customers customer){
        int UpdatedBalance;
        int withdraw=1500;
        if (customer.getBalance()<=withdraw)
            System.out.println("Rejected! NOT ENOUGH AMMOUNT OF MONEY ");
        UpdatedBalance=customer.getBalance()-withdraw;
        customer.setBalance(UpdatedBalance);
        customers.set(index,customer);
        return UpdatedBalance;
    }
    @PutMapping("/deposit/{index}")
    public int Deposit(@PathVariable int index,@RequestBody Customers customer){
        int addMoney=1000;
        addMoney+=customer.getBalance();
        customer.setBalance(addMoney);
        customers.set(index,customer);
        return addMoney;
    }
    @GetMapping("/remove/{index}")
    public String Remove(@PathVariable int index){
        customers.remove(index);
        return "Customer Removed!";
    }
}
