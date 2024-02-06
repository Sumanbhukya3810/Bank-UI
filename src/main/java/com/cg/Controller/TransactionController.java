package com.cg.Controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.Dto.Deposit;
import com.cg.Dto.Trasaction;
import com.cg.Entity.Transaction;
import com.cg.Service.TransactionService;
import com.cg.exception.TransactionException;

@RestController
@RequestMapping("/Transfer")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;

//	@RequestMapping(value = "/createTransaction", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView createTransaction(@ModelAttribute("TransactionObj") @Validated Transaction transaction, BindingResult error,@RequestParam("accountId") int accountId) 
//	        throws TransactionException {
//
//	    if (transactionService == null) {
//	        throw new TransactionException("Transaction service is not available");
//	    }
//
//	    transactionService.createTransaction(transaction, accountId);
//
//	    return new ModelAndView("CreateTransaction", "message", "created Transaction");
//	}
	@RequestMapping(value = "/Transaction", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView TransactionPage() {
		ModelAndView modelAndView = new ModelAndView("TransactionView");
		modelAndView.addObject("Trasaction", new Trasaction());
		return modelAndView;
	}
	
	@RequestMapping(value = "/viewTransactions", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView viewTransactions(@RequestParam("accountId") int accountId) throws TransactionException {
        ModelAndView modelAndView = new ModelAndView();

        HashSet<Transaction> transactions = transactionService.getTransactionById(accountId);

        modelAndView.addObject("transactions", transactions);

        modelAndView.setViewName("ViewTransactions"); 

        return modelAndView;
	}
}
