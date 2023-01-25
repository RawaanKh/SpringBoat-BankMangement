package com.example.bankmang.Controller;

import com.example.bankmang.Pojo.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/customer")
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
    public int Withdraw(@PathVariable int index,@PathVariable int withdraw, @RequestBody Customers customer){
       int UpdatedBalance;
        if (customer.getBalance()<withdraw){
           System.out.println("Rejected! NOT ENOUGH AMMOUNT OF MONEY ");
            return balance;
                            }
        else
        UpdatedBalance=customer.getBalance()-withdraw;
        customer.setBalance(UpdatedBalance);
        customers.set(index,customer);
        return UpdatedBalance;
    }
    @PutMapping("/deposit/{id}/{amount}")
    public String Deposit(@PathVariable int id,@PathVariable int amount) {
        for (Customer c : customers) {
            if (c.getId()==id)
                c.setBalance(c.getBalance() + amount);
            return "Money Added!";
        }
                return "Enter correct ID";
        }
    @GetMapping("/remove/{index}")
    public String Remove(@PathVariable int index){
        customers.remove(index);
        return "Customer Removed!";
    }
}
