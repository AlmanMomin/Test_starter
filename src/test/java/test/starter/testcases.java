package test.starter;

    import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;
    import java.util.regex.Pattern;

public class testcases{
        public static void main(String[] args) {
            try (Playwright playwright = Playwright.create()) {
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));
                BrowserContext context = browser.newContext();
                Page page = context.newPage();
                page.navigate("https://minimals.cc/");
                page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
                page.getByLabel("Email address").click();
                page.getByLabel("Email address").fill("demo@minimals.cc");
                page.getByLabel("Password").click();
                page.getByLabel("Password").fill("demo1234");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("user")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("account")).click();
                page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Billing")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Jayvion Simon")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Deja Brady 18605 Thompson")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("**** **** ****")).click();
                page.getByRole(AriaRole.DIALOG).locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^\\*\\*\\*\\* \\*\\*\\*\\* \\*\\*\\*\\* 1234$"))).locator("div").click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Upgrade Plan")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("order")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("list")).nth(1).click();
                page.getByPlaceholder("Search customer or order").click();
                page.getByPlaceholder("Search customer or order").fill("cor");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("job")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("list")).nth(1).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Filters")).click();
                page.getByLabel("On Demand").check();
                page.locator(".MuiBackdrop-root").click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("chat")).click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Deja Brady Deja Brady You:")).click();
                page.getByPlaceholder("Type a message").click();
                page.getByPlaceholder("Type a message").fill("hi.how are you");
                page.getByPlaceholder("Type a message").press("Enter");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("File Manager")).click();
                page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("Name sorted ascending Size")).getByRole(AriaRole.CHECKBOX).check();
                page.getByLabel("Delete").click();
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Delete")).click();
            }
        }
    }
