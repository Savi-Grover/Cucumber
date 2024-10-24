Feature: Verify the selected pricing tier appears in Active page.

  @leasepackage_activepage
  Scenario Outline: Verify Lease Package Pricing Tier
    Given I have signed up with a valid address "<email>" and "<password>"
    And I am on the Active page
    When I select a pricing tier "<leasePackName>"
    Then I should see the selected tier tile under the Lease package section
    And the lease package should show the latest selected pricing tier "<selectedpricingtiername>"

    Examples: 
      | email                  | password | leasePackName | selectedpricingtiername |
      | sadtier014@yopmail.com | Ford123! |               | $309.00/wk              |
