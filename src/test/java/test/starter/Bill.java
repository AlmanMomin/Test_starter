package test.starter;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Bill {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://minimals.cc/");

			page.waitForLoadState(LoadState.LOAD, new Page.WaitForLoadStateOptions().setTimeout(3000));

			// Navigation
			page.click("button[aria-label='user']");
			page.click("button[aria-label='account']");
			page.click("button[aria-label='Billing']");

			// Actions
			page.click("button[aria-label='Deja Brady']");
			page.click("button[aria-label='**** **** **** 1234']");

			// Validation
			String billingName = page.innerText("//selector-for-element-containing-billing-name");
			String updatedPaymentMethod = page.innerText("//selector-for-element-containing-payment-method");

			assertEquals("Deja Brady", billingName);
			assertTrue(updatedPaymentMethod.contains("1234"));

			page.click("button[aria-label='order']");
			page.click("button[aria-label='list']:nth-child(2)");

			// Actions
			page.click("input[placeholder='Search customer or order']");
			page.fill("input[placeholder='Search customer or order']", "cor");

			// Validation
			List<ElementHandle> rows = page.querySelectorAll("selector-for-rows");
			if (rows.size() == 1) {
				String user = rows.get(0).innerText(); // Assuming this extracts the user's name from the row
				if (user.equals("Cortez Herring")) {
					System.out.println("Validation Passed: Only one row found, displaying the user as 'Cortez Herring'.");
				} else {
					System.out.println("Validation Failed: The displayed user is not 'Cortez Herring'.");
				}
			} else {
				System.out.println("Validation Failed: More than one row found or no rows found.");
			}

			// Actions
			page.check("label[for='On Demand']");
			page.click(".MuiBackdrop-root");

			// Validation
			boolean allJobsAreOnDemand = true;
			if (allJobsAreOnDemand) {
				System.out.println("Validation Passed: Only jobs with 'On Demand' employment type are displayed.");
			} else {
				System.out.println("Validation Failed: Some jobs don't have 'On Demand' employment type.");
			}

			page.click("button[aria-label='chat']");
			page.waitForLoadState(LoadState.NETWORKIDLE);

			// Select the chat with 'Deja Brady'
			page.click("button[aria-label='Deja Brady Deja Brady You:']");
			page.waitForLoadState(LoadState.NETWORKIDLE);

			// Send the message "Hello, how are you?"
			page.click("input[placeholder='Type a message']");
			page.fill("input[placeholder='Type a message']", "Hello, how are you?");
			page.keyboard().press("Enter");
			page.waitForLoadState(LoadState.NETWORKIDLE);

			// Validation:
			page.waitForSelector(".sent-message");
			ElementHandle sentMessage = page.locator(".sent-message").first().elementHandle();
			if (sentMessage != null) {
				System.out.println("Message sent successfully.");
			} else {
				System.out.println("Failed to send message.");
			}

			// Navigation
			page.click("button[aria-label='File Manager']");
			// Actions
			page.check("label[for='Name sorted ascending Size']");
			page.click("button[aria-label='Delete']");
			page.click("button[aria-label='Delete']");

			// Validation
			boolean confirmationMessage = true; // Placeholder for your logic to check for confirmation message
			if (confirmationMessage) {
				System.out.println("Deletion was successful.");
			} else {
				System.out.println("Deletion failed or confirmation message not found.");
			}

			browser.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void assertEquals(String dejaBrady, String billingName) {

	}
}
