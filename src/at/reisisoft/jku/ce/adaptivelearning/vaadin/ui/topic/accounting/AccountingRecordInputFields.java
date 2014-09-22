package at.reisisoft.jku.ce.adaptivelearning.vaadin.ui.topic.accounting;

import at.reisisoft.jku.ce.adaptivelearning.topic.accounting.AccountRecordData;
import at.reisisoft.jku.ce.adaptivelearning.topic.accounting.AccountingDataProvider;
import at.reisisoft.jku.ce.adaptivelearning.vaadin.input.AccountNumberInputField;
import at.reisisoft.jku.ce.adaptivelearning.vaadin.input.CurrencyTextBox;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;

public class AccountingRecordInputFields extends GridLayout {

	private static final long serialVersionUID = 8543708812084425332L;
	private final AccountNumberInputField accountNumberInputField;
	private final ComboBox ddAccountNames;
	private final CurrencyTextBox currencyTextBox;

	public AccountingRecordInputFields() {
		super(3, 1);
		setSpacing(true);
		// Add AccountNumber
		accountNumberInputField = new AccountNumberInputField();
		accountNumberInputField.setCaption("First 2 digits:");
		accountNumberInputField.setWidth("3em");
		addComponent(accountNumberInputField, 0, 0);
		// Add DD AccountNames
		ddAccountNames = new ComboBox("Account name:");
		ddAccountNames.addItems((Object[]) AccountingDataProvider.getInstance()
				.getAllAccountNames());
		ddAccountNames.setWidth("15em");
		addComponent(ddAccountNames, 1, 0);
		// Add Curreny field
		currencyTextBox = new CurrencyTextBox();
		currencyTextBox.setCaption("Figure (€):");
		currencyTextBox.setWidth("8em");
		addComponent(currencyTextBox, 2, 0);
	}

	public AccountRecordData getAccountRecordData() {
		return new AccountRecordData((String) ddAccountNames.getValue(),
				currencyTextBox.getNumericValue(),
				accountNumberInputField.getAccountNumber());
	}
}
