package com.github.automatedowl.examples;

import com.github.automatedowl.examples.models.Customer;
import com.github.automatedowl.examples.models.CustomerFactory;
import com.github.automatedowl.examples.models.Order;
import com.github.automatedowl.examples.models.OrderItem;
import com.github.automatedowl.examples.pages.CatalogPage;
import com.github.automatedowl.examples.pages.HomePage;
import com.github.automatedowl.examples.pages.OrderProductDlg;
import com.github.automatedowl.examples.pages.checkout.CheckOutWizardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebHostTest extends WebHostTestCase {

    @Test
    public void automationPracticeTest() throws InterruptedException {

        // Navigate to URL.
        getDriver().get("http://automationpractice.com");

        //Go to 'Women' and select 'Summer Dresses' Hoverover Women and then select 'Summer Dresses'
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateViaMenu("Women -> Summer Dresses");



        //In GridView, mover over in Printed Chiffon Dress' and click 'Quick view'
        //In popupDialog select size M and click "Add to Cart" and click "Continue Shopping"
        CatalogPage catalogPage = new CatalogPage(getDriver());

        OrderItem orderItem = new OrderItem();
        orderItem.setDescription("Printed Chiffon Dress");
        orderItem.setSize("M");
        orderItem.setQuantity(1);

        Order originalOrder = catalogPage.orderProductViaQuickView(orderItem);


        //Go Cart and click Checkout
        homePage.startCheckOutViaHoverOver();

        // Chekout
        //  - Summary Tab
        //      + Proceed to checkout
        //  - Sign in Tab
        //      + Register User
        //
        //  - Address Tab
        //      + Proceed to checkout
        //  - Shipping Tab
        //      + Check of "I agree with terms"
        //      + Proceed to checkout
        //  - Payment Tab
        //      + Confirm Order
        //      + Click Pay by bank wire

        CheckOutWizardPage checkOutWizardPage = new CheckOutWizardPage(getDriver());

        Assert.assertEquals(checkOutWizardPage.getActiveTabName(), "01. Summary");
        checkOutWizardPage.getSummaryTab().clickProceedToCheckoutBtn();

        Assert.assertEquals(checkOutWizardPage.getActiveTabName(), "02. Sign in");
        Customer customer = CustomerFactory.getRandomCustomer(); // use customerFactory
        checkOutWizardPage.registerNewCustomer(customer);

        Assert.assertEquals(checkOutWizardPage.getActiveTabName(), "03. Address");
        checkOutWizardPage.getAddressTab().clickProceedToCheckoutBtn();


        Assert.assertEquals(checkOutWizardPage.getActiveTabName(), "04. Shipping");
        checkOutWizardPage.agreeWithTermsOfService(true);
        checkOutWizardPage.getShippingTab().clickProceedToCheckoutBtn();

        Assert.assertEquals(checkOutWizardPage.getActiveTabName(), "05. Payment");
        Order parsedOrder = checkOutWizardPage.getPaymentTab().getOrderDetails();

        Assert.assertEquals(parsedOrder.getOrderItems().size(),1);
        Assert.assertEquals(parsedOrder.getOrderItems().size(),originalOrder.getOrderItems().size());

        Assert.assertEquals(
                parsedOrder.getOrderItems().get(0).getPrice(),
                originalOrder.getOrderItems().get(0).getPrice()
        );

        Assert.assertEquals(
                parsedOrder.getOrderItems().get(0).getDescription(),
                originalOrder.getOrderItems().get(0).getDescription()
        );
        Assert.assertEquals(
                parsedOrder.getOrderItems().get(0).getSize(),
                originalOrder.getOrderItems().get(0).getSize()
        );


        // Wait before closing browser.
        waitBeforeClosingBrowser();
    }
}





//Navigate to URL    http://automationpractice.com
//Go to 'Women' and select 'Summer Dresses' Hoverover Women and then select 'Summer Dresses'
//In GridView, mover over in Printed Chiffon Dress' and click 'Quick view'
//In popupDialog select size M and click "Add to Cart" and click "Continue Shopping"
//Go Cart and click Checkout
// Chekout
//  - Summary Tab
//      + Proceed to checkout
//  - Sign in Tab
//      + Register User
//
//  - Address Tab
//      + Proceed to checkout
//  - Shipping Tab
//      + Check of "I agree with terms"
//      + Proceed to checkout
//  - Payment Tab
//      + Confirm Order
//      + Click Pay by bank wire