package controllers;

import daos.core.CashierClosuresDao;
import entities.core.CashierClosures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.GregorianCalendar;

@Controller
public class CashierClosuresController {

	@Autowired
	private CashierClosuresDao cashierClosuresDao;

	public CashierClosures createCashierClosures() {

		CashierClosures cashierClosures = new CashierClosures();

		cashierClosures.setAmount(getLastCashierClosureAmount());
		cashierClosures.setOpeningDate(new GregorianCalendar());
		cashierClosuresDao.saveAndFlush(cashierClosures);

		return cashierClosures;
	}

	private double getLastCashierClosureAmount() {
		return getLastCashierClosure() != null ? getLastCashierClosure().getAmount() : 0;
	}

	public boolean isLastCashierClosuresClosed() {
		if(this.getLastCashierClosure() == null)
			return true;
		
		return getLastCashierClosure().getClosureDate() != null;
	}

	public CashierClosures getLastCashierClosure() throws NullPointerException {
		return cashierClosuresDao.findFirstByOrderByOpeningDateDesc();
	}

	public CashierClosures closeCashierRequest(double amount, String comment) {
		CashierClosures lastCashierClosure = this.getLastCashierClosure();
		lastCashierClosure.setAmount(amount);
		lastCashierClosure.setComment(comment);
		lastCashierClosure.setClosureDate(new GregorianCalendar());

		cashierClosuresDao.saveAndFlush(lastCashierClosure);

		return lastCashierClosure;
	}

	public CashierClosures depositCashierRequest(double amount) {
		CashierClosures lastCashierClosures = this.getLastCashierClosure();
		lastCashierClosures.setAmount(getLastCashierClosureAmount() + amount);
		cashierClosuresDao.saveAndFlush(lastCashierClosures);

		return lastCashierClosures;
	}

	public CashierClosures withDrawCashierRequest(double amount) {
		CashierClosures lastCashierClosures = this.getLastCashierClosure();
		lastCashierClosures.setAmount(getLastCashierClosureAmount() - amount);
		cashierClosuresDao.saveAndFlush(lastCashierClosures);

		return lastCashierClosures;
	}
}
