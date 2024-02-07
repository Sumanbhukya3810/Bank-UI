package com.cg.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.Dto.User;
import com.cg.Entity.Account;
import com.cg.Entity.Customer;
import com.cg.Service.AccountService;
import com.cg.Service.CustomerService;
import com.cg.exception.AccountException;
import com.cg.exception.CustomerException;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;
	Customer customer = new Customer();

	@GetMapping(value = "/showAdminLoginPage")
	public ModelAndView dispLoginPage(@ModelAttribute("loginObj") User user) {
		ModelAndView loginPageView = new ModelAndView("Login", "fname", "Bhagi");
		return loginPageView;
	}
	@GetMapping("/home")
	public String home() {
		return "This is Home Page";
	}

	@RequestMapping("/showCustomerLoginPage")
	public ModelAndView showLoginPage() {
		ModelAndView modelAndView = new ModelAndView("LoginCustomer");
		modelAndView.addObject("customer", new Customer());
		return modelAndView;
	}

	@RequestMapping(value = "/ValidateCustomer", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(@ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("LoginCustomer");
			modelAndView.addObject("error", "Invalid username or password");
		} else {
			Customer authenticatedUser = customerService.authenticateUser(customer.getUserName(),
					customer.getPassword());

			if (authenticatedUser != null) {
				modelAndView.setViewName("CustomerOperations"); // replace with your actual dashboard view name
				modelAndView.addObject("welcomeMessage", "Welcome, " + authenticatedUser.getFirstName() + "!");
			} else {
				modelAndView.setViewName("LoginCustomer");
				modelAndView.addObject("error", "Invalid username or password");
			}
		}

		return modelAndView;
	}

	@PostMapping(value = "/validateAdmin")
	public ModelAndView validateCustomer(@ModelAttribute("UserObj") User user, @Validated User ur, BindingResult error)
			throws CustomerException// throws MovieCatlogException
	{
		if (error.hasErrors()) {
			return new ModelAndView("Login");
		}
		if (!(user.getUsername().equals("admin") && user.getPassword().equals("secret"))) {
			return new ModelAndView("Login", "msg", "Incorrect Password");

		}

		String st = "Login Succesfull";
		return new ModelAndView("LoginSuccessful").addObject("message", st).addObject("showCreateCustomerButton", true);
	}

	@RequestMapping(value = "/createCustomer", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView createCustomer(@ModelAttribute("customerObj") @Validated Customer customer, BindingResult error)
			throws CustomerException {


		customerService.createCustomer(customer);

		String st = "created customer Succesfull";
		return new ModelAndView("CreateCustomer").addObject("message", st).addObject("showCreateAccountButton", true);
	}

	@RequestMapping(value = "/createAccount", method = { RequestMethod.GET, RequestMethod.POST })
	// @PostMapping(value = "/createCustomer")
	public ModelAndView createAccount(@ModelAttribute("AccountObj") @Validated Account account, BindingResult error)
			throws AccountException {

		// Handle validation errors

		accountService.createAccount(account);

		return new ModelAndView("CreateAccount", "message", "Account created successfully");

	}

}
