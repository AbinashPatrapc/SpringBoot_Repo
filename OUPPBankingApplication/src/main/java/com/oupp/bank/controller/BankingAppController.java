package com.oupp.bank.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.oupp.bank.entity.BankAccount;
import com.oupp.bank.entity.User;
import com.oupp.bank.repo.BankAccountRepo;
import com.oupp.bank.repo.UserRepo;
import com.oupp.bank.request.UserRequest;

@Controller
public class BankingAppController {

	@Autowired
	BankAccountRepo brepo;
	@Autowired
	UserRepo urepo;

	@GetMapping("/")
	public String showHome() {
		return "login";
	}

	@PostMapping("/login")
	public String loginPage(@ModelAttribute("request") UserRequest request) {
		String email = request.getEmail();
		String password = request.getPassword();
		Long count = urepo.countByEmailAndPassword(email, password);
		if (count == 0) {
			return "errorAccNotFound";
		} else {
			return "mainPage";
		}
	}

	@GetMapping("/add")
	public String addCustomerForm(@ModelAttribute("request") UserRequest request) {
		return "addAccount";
	}

	@PostMapping("/add")
	public String saveCustomer(@ModelAttribute("request") UserRequest request) {
		BankAccount account = new BankAccount();
		account.setAccountType(request.getAccountType());
		account.setBalance(request.getBalance());
		account = brepo.save(account);
		User user1 = new User(request);
		user1.setAccount(account);
		urepo.save(user1);
		return "confirmation";
	}

//	@GetMapping("/view")
//	public String viewAccounts(Map<String, Object> map ,UserRequest request) {
//		List<User> list = urepo.findAll();
//		map.put("view", list);
//		return "report";
//	}

	@GetMapping("/deposit")
	public String showDepositForm(@ModelAttribute("request") UserRequest request) {
		return "depositAmount";
	}

	@PostMapping("/deposit") // http://locahost:9090/credit/2335626/1000
	public String moneyCredit(@ModelAttribute("req") UserRequest req) {

		Integer accountNumber = req.getAccountNumber();
		Integer amount = req.getAmount();
		// Fetch the user based on the provided accountNumber
		Optional<User> userOptional = urepo.findByAccount_AccountNumber(accountNumber);

		if (userOptional.isPresent()) {
			User user = userOptional.get();// user object(Bank account object)
			BankAccount account = user.getAccount();// bank account object

			if (account != null) {
				// Update the account balance by adding the credited amount
				account.setBalance(account.getBalance() + amount);
				brepo.save(account);

				return "confirmation";
			} else {
				return "errorAccNotFound";
			}
		} else {
			return "errorAccNotFound";
		}
	}

	@GetMapping("/withdraw")
	public String showWithdrawForm(@ModelAttribute("request") UserRequest request) {
		return "withdrawAmount";
	}

	@PostMapping("/withdraw")
	public String moneyDebit(@ModelAttribute("req") UserRequest req) {
		Integer accountNumber = req.getAccountNumber();
		Integer amount = req.getAmount();
		// Fetch the user based on the provided accountNumber
		Optional<User> userOptional = urepo.findByAccount_AccountNumber(accountNumber);

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			BankAccount account = user.getAccount();

			if (account.getBalance() >= amount) {
				// Update the account balance by deducting from the amount
				account.setBalance(account.getBalance() - amount);
				brepo.save(account);

				return "confirmation";
			} else {
				return "errorInsufficientFund";
			}
		} else {
			return "errorAccNotFound";
		}
	}

	@GetMapping("/transfer")
	public String showTransferForm(@ModelAttribute("request") UserRequest request) {
		return "transferAmount";
	}

	@PostMapping("/transfer")
	public String transferFunds(@ModelAttribute("req") UserRequest req) {

		Integer sourceAccountNumber = req.getSourceAccountNum();
		Integer destinationAccountNumber = req.getDestinationAccountNum();
		Integer amount = req.getAmount();
		// Find the source user based on the source account number
		Optional<User> sourceUserOptional = urepo.findByAccount_AccountNumber(sourceAccountNumber);

		// Find the destination user based on the destination account number
		Optional<User> destinationUserOptional = urepo.findByAccount_AccountNumber(destinationAccountNumber);

		if (sourceUserOptional.isPresent() && destinationUserOptional.isPresent()) {
			User sourceUser = sourceUserOptional.get();
			User destinationUser = destinationUserOptional.get();

			BankAccount sourceAccount = sourceUser.getAccount();
			BankAccount destinationAccount = destinationUser.getAccount();

			if (sourceAccount != null && destinationAccount != null) {
				// Check if the source account has sufficient balance
				if (sourceAccount.getBalance() >= amount) {
					// Perform the transfer
					sourceAccount.setBalance(sourceAccount.getBalance() - amount);
					destinationAccount.setBalance(destinationAccount.getBalance() + amount);
					// Save the changes
					urepo.save(sourceUser);
					urepo.save(destinationUser);
					return "confirmation";
				} else {
					return "errorInsufficientFund";
				}
			} else {
				return "errorAccNotFound";
			}
		} else {
			return "errorAccNotFound";
		}
	}

	@GetMapping("/accountDetails")
	public String findAccountForm(@ModelAttribute("request") UserRequest request) {
		return "findAcc";
	}

	@PostMapping("/accountDetails")
	public String getAccountDetails(Map<String, Object> map, UserRequest request) {
		Integer accountNumber = request.getAccountNumber();
		Optional<BankAccount> accountOptional = brepo.findByAccountNumber(accountNumber);
		if (accountOptional.isPresent()) {
			BankAccount account = accountOptional.get();
			map.put("AccList", account);
			return "report";
		} else {
			return "errorAccNotFound";
		}
	}
}
