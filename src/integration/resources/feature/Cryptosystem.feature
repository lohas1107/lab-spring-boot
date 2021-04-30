Feature: Encrypt and Decrypt with RSA

  Scenario: Press button to generate RSA key pair
    Given Navigate to cryptosystem page
    When I press button to generate RSA key pair
    Then I should be able to download key pair zip file