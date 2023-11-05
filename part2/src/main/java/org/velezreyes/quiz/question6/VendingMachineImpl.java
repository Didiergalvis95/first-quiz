package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine{
  private double money;
  private Map<String, Double> prices;

  public static VendingMachine getInstance() {
    return new VendingMachineImpl();
  }

  @Override
  public void insertQuarter() {
    this.money += 0.25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    this.prices = new HashMap<>();
    this.prices.put("ScottCola", 0.75);
    this.prices.put("KarenTea", 1.0);
    
    if (this.prices.containsKey(name)) {
      if (this.money >= this.prices.get(name)) {
          this.money = 0;
          return new DrinkImpl(name);
      } else throw new NotEnoughMoneyException();
    } else throw new UnknownDrinkException();
  }
}
