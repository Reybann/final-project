package com.cognizant.mortgagebankingrules.domain;
import java.util.UUID;

public class Rule {

    private UUID id;
    private String name;
    private boolean enabled;

    public Rule(UUID id, String name, boolean enabled) {
        this.id = id;
        this.name = name;
        this.enabled = enabled;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /*public class Rule {
    private UUID id;
    private OrderStatus status;
    //private List<OrderItem> orderItems;
    //private BigDecimal price;

    public Rule(UUID id, OrderStatus status) {
        this.id = id;
        this.status = OrderStatus.CREATED;
    }
    public void validateRule() {
            validateState();
            this.status = OrderStatus.CHECK;
        }
        public void addRule(Rule rule) {
        validateRule();
        ruleItems.add(new ruleItem(rule));
        name = name.add(rule.getName());
        enabled = enabled.add(rule.getStatus());
    }

    public void removeRule(UUID id) {
        validateState();
        final RuleItem ruleItem = getRuleItem(id);
        orderRule.remove(orderRule);
    }     // getters }*/


}
