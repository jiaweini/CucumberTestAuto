https://www.guru99.com/upload-download-file-selenium-webdriver.html

Story: 
As an Email user,
I would like to be able to send an email with an image attached
so the receiver could receive the image


Normal Flow:
Sending email with image attached to an address

    Given I am logged in on a new email page 
    When I fill an email address under “To”
    And I drag an image into the page
    And I press “Send”
    Then the email is sent
