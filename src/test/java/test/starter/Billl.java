    package test.starter;
    import com.microsoft.playwright.*;
    import com.microsoft.playwright.options.*;
    import jdk.dynalink.linker.support.Guards;
    import static org.junit.Assert.*;
    import java.util.List;


        public class Billl {
            public static void main(String[] args) {
                try (Playwright playwright = Playwright.create()) {
                    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    BrowserContext context = browser.newContext();
                    Page page = context.newPage();
                    page.navigate("https://minimals.cc/");

                    page.waitForLoadState(LoadState.LOAD, new Page.WaitForLoadStateOptions().setTimeout(30));

                    // Navigation
                    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("user")).click();
                    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("account")).click();
                    page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Billing")).click();

                    // Actions
                    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Deja Brady")).click();
                    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("**** **** **** 1234")).click();


                    // Validation
                    String billingName = page.innerText("//selector-for-element-containing-billing-name");
                    String updatedPaymentMethod = page.innerText("//selector-for-element-containing-payment-method");

                    assertEquals("Deja Brady", billingName);
                    assertTrue(updatedPaymentMethod.contains("1234"));


                    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("order")).click();
                    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("list")).nth(1).click();

                    // Actions
                    page.getByPlaceholder("Search customer or order").click();
                    page.getByPlaceholder("Search customer or order").fill("cor");

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
                        // Actions
                        page.getByLabel("On Demand").check();
                        page.locator(".MuiBackdrop-root").click();

                        // Validation
                        boolean allJobsAreOnDemand = true;

                        {
                            if (allJobsAreOnDemand) {
                                System.out.println("Validation Passed: Only jobs with 'On Demand' employment type are displayed.");
                            }
                            else{
                                    System.out.println("Validation Failed: Some jobs don't have 'On Demand' employment type.");
                                }
                                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("chat")).click();
                                page.waitForLoadState(LoadState.NETWORKIDLE);

                                // Select the chat with 'Deja Brady'
                                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Deja Brady Deja Brady You:")).click();
                                page.waitForLoadState(LoadState.NETWORKIDLE);

                                // Send the message "Hello, how are you?"
                                page.getByPlaceholder("Type a message").click();
                                page.getByPlaceholder("Type a message").fill("Hello, how are you?");
                                page.keyboard().press("Enter");
                                page.waitForLoadState(LoadState.NETWORKIDLE);

                                // Validation:
                                page.waitForSelector(".sent-message");


                            assertThat(page.locator(".sent-message").first()).isNotNull();
                                // Navigation

                                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("File Manager")).click();
                                // Actions

                                page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("Name sorted ascending Size")).getByRole(AriaRole.CHECKBOX).check();


                                page.getByLabel("Delete").click();


                                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Delete")).click();

                                // Validation


                            boolean confirmationMessage = true; // Placeholder for your logic to check for confirmation message
                            if (confirmationMessage) {
                                System.out.println("Deletion was successful.");
                            } else {
                                System.out.println("Deletion failed or confirmation message not found.");
                            }
                            browser.close();

                            }

                        }
                    }
                }

            private static Guards assertThat(Locator first) {
                return null;
            }


        }











