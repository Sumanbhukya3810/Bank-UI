package com.cg.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.Dto.Deposit;
import com.cg.Dto.Transfer;
import com.cg.Dto.Withdraw;
import com.cg.Entity.Customer;
import com.cg.Entity.Transaction;
import com.cg.Service.AccountService;
import com.cg.Service.TransactionService;
import com.cg.exception.AccountException;
import com.cg.exception.TransactionException;

@RestController
@RequestMapping("/Operation")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionService transactionService;

	@RequestMapping(value = "/Deposit", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView DepositPage() {
		ModelAndView modelAndView = new ModelAndView("DepositView");
		modelAndView.addObject("Deposit", new Deposit());
		return modelAndView;
	}

	@RequestMapping(value = "/Withdraw", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView WithdrawPage() {
		ModelAndView modelAndView = new ModelAndView("WithdrawView");
		modelAndView.addObject("Withdraw", new Withdraw());
		return modelAndView;
	}

	@RequestMapping(value = "/Withdraw1", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView withdraw(@ModelAttribute("Withdraw") @Validated Withdraw Withdraw, BindingResult bindingResult,
			Model model) throws AccountException, TransactionException {
		String resultMessage = accountService.withdraw(Withdraw.getAccountId(), Withdraw.getWithdrawAmount());
		double newBalance = Double.parseDouble(resultMessage.split(":")[1].trim());
		model.addAttribute("resultMessage", resultMessage);
		model.addAttribute("newBalance", Double.toString(newBalance));
		Transaction transaction = new Transaction();
		transaction.setTransactionDate(LocalDate.now());
		transaction.setDescription("Debit");
		transaction.setTransactionAmount(Withdraw.getWithdrawAmount());
		transaction.setTransactionType("Debit");
		transactionService.createTransaction(transaction, Withdraw.getAccountId());

		return new ModelAndView("WithdrawForm", model.asMap());

	}

	@RequestMapping(value = "/Transfer", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView showTransferForm() {
		ModelAndView modelAndView = new ModelAndView("TransferView");
		modelAndView.addObject("Transfer", new Transfer());
		return modelAndView;
	}

	@RequestMapping(value = "/Transfer1", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView transfer(@ModelAttribute("Transfer") @Validated Transfer transfer, BindingResult bindingResult,
			Model model) throws AccountException {
		String resultMessage = accountService.transfer(transfer.getFromAccountNumber(), transfer.getToAccountNumber(),
				transfer.getTransferAmount());
		double newBalanceFrom = Double.parseDouble(resultMessage.split(":")[1].trim().split("\\.")[0]);
		double newBalanceTo = Double.parseDouble(resultMessage.split(":")[2].trim());

		model.addAttribute("resultMessage", resultMessage);
		model.addAttribute("newBalanceFrom", Double.toString(newBalanceFrom));
		model.addAttribute("newBalanceTo", Double.toString(newBalanceTo));

		return new ModelAndView("TransferForm", model.asMap());
	}

	@RequestMapping(value = "/Deposit1", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView deposit(@ModelAttribute("Deposit") @Validated Deposit deposit, BindingResult bindingResult,
			Model model) throws AccountException, TransactionException {

		String resultMessage = accountService.deposit(deposit.getAccountId(), deposit.getDepositAmount());
		double newBalance = Double.parseDouble(resultMessage.split(":")[1].trim());

		model.addAttribute("resultMessage", resultMessage);
		model.addAttribute("newBalance", Double.toString(newBalance));

		Transaction transaction = new Transaction();
		transaction.setTransactionDate(LocalDate.now());
		transaction.setDescription("deposit");
		transaction.setTransactionAmount(deposit.getDepositAmount());
		transaction.setTransactionType("Deposit");
		transactionService.createTransaction(transaction, deposit.getAccountId());

		return new ModelAndView("DepositForm", model.asMap());
	}

	@RequestMapping(value = "/createTransaction", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView createTransaction(@ModelAttribute("TransactionObj") @Validated Transaction transaction,
			BindingResult error, @RequestParam("accountId") int accountId) throws TransactionException {

		if (transactionService == null) {
			throw new TransactionException("Transaction service is not available");
		}

		transactionService.createTransaction(transaction, accountId);

		return new ModelAndView("CreateTransaction", "message", "created Transaction");
	}

}